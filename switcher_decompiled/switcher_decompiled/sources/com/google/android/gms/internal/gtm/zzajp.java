package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzajp implements zzbfh {
    NONE(0),
    STRING(1),
    INTEGER(2),
    DOUBLE(3),
    BOOLEAN(4),
    PROTO_VALUE(5),
    INT64(6),
    FLOAT(7),
    DISPLAY_ONLY(8),
    UINT32(9),
    ENUM_ID(10);

    private static final zzbfi zzl = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzajn
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzajp.zzb(i);
        }
    };
    private final int zzn;

    zzajp(int i) {
        this.zzn = i;
    }

    public static zzajp zzb(int i) {
        switch (i) {
            case 0:
                return NONE;
            case 1:
                return STRING;
            case 2:
                return INTEGER;
            case 3:
                return DOUBLE;
            case 4:
                return BOOLEAN;
            case 5:
                return PROTO_VALUE;
            case 6:
                return INT64;
            case 7:
                return FLOAT;
            case 8:
                return DISPLAY_ONLY;
            case 9:
                return UINT32;
            case 10:
                return ENUM_ID;
            default:
                return null;
        }
    }

    public static zzbfj zzc() {
        return zzajo.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzn);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzn;
    }
}
