package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbvg implements zzbfh {
    UNKNOWN(0),
    MOBILE(1),
    TABLET(2),
    DESKTOP(3),
    GOOGLE_HOME(4);

    private static final zzbfi zzf = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbve
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbvg.zzc(i);
        }
    };
    private final int zzh;

    zzbvg(int i) {
        this.zzh = i;
    }

    public static zzbfj zzb() {
        return zzbvf.zza;
    }

    public static zzbvg zzc(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return MOBILE;
        }
        if (i == 2) {
            return TABLET;
        }
        if (i == 3) {
            return DESKTOP;
        }
        if (i != 4) {
            return null;
        }
        return GOOGLE_HOME;
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
