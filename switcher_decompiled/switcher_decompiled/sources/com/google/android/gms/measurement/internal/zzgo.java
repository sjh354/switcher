package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgo implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzgq zzb;

    zzgo(zzgq zzgqVar, zzq zzqVar) {
        this.zzb = zzgqVar;
        this.zza = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzA();
        this.zzb.zza.zzL(this.zza);
    }
}
