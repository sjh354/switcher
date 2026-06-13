package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbdw implements zzbfh {
    NONE(0),
    INTEGRITY(1),
    PRIVACY_AND_INTEGRITY(2),
    STRONG_PRIVACY_AND_INTEGRITY(3);

    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbdu
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbdw.zzb(i);
        }
    };
    private final int zzg;

    zzbdw(int i) {
        this.zzg = i;
    }

    public static zzbdw zzb(int i) {
        if (i == 0) {
            return NONE;
        }
        if (i == 1) {
            return INTEGRITY;
        }
        if (i == 2) {
            return PRIVACY_AND_INTEGRITY;
        }
        if (i != 3) {
            return null;
        }
        return STRONG_PRIVACY_AND_INTEGRITY;
    }

    public static zzbfj zzc() {
        return zzbdv.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzg);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzg;
    }
}
