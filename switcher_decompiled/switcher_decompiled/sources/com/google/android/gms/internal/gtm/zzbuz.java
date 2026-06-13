package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbuz implements zzbfh {
    OS_TYPE_UNKNOWN(0),
    OS_TYPE_CAST(1),
    OS_TYPE_FUCHSIA(2),
    OS_TYPE_ANDROID(3),
    OS_TYPE_LINUX(4);

    private static final zzbfi zzf = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbux
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbuz.zzc(i);
        }
    };
    private final int zzh;

    zzbuz(int i) {
        this.zzh = i;
    }

    public static zzbfj zzb() {
        return zzbuy.zza;
    }

    public static zzbuz zzc(int i) {
        if (i == 0) {
            return OS_TYPE_UNKNOWN;
        }
        if (i == 1) {
            return OS_TYPE_CAST;
        }
        if (i == 2) {
            return OS_TYPE_FUCHSIA;
        }
        if (i == 3) {
            return OS_TYPE_ANDROID;
        }
        if (i != 4) {
            return null;
        }
        return OS_TYPE_LINUX;
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
