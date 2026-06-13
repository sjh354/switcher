package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzch extends zzbu {
    private final zzax zza;

    zzch(zzbx zzbxVar) {
        super(zzbxVar);
        this.zza = new zzax();
    }

    public final zzax zza() {
        zzV();
        return this.zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
        zzq().zzc().zzc(this.zza);
        zzfv zzfvVarZzB = zzB();
        zzfvVarZzB.zzV();
        String str = zzfvVarZzB.zzb;
        if (str != null) {
            this.zza.zzk(str);
        }
        zzfvVarZzB.zzV();
        String str2 = zzfvVarZzB.zza;
        if (str2 != null) {
            this.zza.zzl(str2);
        }
    }
}
