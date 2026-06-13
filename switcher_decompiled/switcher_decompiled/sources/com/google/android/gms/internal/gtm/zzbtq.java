package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbtq implements zzbfh {
    TIER_UNKNOWN(0),
    UNSUPPORTED(1),
    SILVER(2),
    GOLD(3),
    DIAMOND(4);

    private static final zzbfi zzf = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbto
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbtq.zzc(i);
        }
    };
    private final int zzh;

    zzbtq(int i) {
        this.zzh = i;
    }

    public static zzbfj zzb() {
        return zzbtp.zza;
    }

    public static zzbtq zzc(int i) {
        if (i == 0) {
            return TIER_UNKNOWN;
        }
        if (i == 1) {
            return UNSUPPORTED;
        }
        if (i == 2) {
            return SILVER;
        }
        if (i == 3) {
            return GOLD;
        }
        if (i != 4) {
            return null;
        }
        return DIAMOND;
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
