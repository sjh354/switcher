package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzj implements Runnable {
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf zza;
    final /* synthetic */ zzaw zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ AppMeasurementDynamiteService zzd;

    zzj(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcf zzcfVar, zzaw zzawVar, String str) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzcfVar;
        this.zzb = zzawVar;
        this.zzc = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zza.zzt().zzB(this.zza, this.zzb, this.zzc);
    }
}
