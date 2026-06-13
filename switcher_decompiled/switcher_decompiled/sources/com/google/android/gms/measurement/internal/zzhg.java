package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzhg implements Runnable {
    final /* synthetic */ zzid zza;

    zzhg(zzid zzidVar) {
        this.zza = zzidVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb.zzb();
    }
}
