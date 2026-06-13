package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgj implements Runnable {
    final /* synthetic */ zzaw zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ zzgq zzc;

    zzgj(zzgq zzgqVar, zzaw zzawVar, zzq zzqVar) {
        this.zzc = zzgqVar;
        this.zza = zzawVar;
        this.zzb = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzv(this.zzc.zzb(this.zza, this.zzb), this.zzb);
    }
}
