package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbq implements Runnable {
    final /* synthetic */ zzdb zza;
    final /* synthetic */ zzbs zzb;

    zzbq(zzbs zzbsVar, zzdb zzdbVar) {
        this.zzb = zzbsVar;
        this.zza = zzdbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzf(this.zza);
    }
}
