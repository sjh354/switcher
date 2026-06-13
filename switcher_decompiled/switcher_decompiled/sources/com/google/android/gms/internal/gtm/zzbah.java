package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbah implements zzbfh {
    UNSPECIFIED(0),
    FROM_NUMBER_WITH_PLUS_SIGN(1),
    FROM_NUMBER_WITH_IDD(5),
    FROM_NUMBER_WITHOUT_PLUS_SIGN(10),
    FROM_DEFAULT_COUNTRY(20);

    private static final zzbfi zzf = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbaf
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbah.zzb(i);
        }
    };
    private final int zzh;

    zzbah(int i) {
        this.zzh = i;
    }

    public static zzbah zzb(int i) {
        if (i == 0) {
            return UNSPECIFIED;
        }
        if (i == 1) {
            return FROM_NUMBER_WITH_PLUS_SIGN;
        }
        if (i == 5) {
            return FROM_NUMBER_WITH_IDD;
        }
        if (i == 10) {
            return FROM_NUMBER_WITHOUT_PLUS_SIGN;
        }
        if (i != 20) {
            return null;
        }
        return FROM_DEFAULT_COUNTRY;
    }

    public static zzbfj zzc() {
        return zzbag.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzh);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzh;
    }
}
