package com.google.firebase.messaging;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
class RequestDeduplicator {
    private final Executor executor;
    private final Map<String, Task<String>> getTokenRequests = new ArrayMap();

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
    interface GetTokenRequest {
        Task<String> start();
    }

    RequestDeduplicator(Executor executor) {
        this.executor = executor;
    }

    synchronized Task<String> getOrStartGetTokenRequest(final String str, GetTokenRequest getTokenRequest) {
        Task<String> task = this.getTokenRequests.get(str);
        if (task != null) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                String strValueOf = String.valueOf(str);
                Log.d(Constants.TAG, strValueOf.length() != 0 ? "Joining ongoing request for: ".concat(strValueOf) : new String("Joining ongoing request for: "));
            }
            return task;
        }
        if (Log.isLoggable(Constants.TAG, 3)) {
            String strValueOf2 = String.valueOf(str);
            Log.d(Constants.TAG, strValueOf2.length() != 0 ? "Making new request for: ".concat(strValueOf2) : new String("Making new request for: "));
        }
        Task taskContinueWithTask = getTokenRequest.start().continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.messaging.RequestDeduplicator$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) throws Exception {
                this.f$0.m127x7161fc54(str, task2);
                return task2;
            }
        });
        this.getTokenRequests.put(str, (Task<String>) taskContinueWithTask);
        return taskContinueWithTask;
    }

    /* JADX INFO: renamed from: lambda$getOrStartGetTokenRequest$0$com-google-firebase-messaging-RequestDeduplicator, reason: not valid java name */
    /* synthetic */ Task m127x7161fc54(String str, Task task) throws Exception {
        synchronized (this) {
            this.getTokenRequests.remove(str);
        }
        return task;
    }
}
