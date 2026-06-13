package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzca extends zzcy {
    final /* synthetic */ zzce zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzca(zzce zzceVar, zzbx zzbxVar) {
        super(zzbxVar);
        this.zza = zzceVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzcy
    public final void zza() {
        zzce zzceVar = this.zza;
        com.google.android.gms.analytics.zzr.zzh();
        if (zzceVar.zzg()) {
            zzceVar.zzN("Inactivity, disconnecting from device AnalyticsService");
            zzceVar.zzc();
        }
    }
}
