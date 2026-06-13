package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbm implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ Runnable zzb;
    final /* synthetic */ zzbs zzc;

    zzbm(zzbs zzbsVar, String str, Runnable runnable) {
        this.zzc = zzbsVar;
        this.zza = str;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzn(this.zza);
        this.zzb.run();
    }
}
