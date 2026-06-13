package com.google.android.gms.tagmanager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzaz implements Runnable {
    final /* synthetic */ zzav zza;
    final /* synthetic */ zzbd zzb;

    zzaz(zzbd zzbdVar, zzav zzavVar) {
        this.zzb = zzbdVar;
        this.zza = zzavVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza(zzbd.zzf(this.zzb));
    }
}
