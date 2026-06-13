package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbo implements Runnable {
    final /* synthetic */ zzez zza;
    final /* synthetic */ zzbs zzb;

    zzbo(zzbs zzbsVar, zzez zzezVar) {
        this.zzb = zzbsVar;
        this.zza = zzezVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.zzb.zza.zzj(this.zza);
    }
}
