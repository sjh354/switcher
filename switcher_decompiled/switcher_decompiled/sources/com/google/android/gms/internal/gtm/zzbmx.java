package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbmx implements zzbfh {
    UNKNOWN_ENCODING(0),
    IEEE_P1363(1),
    DER(2);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbmv
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbmx.zzc(i);
        }
    };
    private final int zzf;

    zzbmx(int i) {
        this.zzf = i;
    }

    public static zzbfj zzb() {
        return zzbmw.zza;
    }

    public static zzbmx zzc(int i) {
        if (i == 0) {
            return UNKNOWN_ENCODING;
        }
        if (i == 1) {
            return IEEE_P1363;
        }
        if (i != 2) {
            return null;
        }
        return DER;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzf);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzf;
    }
}
