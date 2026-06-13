package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzhv implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzid zzb;

    zzhv(zzid zzidVar, AtomicReference atomicReference) {
        this.zzb = zzidVar;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Double.valueOf(this.zzb.zzs.zzf().zza(this.zzb.zzs.zzh().zzl(), zzeb.zzN)));
            } finally {
                this.zza.notify();
            }
        }
    }
}
