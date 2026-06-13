package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbn implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzbs zzb;

    zzbn(zzbs zzbsVar, int i) {
        this.zzb = zzbsVar;
        this.zza = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzY(((long) this.zza) * 1000);
    }
}
