package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbsa implements zzbfh {
    UNKNOWN_CATEGORY(0),
    END_TO_END(1),
    INGESTED_BUT_NOT_SERVED(2),
    MATERIALIZED_AND_SERVED(3),
    INTERNAL_KG_USE_ONLY(4);

    private static final zzbfi zzf = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbrz
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbsa.zzc(i);
        }
    };
    private final int zzh;

    zzbsa(int i) {
        this.zzh = i;
    }

    public static zzbfi zzb() {
        return zzf;
    }

    public static zzbsa zzc(int i) {
        if (i == 0) {
            return UNKNOWN_CATEGORY;
        }
        if (i == 1) {
            return END_TO_END;
        }
        if (i == 2) {
            return INGESTED_BUT_NOT_SERVED;
        }
        if (i == 3) {
            return MATERIALIZED_AND_SERVED;
        }
        if (i != 4) {
            return null;
        }
        return INTERNAL_KG_USE_ONLY;
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
