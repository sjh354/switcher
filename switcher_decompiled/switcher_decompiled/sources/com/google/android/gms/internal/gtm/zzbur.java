package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbur implements zzbfh {
    CLIENT_UNKNOWN(0),
    PHENOTYPE(1);

    private static final zzbfi zzc = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbup
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbur.zzc(i);
        }
    };
    private final int zze;

    zzbur(int i) {
        this.zze = i;
    }

    public static zzbfj zzb() {
        return zzbuq.zza;
    }

    public static zzbur zzc(int i) {
        if (i == 0) {
            return CLIENT_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return PHENOTYPE;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zze);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zze;
    }
}
