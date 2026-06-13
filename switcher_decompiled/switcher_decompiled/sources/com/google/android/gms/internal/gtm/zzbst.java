package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbst implements zzbfh {
    UNKNOWN(0),
    VERTICAL(1),
    HORIZONTAL(2);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbsr
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbst.zzc(i);
        }
    };
    private final int zzf;

    zzbst(int i) {
        this.zzf = i;
    }

    public static zzbfj zzb() {
        return zzbss.zza;
    }

    public static zzbst zzc(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return VERTICAL;
        }
        if (i != 2) {
            return null;
        }
        return HORIZONTAL;
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
