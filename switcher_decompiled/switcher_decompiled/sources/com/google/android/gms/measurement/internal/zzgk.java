package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgk implements Runnable {
    final /* synthetic */ zzaw zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgq zzc;

    zzgk(zzgq zzgqVar, zzaw zzawVar, String str) {
        this.zzc = zzgqVar;
        this.zza = zzawVar;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzA();
        this.zzc.zza.zzF(this.zza, this.zzb);
    }
}
