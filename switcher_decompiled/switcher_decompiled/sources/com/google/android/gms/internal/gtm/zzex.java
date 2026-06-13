package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzex implements zzct {
    private final zzbx zza;
    private final zzey zzb = new zzey();

    public zzex(zzbx zzbxVar) {
        this.zza = zzbxVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzct
    public final /* synthetic */ zzcs zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.gtm.zzct
    public final void zzb(String str, String str2) {
    }

    @Override // com.google.android.gms.internal.gtm.zzct
    public final void zzc(String str, boolean z) {
        if (!"ga_dryRun".equals(str)) {
            this.zza.zzm().zzR("Bool xml configuration name not recognized", str);
        } else {
            this.zzb.zze = z ? 1 : 0;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzct
    public final void zzd(String str, int i) {
        if ("ga_dispatchPeriod".equals(str)) {
            this.zzb.zzd = i;
        } else {
            this.zza.zzm().zzR("Int xml configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzct
    public final void zze(String str, String str2) {
        if ("ga_appName".equals(str)) {
            this.zzb.zza = str2;
            return;
        }
        if ("ga_appVersion".equals(str)) {
            this.zzb.zzb = str2;
        } else if ("ga_logLevel".equals(str)) {
            this.zzb.zzc = str2;
        } else {
            this.zza.zzm().zzR("String xml configuration name not recognized", str);
        }
    }
}
