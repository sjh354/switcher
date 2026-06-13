package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzaxv implements zzbfh {
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12),
    NEXT_JANUARY(13);

    private static final zzbfi zzn = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaxt
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzaxv.zzb(i);
        }
    };
    private final int zzp;

    zzaxv(int i) {
        this.zzp = i;
    }

    public static zzaxv zzb(int i) {
        switch (i) {
            case 1:
                return JANUARY;
            case 2:
                return FEBRUARY;
            case 3:
                return MARCH;
            case 4:
                return APRIL;
            case 5:
                return MAY;
            case 6:
                return JUNE;
            case 7:
                return JULY;
            case 8:
                return AUGUST;
            case 9:
                return SEPTEMBER;
            case 10:
                return OCTOBER;
            case 11:
                return NOVEMBER;
            case 12:
                return DECEMBER;
            case 13:
                return NEXT_JANUARY;
            default:
                return null;
        }
    }

    public static zzbfj zzc() {
        return zzaxu.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzp);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzp;
    }
}
