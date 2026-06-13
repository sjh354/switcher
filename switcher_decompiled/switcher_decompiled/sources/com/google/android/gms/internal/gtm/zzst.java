package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzst implements zzbfh {
    DENSITY_UNKNOWN(0),
    DENSITY_ALLDPI(1),
    DENSITY_LDPI(2),
    DENSITY_MDPI(3),
    DENSITY_TVDPI(4),
    DENSITY_HDPI(5),
    DENSITY_XHDPI(7),
    DENSITY_DPI400(8),
    DENSITY_XXHDPI(9),
    DENSITY_XXXHDPI(10);

    private static final zzbfi zzk = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzsr
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzst.zzb(i);
        }
    };
    private final int zzm;

    zzst(int i) {
        this.zzm = i;
    }

    public static zzst zzb(int i) {
        switch (i) {
            case 0:
                return DENSITY_UNKNOWN;
            case 1:
                return DENSITY_ALLDPI;
            case 2:
                return DENSITY_LDPI;
            case 3:
                return DENSITY_MDPI;
            case 4:
                return DENSITY_TVDPI;
            case 5:
                return DENSITY_HDPI;
            case 6:
            default:
                return null;
            case 7:
                return DENSITY_XHDPI;
            case 8:
                return DENSITY_DPI400;
            case 9:
                return DENSITY_XXHDPI;
            case 10:
                return DENSITY_XXXHDPI;
        }
    }

    public static zzbfj zzc() {
        return zzss.zza;
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
