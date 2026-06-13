package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbne implements zzbfh {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4);

    private static final zzbfi zzf = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbnc
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbne.zzc(i);
        }
    };
    private final int zzh;

    zzbne(int i) {
        this.zzh = i;
    }

    public static zzbfj zzb() {
        return zzbnd.zza;
    }

    public static zzbne zzc(int i) {
        if (i == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i == 1) {
            return TINK;
        }
        if (i == 2) {
            return LEGACY;
        }
        if (i == 3) {
            return RAW;
        }
        if (i != 4) {
            return null;
        }
        return CRUNCHY;
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
