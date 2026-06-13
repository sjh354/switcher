package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzhp implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzid zzb;

    zzhp(zzid zzidVar, AtomicReference atomicReference) {
        this.zzb = zzidVar;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Boolean.valueOf(this.zzb.zzs.zzf().zzs(this.zzb.zzs.zzh().zzl(), zzeb.zzJ)));
            } finally {
                this.zza.notify();
            }
        }
    }
}
