package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzwo implements zzbfh {
    UNKNOWN(0),
    HD_L4(1),
    HD_L2(2),
    ADAS(3),
    AUTO_DRIVING_EXPERIENCE(4);

    private static final zzbfi zzf = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzwm
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzwo.zzb(i);
        }
    };
    private final int zzh;

    zzwo(int i) {
        this.zzh = i;
    }

    public static zzwo zzb(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return HD_L4;
        }
        if (i == 2) {
            return HD_L2;
        }
        if (i == 3) {
            return ADAS;
        }
        if (i != 4) {
            return null;
        }
        return AUTO_DRIVING_EXPERIENCE;
    }

    public static zzbfj zzc() {
        return zzwn.zza;
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
