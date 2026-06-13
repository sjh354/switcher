package com.google.android.gms.tagmanager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzba implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbd zzb;

    zzba(zzbd zzbdVar, String str) {
        this.zzb = zzbdVar;
        this.zza = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbd.zzg(this.zzb, this.zza);
    }
}
