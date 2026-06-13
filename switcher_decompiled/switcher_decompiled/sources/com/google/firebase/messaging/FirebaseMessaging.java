package com.google.firebase.messaging;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.RequestDeduplicator;
import com.google.firebase.messaging.Store;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseMessaging {

    @Deprecated
    public static final String INSTANCE_ID_SCOPE = "FCM";
    private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    private static Store store;
    static ScheduledExecutorService syncExecutor;
    static TransportFactory transportFactory;
    private final AutoInit autoInit;
    private final Context context;
    private final Executor fileIoExecutor;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi fis;
    private final GmsRpc gmsRpc;
    private final FirebaseInstanceIdInternal iid;
    private final Application.ActivityLifecycleCallbacks lifecycleCallbacks;
    private final Metadata metadata;
    private final RequestDeduplicator requestDeduplicator;
    private boolean syncScheduledOrRunning;
    private final Executor taskExecutor;
    private final Task<TopicsSubscriber> topicsSubscriberTask;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
    class AutoInit {
        private Boolean autoInitEnabled;
        private EventHandler<DataCollectionDefaultChange> dataCollectionDefaultChangeEventHandler;
        private boolean initialized;
        private final Subscriber subscriber;

        AutoInit(Subscriber subscriber) {
            this.subscriber = subscriber;
        }

        private Boolean readEnabled() {
            ApplicationInfo applicationInfo;
            Context applicationContext = FirebaseMessaging.this.firebaseApp.getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        synchronized void initialize() {
            if (this.initialized) {
                return;
            }
            Boolean enabled = readEnabled();
            this.autoInitEnabled = enabled;
            if (enabled == null) {
                EventHandler<DataCollectionDefaultChange> eventHandler = new EventHandler() { // from class: com.google.firebase.messaging.FirebaseMessaging$AutoInit$$ExternalSyntheticLambda0
                    @Override // com.google.firebase.events.EventHandler
                    public final void handle(Event event) {
                        this.f$0.m125x1061f0b8(event);
                    }
                };
                this.dataCollectionDefaultChangeEventHandler = eventHandler;
                this.subscriber.subscribe(DataCollectionDefaultChange.class, eventHandler);
            }
            this.initialized = true;
        }

        synchronized boolean isEnabled() {
            Boolean bool;
            initialize();
            bool = this.autoInitEnabled;
            return bool != null ? bool.booleanValue() : FirebaseMessaging.this.firebaseApp.isDataCollectionDefaultEnabled();
        }

        /* JADX INFO: renamed from: lambda$initialize$0$com-google-firebase-messaging-FirebaseMessaging$AutoInit, reason: not valid java name */
        /* synthetic */ void m125x1061f0b8(Event event) {
            if (isEnabled()) {
                FirebaseMessaging.this.startSyncIfNecessary();
            }
        }

        synchronized void setEnabled(boolean z) {
            initialize();
            EventHandler<DataCollectionDefaultChange> eventHandler = this.dataCollectionDefaultChangeEventHandler;
            if (eventHandler != null) {
                this.subscriber.unsubscribe(DataCollectionDefaultChange.class, eventHandler);
                this.dataCollectionDefaultChangeEventHandler = null;
            }
            SharedPreferences.Editor editorEdit = FirebaseMessaging.this.firebaseApp.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
            editorEdit.putBoolean("auto_init", z);
            editorEdit.apply();
            if (z) {
                FirebaseMessaging.this.startSyncIfNecessary();
            }
            this.autoInitEnabled = Boolean.valueOf(z);
        }
    }

    FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, TransportFactory transportFactory2, Subscriber subscriber) {
        this(firebaseApp, firebaseInstanceIdInternal, provider, provider2, firebaseInstallationsApi, transportFactory2, subscriber, new Metadata(firebaseApp.getApplicationContext()));
    }

    public static synchronized FirebaseMessaging getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    private static synchronized Store getStore(Context context) {
        if (store == null) {
            store = new Store(context);
        }
        return store;
    }

    private String getSubtype() {
        return FirebaseApp.DEFAULT_APP_NAME.equals(this.firebaseApp.getName()) ? "" : this.firebaseApp.getPersistenceKey();
    }

    public static TransportFactory getTransportFactory() {
        return transportFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeOnTokenRefresh(String str) {
        if (FirebaseApp.DEFAULT_APP_NAME.equals(this.firebaseApp.getName())) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                String strValueOf = String.valueOf(this.firebaseApp.getName());
                Log.d(Constants.TAG, strValueOf.length() != 0 ? "Invoking onNewToken for app: ".concat(strValueOf) : new String("Invoking onNewToken for app: "));
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new FcmBroadcastProcessor(this.context).process(intent);
        }
    }

    private synchronized void startSync() {
        if (this.syncScheduledOrRunning) {
            return;
        }
        syncWithDelaySecondsInternal(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSyncIfNecessary() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.getToken();
        } else if (tokenNeedsRefresh(getTokenWithoutTriggeringSync())) {
            startSync();
        }
    }

    String blockingGetToken() throws IOException {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            try {
                return (String) Tasks.await(firebaseInstanceIdInternal.getTokenTask());
            } catch (InterruptedException | ExecutionException e) {
                throw new IOException(e);
            }
        }
        final Store.Token tokenWithoutTriggeringSync = getTokenWithoutTriggeringSync();
        if (!tokenNeedsRefresh(tokenWithoutTriggeringSync)) {
            return tokenWithoutTriggeringSync.token;
        }
        final String defaultSenderId = Metadata.getDefaultSenderId(this.firebaseApp);
        try {
            return (String) Tasks.await(this.requestDeduplicator.getOrStartGetTokenRequest(defaultSenderId, new RequestDeduplicator.GetTokenRequest() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda5
                @Override // com.google.firebase.messaging.RequestDeduplicator.GetTokenRequest
                public final Task start() {
                    return this.f$0.m118xa77f119c(defaultSenderId, tokenWithoutTriggeringSync);
                }
            }));
        } catch (InterruptedException | ExecutionException e2) {
            throw new IOException(e2);
        }
    }

    public Task<Void> deleteToken() {
        if (this.iid != null) {
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.fileIoExecutor.execute(new Runnable() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m119xd74d2373(taskCompletionSource);
                }
            });
            return taskCompletionSource.getTask();
        }
        if (getTokenWithoutTriggeringSync() == null) {
            return Tasks.forResult(null);
        }
        final TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        FcmExecutors.newNetworkIOExecutor().execute(new Runnable() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m120xd6d6bd74(taskCompletionSource2);
            }
        });
        return taskCompletionSource2.getTask();
    }

    public boolean deliveryMetricsExportToBigQueryEnabled() {
        return MessagingAnalytics.deliveryMetricsExportToBigQueryEnabled();
    }

    void enqueueTaskWithDelaySeconds(Runnable runnable, long j) {
        synchronized (FirebaseMessaging.class) {
            if (syncExecutor == null) {
                syncExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("TAG"));
            }
            syncExecutor.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    Context getApplicationContext() {
        return this.context;
    }

    public Task<String> getToken() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            return firebaseInstanceIdInternal.getTokenTask();
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.fileIoExecutor.execute(new Runnable() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m121x6c2cd681(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    Store.Token getTokenWithoutTriggeringSync() {
        return getStore(this.context).getToken(getSubtype(), Metadata.getDefaultSenderId(this.firebaseApp));
    }

    public boolean isAutoInitEnabled() {
        return this.autoInit.isEnabled();
    }

    boolean isGmsCorePresent() {
        return this.metadata.isGmscorePresent();
    }

    public boolean isNotificationDelegationEnabled() {
        return ProxyNotificationInitializer.isProxyNotificationEnabled(this.context);
    }

    /* JADX INFO: renamed from: lambda$blockingGetToken$8$com-google-firebase-messaging-FirebaseMessaging, reason: not valid java name */
    /* synthetic */ Task m117xa7f5779b(String str, Store.Token token, String str2) throws Exception {
        getStore(this.context).saveToken(getSubtype(), str, str2, this.metadata.getAppVersionCode());
        if (token == null || !str2.equals(token.token)) {
            invokeOnTokenRefresh(str2);
        }
        return Tasks.forResult(str2);
    }

    /* JADX INFO: renamed from: lambda$blockingGetToken$9$com-google-firebase-messaging-FirebaseMessaging, reason: not valid java name */
    /* synthetic */ Task m118xa77f119c(final String str, final Store.Token token) {
        return this.gmsRpc.getToken().onSuccessTask(new Executor() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda11
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                runnable.run();
            }
        }, new SuccessContinuation() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.f$0.m117xa7f5779b(str, token, (String) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$deleteToken$4$com-google-firebase-messaging-FirebaseMessaging, reason: not valid java name */
    /* synthetic */ void m119xd74d2373(TaskCompletionSource taskCompletionSource) {
        try {
            this.iid.deleteToken(Metadata.getDefaultSenderId(this.firebaseApp), INSTANCE_ID_SCOPE);
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    /* JADX INFO: renamed from: lambda$deleteToken$5$com-google-firebase-messaging-FirebaseMessaging, reason: not valid java name */
    /* synthetic */ void m120xd6d6bd74(TaskCompletionSource taskCompletionSource) {
        try {
            Tasks.await(this.gmsRpc.deleteToken());
            getStore(this.context).deleteToken(getSubtype(), Metadata.getDefaultSenderId(this.firebaseApp));
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    /* JADX INFO: renamed from: lambda$getToken$3$com-google-firebase-messaging-FirebaseMessaging, reason: not valid java name */
    /* synthetic */ void m121x6c2cd681(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(blockingGetToken());
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    /* JADX INFO: renamed from: lambda$new$0$com-google-firebase-messaging-FirebaseMessaging, reason: not valid java name */
    /* synthetic */ void m122lambda$new$0$comgooglefirebasemessagingFirebaseMessaging() {
        if (isAutoInitEnabled()) {
            startSyncIfNecessary();
        }
    }

    /* JADX INFO: renamed from: lambda$new$1$com-google-firebase-messaging-FirebaseMessaging, reason: not valid java name */
    /* synthetic */ void m123lambda$new$1$comgooglefirebasemessagingFirebaseMessaging(TopicsSubscriber topicsSubscriber) {
        if (isAutoInitEnabled()) {
            topicsSubscriber.startTopicsSyncIfNecessary();
        }
    }

    /* JADX INFO: renamed from: lambda$new$2$com-google-firebase-messaging-FirebaseMessaging, reason: not valid java name */
    /* synthetic */ void m124lambda$new$2$comgooglefirebasemessagingFirebaseMessaging() {
        ProxyNotificationInitializer.initialize(this.context);
    }

    public void send(RemoteMessage remoteMessage) {
        if (TextUtils.isEmpty(remoteMessage.getTo())) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        Intent intent2 = new Intent();
        intent2.setPackage("com.google.example.invalidpackage");
        intent.putExtra("app", PendingIntent.getBroadcast(this.context, 0, intent2, Build.VERSION.SDK_INT >= 23 ? 67108864 : 0));
        intent.setPackage("com.google.android.gms");
        remoteMessage.populateSendMessageIntent(intent);
        this.context.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    public void setAutoInitEnabled(boolean z) {
        this.autoInit.setEnabled(z);
    }

    public void setDeliveryMetricsExportToBigQuery(boolean z) {
        MessagingAnalytics.setDeliveryMetricsExportToBigQuery(z);
    }

    public Task<Void> setNotificationDelegationEnabled(boolean z) {
        return ProxyNotificationInitializer.setEnableProxyNotification(this.fileIoExecutor, this.context, z);
    }

    synchronized void setSyncScheduledOrRunning(boolean z) {
        this.syncScheduledOrRunning = z;
    }

    public Task<Void> subscribeToTopic(final String str) {
        return this.topicsSubscriberTask.onSuccessTask(new SuccessContinuation() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return ((TopicsSubscriber) obj).subscribeToTopic(str);
            }
        });
    }

    synchronized void syncWithDelaySecondsInternal(long j) {
        enqueueTaskWithDelaySeconds(new SyncTask(this, Math.min(Math.max(30L, j + j), MAX_DELAY_SEC)), j);
        this.syncScheduledOrRunning = true;
    }

    boolean tokenNeedsRefresh(Store.Token token) {
        return token == null || token.needsRefresh(this.metadata.getAppVersionCode());
    }

    public Task<Void> unsubscribeFromTopic(final String str) {
        return this.topicsSubscriberTask.onSuccessTask(new SuccessContinuation() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return ((TopicsSubscriber) obj).unsubscribeFromTopic(str);
            }
        });
    }

    static synchronized FirebaseMessaging getInstance(FirebaseApp firebaseApp) {
        FirebaseMessaging firebaseMessaging;
        firebaseMessaging = (FirebaseMessaging) firebaseApp.get(FirebaseMessaging.class);
        Preconditions.checkNotNull(firebaseMessaging, "Firebase Messaging component is not present");
        return firebaseMessaging;
    }

    FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, TransportFactory transportFactory2, Subscriber subscriber, Metadata metadata) {
        this(firebaseApp, firebaseInstanceIdInternal, firebaseInstallationsApi, transportFactory2, subscriber, metadata, new GmsRpc(firebaseApp, metadata, provider, provider2, firebaseInstallationsApi), FcmExecutors.newTaskExecutor(), FcmExecutors.newInitExecutor());
    }

    FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceIdInternal firebaseInstanceIdInternal, FirebaseInstallationsApi firebaseInstallationsApi, TransportFactory transportFactory2, Subscriber subscriber, Metadata metadata, GmsRpc gmsRpc, Executor executor, Executor executor2) {
        this.syncScheduledOrRunning = false;
        transportFactory = transportFactory2;
        this.firebaseApp = firebaseApp;
        this.iid = firebaseInstanceIdInternal;
        this.fis = firebaseInstallationsApi;
        this.autoInit = new AutoInit(subscriber);
        Context applicationContext = firebaseApp.getApplicationContext();
        this.context = applicationContext;
        FcmLifecycleCallbacks fcmLifecycleCallbacks = new FcmLifecycleCallbacks();
        this.lifecycleCallbacks = fcmLifecycleCallbacks;
        this.metadata = metadata;
        this.taskExecutor = executor;
        this.gmsRpc = gmsRpc;
        this.requestDeduplicator = new RequestDeduplicator(executor);
        this.fileIoExecutor = executor2;
        Context applicationContext2 = firebaseApp.getApplicationContext();
        if (applicationContext2 instanceof Application) {
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(fcmLifecycleCallbacks);
        } else {
            String strValueOf = String.valueOf(applicationContext2);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 125);
            sb.append("Context ");
            sb.append(strValueOf);
            sb.append(" was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
            Log.w(Constants.TAG, sb.toString());
        }
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.addNewTokenListener(new FirebaseInstanceIdInternal.NewTokenListener() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda4
                @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal.NewTokenListener
                public final void onNewToken(String str) {
                    this.f$0.invokeOnTokenRefresh(str);
                }
            });
        }
        executor2.execute(new Runnable() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m122lambda$new$0$comgooglefirebasemessagingFirebaseMessaging();
            }
        });
        Task<TopicsSubscriber> taskCreateInstance = TopicsSubscriber.createInstance(this, metadata, gmsRpc, applicationContext, FcmExecutors.newTopicsSyncExecutor());
        this.topicsSubscriberTask = taskCreateInstance;
        taskCreateInstance.addOnSuccessListener(executor2, new OnSuccessListener() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f$0.m123lambda$new$1$comgooglefirebasemessagingFirebaseMessaging((TopicsSubscriber) obj);
            }
        });
        executor2.execute(new Runnable() { // from class: com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m124lambda$new$2$comgooglefirebasemessagingFirebaseMessaging();
            }
        });
    }
}
