package com.google.android.gms.analytics;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzp implements ThreadFactory {
    private static final AtomicInteger zza = new AtomicInteger();

    private zzp() {
    }

    /* synthetic */ zzp(zzo zzoVar) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new zzq(runnable, "measurement-" + zza.incrementAndGet());
    }
}
