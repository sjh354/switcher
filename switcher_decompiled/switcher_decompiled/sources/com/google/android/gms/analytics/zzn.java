package com.google.android.gms.analytics;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzn extends ThreadPoolExecutor {
    final /* synthetic */ zzr zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzn(zzr zzrVar) {
        super(1, 1, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());
        this.zza = zzrVar;
        setThreadFactory(new zzp(null));
        allowCoreThreadTimeOut(true);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return new zzm(this, runnable, obj);
    }
}
