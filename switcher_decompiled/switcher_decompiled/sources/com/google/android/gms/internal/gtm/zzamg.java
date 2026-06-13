package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzamg implements zzbfh {
    UNKNOWN(0),
    BOGUS(1),
    PRIVATE(2),
    SPAM(3),
    UNSUPPORTED(4),
    PENDING(5),
    DUPLICATE(6),
    OLD_SCHEMA(8),
    REPLACED(9),
    ROLLED_BACK(10);

    private static final zzbfi zzk = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzame
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzamg.zzb(i);
        }
    };
    private final int zzm;

    zzamg(int i) {
        this.zzm = i;
    }

    public static zzamg zzb(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return BOGUS;
            case 2:
                return PRIVATE;
            case 3:
                return SPAM;
            case 4:
                return UNSUPPORTED;
            case 5:
                return PENDING;
            case 6:
                return DUPLICATE;
            case 7:
            default:
                return null;
            case 8:
                return OLD_SCHEMA;
            case 9:
                return REPLACED;
            case 10:
                return ROLLED_BACK;
        }
    }

    public static zzbfj zzc() {
        return zzamf.zza;
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
