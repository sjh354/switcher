package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbl implements Runnable {
    final /* synthetic */ zzbs zza;

    zzbl(zzbs zzbsVar, boolean z) {
        this.zza = zzbsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza.zzad();
    }
}
