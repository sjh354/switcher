package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbtn implements zzbfh {
    CLIENT_UNKNOWN(0),
    EMULATOR(1),
    PHENOTYPE(2);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbtl
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbtn.zzc(i);
        }
    };
    private final int zzf;

    zzbtn(int i) {
        this.zzf = i;
    }

    public static zzbfj zzb() {
        return zzbtm.zza;
    }

    public static zzbtn zzc(int i) {
        if (i == 0) {
            return CLIENT_UNKNOWN;
        }
        if (i == 1) {
            return EMULATOR;
        }
        if (i != 2) {
            return null;
        }
        return PHENOTYPE;
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
