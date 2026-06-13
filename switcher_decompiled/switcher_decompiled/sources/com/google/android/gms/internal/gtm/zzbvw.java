package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbvw implements zzbfh {
    OS_TYPE_UNKNOWN(0),
    OS_TYPE_MAC(1),
    OS_TYPE_WINDOWS(2),
    OS_TYPE_ANDROID(3),
    OS_TYPE_CROS(4),
    OS_TYPE_LINUX(5),
    OS_TYPE_OPENBSD(6);

    private static final zzbfi zzh = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbvu
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbvw.zzc(i);
        }
    };
    private final int zzj;

    zzbvw(int i) {
        this.zzj = i;
    }

    public static zzbfj zzb() {
        return zzbvv.zza;
    }

    public static zzbvw zzc(int i) {
        switch (i) {
            case 0:
                return OS_TYPE_UNKNOWN;
            case 1:
                return OS_TYPE_MAC;
            case 2:
                return OS_TYPE_WINDOWS;
            case 3:
                return OS_TYPE_ANDROID;
            case 4:
                return OS_TYPE_CROS;
            case 5:
                return OS_TYPE_LINUX;
            case 6:
                return OS_TYPE_OPENBSD;
            default:
                return null;
        }
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzj);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzj;
    }
}
