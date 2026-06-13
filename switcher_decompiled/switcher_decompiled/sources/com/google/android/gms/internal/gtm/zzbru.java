package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbru implements zzbfh {
    ID(0),
    TEXT(1),
    DATETIME(2),
    BOOLEAN(3),
    INT(4),
    RAWSTRING(5),
    URL(6),
    KEY(7),
    FLOAT(8),
    PROTO(9),
    NESTED_STRUCT(10);

    private static final zzbfi zzl = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbrs
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbru.zzc(i);
        }
    };
    private final int zzn;

    zzbru(int i) {
        this.zzn = i;
    }

    public static zzbfj zzb() {
        return zzbrt.zza;
    }

    public static zzbru zzc(int i) {
        switch (i) {
            case 0:
                return ID;
            case 1:
                return TEXT;
            case 2:
                return DATETIME;
            case 3:
                return BOOLEAN;
            case 4:
                return INT;
            case 5:
                return RAWSTRING;
            case 6:
                return URL;
            case 7:
                return KEY;
            case 8:
                return FLOAT;
            case 9:
                return PROTO;
            case 10:
                return NESTED_STRUCT;
            default:
                return null;
        }
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
