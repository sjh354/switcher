package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbrl implements zzbfh {
    DEFAULT_FORMAT(0),
    DATE(1),
    TIMESTAMP_SECONDS(2),
    TIMESTAMP_MILLIS(3),
    TIMESTAMP_MICROS(4),
    TIMESTAMP_NANOS(5),
    DATE_DECIMAL(6),
    TIME_MICROS(7),
    DATETIME_MICROS(8),
    ST_GEOGRAPHY_ENCODED(9),
    NUMERIC(10),
    BIGNUMERIC(11),
    JSON(12),
    INTERVAL(14),
    TOKENLIST(15),
    __FieldFormat_Type__switch_must_have_a_default__(-1);

    private static final zzbfi zzq = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbrk
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbrl.zzc(i);
        }
    };
    private final int zzs;

    zzbrl(int i) {
        this.zzs = i;
    }

    public static zzbfi zzb() {
        return zzq;
    }

    public static zzbrl zzc(int i) {
        switch (i) {
            case -1:
                return __FieldFormat_Type__switch_must_have_a_default__;
            case 0:
                return DEFAULT_FORMAT;
            case 1:
                return DATE;
            case 2:
                return TIMESTAMP_SECONDS;
            case 3:
                return TIMESTAMP_MILLIS;
            case 4:
                return TIMESTAMP_MICROS;
            case 5:
                return TIMESTAMP_NANOS;
            case 6:
                return DATE_DECIMAL;
            case 7:
                return TIME_MICROS;
            case 8:
                return DATETIME_MICROS;
            case 9:
                return ST_GEOGRAPHY_ENCODED;
            case 10:
                return NUMERIC;
            case 11:
                return BIGNUMERIC;
            case 12:
                return JSON;
            case 13:
            default:
                return null;
            case 14:
                return INTERVAL;
            case 15:
                return TOKENLIST;
        }
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzs);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzs;
    }
}
