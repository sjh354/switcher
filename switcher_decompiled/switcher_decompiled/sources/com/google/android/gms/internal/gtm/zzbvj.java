package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbvj implements zzbfh {
    OS_UNKNOWN(0),
    MAC(1),
    WINDOWS(2),
    ANDROID(3),
    LINUX(4),
    CHROME_OS(5),
    IPAD(6),
    IPHONE(7),
    IPOD(8),
    CHROMECAST(9);

    private static final zzbfi zzk = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbvh
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbvj.zzc(i);
        }
    };
    private final int zzm;

    zzbvj(int i) {
        this.zzm = i;
    }

    public static zzbfj zzb() {
        return zzbvi.zza;
    }

    public static zzbvj zzc(int i) {
        switch (i) {
            case 0:
                return OS_UNKNOWN;
            case 1:
                return MAC;
            case 2:
                return WINDOWS;
            case 3:
                return ANDROID;
            case 4:
                return LINUX;
            case 5:
                return CHROME_OS;
            case 6:
                return IPAD;
            case 7:
                return IPHONE;
            case 8:
                return IPOD;
            case 9:
                return CHROMECAST;
            default:
                return null;
        }
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
