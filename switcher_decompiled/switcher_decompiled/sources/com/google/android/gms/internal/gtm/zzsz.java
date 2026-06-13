package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzsz implements zzbfh {
    DEVICE_TYPE_UNKNOWN(0),
    DEVICE_TYPE_PHONE(1),
    DEVICE_TYPE_PHONE_GO(2),
    DEVICE_TYPE_TV(3),
    DEVICE_TYPE_WEARABLE(4),
    DEVICE_TYPE_AUTOMOTIVE(5),
    DEVICE_TYPE_BATTLESTAR(6),
    DEVICE_TYPE_CHROME_OS(7);

    private static final zzbfi zzi = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzsx
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzsz.zzb(i);
        }
    };
    private final int zzk;

    zzsz(int i) {
        this.zzk = i;
    }

    public static zzsz zzb(int i) {
        switch (i) {
            case 0:
                return DEVICE_TYPE_UNKNOWN;
            case 1:
                return DEVICE_TYPE_PHONE;
            case 2:
                return DEVICE_TYPE_PHONE_GO;
            case 3:
                return DEVICE_TYPE_TV;
            case 4:
                return DEVICE_TYPE_WEARABLE;
            case 5:
                return DEVICE_TYPE_AUTOMOTIVE;
            case 6:
                return DEVICE_TYPE_BATTLESTAR;
            case 7:
                return DEVICE_TYPE_CHROME_OS;
            default:
                return null;
        }
    }

    public static zzbfj zzc() {
        return zzsy.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzk);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzk;
    }
}
