package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbki implements zzbfh {
    UNSPECIFIED(0),
    EQUAL(1),
    LESS_THAN(2),
    LESS_THAN_OR_EQUAL(3),
    GREATER_THAN(4),
    GREATER_THAN_OR_EQUAL(5);

    private static final zzbfi zzg = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbkg
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbki.zzc(i);
        }
    };
    private final int zzi;

    zzbki(int i) {
        this.zzi = i;
    }

    public static zzbfj zzb() {
        return zzbkh.zza;
    }

    public static zzbki zzc(int i) {
        if (i == 0) {
            return UNSPECIFIED;
        }
        if (i == 1) {
            return EQUAL;
        }
        if (i == 2) {
            return LESS_THAN;
        }
        if (i == 3) {
            return LESS_THAN_OR_EQUAL;
        }
        if (i == 4) {
            return GREATER_THAN;
        }
        if (i != 5) {
            return null;
        }
        return GREATER_THAN_OR_EQUAL;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzi);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzi;
    }
}
