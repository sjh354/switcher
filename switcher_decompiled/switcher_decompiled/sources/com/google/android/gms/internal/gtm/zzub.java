package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzub implements zzbfh {
    UNSPECIFIED(0),
    EXTRA_SMALL(1),
    SMALL(2),
    MEDIUM(3),
    LARGE(4),
    EXTRA_LARGE(5),
    EXTRA_EXTRA_LARGE(6),
    EXTRA_EXTRA_EXTRA_LARGE(7),
    ACCESSIBILITY_MEDIUM(8),
    ACCESSIBILITY_LARGE(9),
    ACCESSIBILITY_EXTRA_LARGE(10),
    ACCESSIBILITY_EXTRA_EXTRA_LARGE(11),
    ACCESSIBILITY_EXTRA_EXTRA_EXTRA_LARGE(12);

    private static final zzbfi zzn = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zztz
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzub.zzb(i);
        }
    };
    private final int zzp;

    zzub(int i) {
        this.zzp = i;
    }

    public static zzub zzb(int i) {
        switch (i) {
            case 0:
                return UNSPECIFIED;
            case 1:
                return EXTRA_SMALL;
            case 2:
                return SMALL;
            case 3:
                return MEDIUM;
            case 4:
                return LARGE;
            case 5:
                return EXTRA_LARGE;
            case 6:
                return EXTRA_EXTRA_LARGE;
            case 7:
                return EXTRA_EXTRA_EXTRA_LARGE;
            case 8:
                return ACCESSIBILITY_MEDIUM;
            case 9:
                return ACCESSIBILITY_LARGE;
            case 10:
                return ACCESSIBILITY_EXTRA_LARGE;
            case 11:
                return ACCESSIBILITY_EXTRA_EXTRA_LARGE;
            case 12:
                return ACCESSIBILITY_EXTRA_EXTRA_EXTRA_LARGE;
            default:
                return null;
        }
    }

    public static zzbfj zzc() {
        return zzua.zza;
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
