package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbuf implements zzbfh {
    UNKNOWN(0),
    JS(1),
    DESKTOP(2),
    IOS(3),
    IOS_V2(10),
    ANDROID(4),
    PLAY_CE(5),
    PYTHON(6),
    VR(7),
    PANCETTA(8),
    DRIVE_FS(9),
    YETI(11),
    MAC(12),
    GOOGLE_HOME(13),
    BIRDSONG(14),
    IOS_FIREBASE(15),
    GO(16),
    FUCHSIA(17),
    SPARKLIGHT(18),
    CPLUSPLUS(19),
    KAIOS(20),
    MUSK(21),
    COMPUTE_IMAGE_TOOLS(22),
    ANDROID_FIREBASE(23),
    LOONIX(24),
    C9(25),
    BATTLESTAR(26),
    PORTABLE_PHENOTYPE_LIBRARY(27),
    WINDOWS(28),
    CLOUD_WORKSTATIONS_CONNECTOR(29),
    FITBIT_DARKHORSE(30);

    private static final zzbfi zzF = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbud
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbuf.zzc(i);
        }
    };
    private final int zzH;

    zzbuf(int i) {
        this.zzH = i;
    }

    public static zzbfj zzb() {
        return zzbue.zza;
    }

    public static zzbuf zzc(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return JS;
            case 2:
                return DESKTOP;
            case 3:
                return IOS;
            case 4:
                return ANDROID;
            case 5:
                return PLAY_CE;
            case 6:
                return PYTHON;
            case 7:
                return VR;
            case 8:
                return PANCETTA;
            case 9:
                return DRIVE_FS;
            case 10:
                return IOS_V2;
            case 11:
                return YETI;
            case 12:
                return MAC;
            case 13:
                return GOOGLE_HOME;
            case 14:
                return BIRDSONG;
            case 15:
                return IOS_FIREBASE;
            case 16:
                return GO;
            case 17:
                return FUCHSIA;
            case 18:
                return SPARKLIGHT;
            case 19:
                return CPLUSPLUS;
            case 20:
                return KAIOS;
            case 21:
                return MUSK;
            case 22:
                return COMPUTE_IMAGE_TOOLS;
            case 23:
                return ANDROID_FIREBASE;
            case 24:
                return LOONIX;
            case 25:
                return C9;
            case 26:
                return BATTLESTAR;
            case 27:
                return PORTABLE_PHENOTYPE_LIBRARY;
            case 28:
                return WINDOWS;
            case 29:
                return CLOUD_WORKSTATIONS_CONNECTOR;
            case 30:
                return FITBIT_DARKHORSE;
            default:
                return null;
        }
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzH);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzH;
    }
}
