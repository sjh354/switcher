package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbno implements zzbfh {
    UNKNOWN(0),
    NONE(1),
    BASE64(2),
    WEBSAFE(3),
    BASE64_URL(4),
    WEBSAFE_BASE64_URL(5);

    private static final zzbfi zzg = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbnm
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbno.zzc(i);
        }
    };
    private final int zzi;

    zzbno(int i) {
        this.zzi = i;
    }

    public static zzbfj zzb() {
        return zzbnn.zza;
    }

    public static zzbno zzc(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return NONE;
        }
        if (i == 2) {
            return BASE64;
        }
        if (i == 3) {
            return WEBSAFE;
        }
        if (i == 4) {
            return BASE64_URL;
        }
        if (i != 5) {
            return null;
        }
        return WEBSAFE_BASE64_URL;
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
