package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzhl implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzid zzb;

    zzhl(zzid zzidVar, long j) {
        this.zzb = zzidVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzL(this.zza, true);
        this.zzb.zzs.zzt().zzu(new AtomicReference());
    }
}
