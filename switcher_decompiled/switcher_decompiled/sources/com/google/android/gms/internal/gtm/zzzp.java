package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzzp implements zzbfh {
    UNKNOWN_STRIPE_PATTERN(1),
    NO_STRIPE_PATTERN(2),
    LONGITUDINAL_STRIPE(3),
    DIAGONAL_STRIPE(4),
    LATERAL_STRIPE(5),
    SINGLE_CROSSING_LINE(6),
    DOUBLE_CROSSING_LINE(7),
    TRIANGLE_CROSSING_LINE_POINTING_LEFT(8),
    TRIANGLE_CROSSING_LINE_POINTING_RIGHT(9),
    STRUCTURED_CROSSING_LINE(10);

    private static final zzbfi zzk = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzzn
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzzp.zzb(i);
        }
    };
    private final int zzm;

    zzzp(int i) {
        this.zzm = i;
    }

    public static zzzp zzb(int i) {
        switch (i) {
            case 1:
                return UNKNOWN_STRIPE_PATTERN;
            case 2:
                return NO_STRIPE_PATTERN;
            case 3:
                return LONGITUDINAL_STRIPE;
            case 4:
                return DIAGONAL_STRIPE;
            case 5:
                return LATERAL_STRIPE;
            case 6:
                return SINGLE_CROSSING_LINE;
            case 7:
                return DOUBLE_CROSSING_LINE;
            case 8:
                return TRIANGLE_CROSSING_LINE_POINTING_LEFT;
            case 9:
                return TRIANGLE_CROSSING_LINE_POINTING_RIGHT;
            case 10:
                return STRUCTURED_CROSSING_LINE;
            default:
                return null;
        }
    }

    public static zzbfj zzc() {
        return zzzo.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzm);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzm;
    }
}
