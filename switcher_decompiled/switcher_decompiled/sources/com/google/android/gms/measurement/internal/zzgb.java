package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgb implements Runnable {
    final /* synthetic */ zzac zza;
    final /* synthetic */ zzgq zzb;

    zzgb(zzgq zzgqVar, zzac zzacVar) {
        this.zzb = zzgqVar;
        this.zza = zzacVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzA();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzN(this.zza);
        } else {
            this.zzb.zza.zzT(this.zza);
        }
    }
}
