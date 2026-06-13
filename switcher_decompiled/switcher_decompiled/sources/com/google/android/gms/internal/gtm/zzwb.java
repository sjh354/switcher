package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzwb implements zzbfh {
    TYPE_NULL(0),
    TYPE_ID(1),
    TYPE_TEXT(2),
    TYPE_ENUM(3),
    TYPE_KEY(4),
    TYPE_URI(5),
    TYPE_DATETIME(6),
    TYPE_BOOL(7),
    TYPE_INT(8),
    TYPE_FLOAT(9),
    TYPE_COMPOUND(10),
    TYPE_PROTO(11),
    TYPE_EXTENSION(16),
    TYPE_NESTED_STRUCT(17),
    TYPE_LAT_LONG(14),
    TYPE_MEASUREMENT(15),
    TYPE_HAS_VALUE(12),
    TYPE_HAS_NO_VALUE(13);

    private static final zzbfi zzs = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzvz
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzwb.zzb(i);
        }
    };
    private final int zzu;

    zzwb(int i) {
        this.zzu = i;
    }

    public static zzwb zzb(int i) {
        switch (i) {
            case 0:
                return TYPE_NULL;
            case 1:
                return TYPE_ID;
            case 2:
                return TYPE_TEXT;
            case 3:
                return TYPE_ENUM;
            case 4:
                return TYPE_KEY;
            case 5:
                return TYPE_URI;
            case 6:
                return TYPE_DATETIME;
            case 7:
                return TYPE_BOOL;
            case 8:
                return TYPE_INT;
            case 9:
                return TYPE_FLOAT;
            case 10:
                return TYPE_COMPOUND;
            case 11:
                return TYPE_PROTO;
            case 12:
                return TYPE_HAS_VALUE;
            case 13:
                return TYPE_HAS_NO_VALUE;
            case 14:
                return TYPE_LAT_LONG;
            case 15:
                return TYPE_MEASUREMENT;
            case 16:
                return TYPE_EXTENSION;
            case 17:
                return TYPE_NESTED_STRUCT;
            default:
                return null;
        }
    }

    public static zzbfj zzc() {
        return zzwa.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzu);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzu;
    }
}
