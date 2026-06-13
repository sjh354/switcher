package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.Constants;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public class FcmBroadcastProcessor {
    private static WithinAppServiceConnection fcmServiceConn;
    private static final Object lock = new Object();
    private final Context context;
    private final Executor executor;

    public FcmBroadcastProcessor(Context context) {
        this.context = context;
        this.executor = FcmBroadcastProcessor$$ExternalSyntheticLambda4.INSTANCE;
    }

    public FcmBroadcastProcessor(Context context, ExecutorService executorService) {
        this.context = context;
        this.executor = executorService;
    }

    private static Task<Integer> bindToMessagingService(Context context, Intent intent) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            Log.d(Constants.TAG, "Binding to service");
        }
        return getServiceConnection(context, "com.google.firebase.MESSAGING_EVENT").sendIntent(intent).continueWith(FcmBroadcastProcessor$$ExternalSyntheticLambda4.INSTANCE, new Continuation() { // from class: com.google.firebase.messaging.FcmBroadcastProcessor$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return FcmBroadcastProcessor.lambda$bindToMessagingService$3(task);
            }
        });
    }

    private static WithinAppServiceConnection getServiceConnection(Context context, String str) {
        WithinAppServiceConnection withinAppServiceConnection;
        synchronized (lock) {
            if (fcmServiceConn == null) {
                fcmServiceConn = new WithinAppServiceConnection(context, "com.google.firebase.MESSAGING_EVENT");
            }
            withinAppServiceConnection = fcmServiceConn;
        }
        return withinAppServiceConnection;
    }

    static /* synthetic */ Integer lambda$bindToMessagingService$3(Task task) throws Exception {
        return -1;
    }

    static /* synthetic */ Integer lambda$startMessagingService$1(Task task) throws Exception {
        return 403;
    }

    static /* synthetic */ Task lambda$startMessagingService$2(Context context, Intent intent, Task task) throws Exception {
        return (PlatformVersion.isAtLeastO() && ((Integer) task.getResult()).intValue() == 402) ? bindToMessagingService(context, intent).continueWith(FcmBroadcastProcessor$$ExternalSyntheticLambda4.INSTANCE, new Continuation() { // from class: com.google.firebase.messaging.FcmBroadcastProcessor$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return FcmBroadcastProcessor.lambda$startMessagingService$1(task2);
            }
        }) : task;
    }

    public static void reset() {
        synchronized (lock) {
            fcmServiceConn = null;
        }
    }

    public Task<Integer> process(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra(Constants.MessagePayloadKeys.RAW_DATA, Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return startMessagingService(this.context, intent);
    }

    public Task<Integer> startMessagingService(final Context context, final Intent intent) {
        boolean z = false;
        if (PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26) {
            z = true;
        }
        return (z && (intent.getFlags() & 268435456) == 0) ? bindToMessagingService(context, intent) : Tasks.call(this.executor, new Callable() { // from class: com.google.firebase.messaging.FcmBroadcastProcessor$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(ServiceStarter.getInstance().startMessagingService(context, intent));
            }
        }).continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.messaging.FcmBroadcastProcessor$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return FcmBroadcastProcessor.lambda$startMessagingService$2(context, intent, task);
            }
        });
    }
}
