package com.google.android.gms.internal.gtm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzga implements zzfy {
    private zzga() {
    }

    /* synthetic */ zzga(zzfz zzfzVar) {
    }

    @Override // com.google.android.gms.internal.gtm.zzfy
    public final ExecutorService zza(int i) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    @Override // com.google.android.gms.internal.gtm.zzfy
    public final ScheduledExecutorService zzb(int i, int i2) {
        return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
    }
}
