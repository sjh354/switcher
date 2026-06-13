package com.google.firebase.messaging;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FcmBroadcastProcessor$$ExternalSyntheticLambda4 implements Executor {
    public static final /* synthetic */ FcmBroadcastProcessor$$ExternalSyntheticLambda4 INSTANCE = new FcmBroadcastProcessor$$ExternalSyntheticLambda4();

    private /* synthetic */ FcmBroadcastProcessor$$ExternalSyntheticLambda4() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
