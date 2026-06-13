package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzauy implements zzbfh {
    PEDESTRIAN_GRADE_FLAT(1),
    PEDESTRIAN_GRADE_UP(2),
    PEDESTRIAN_GRADE_DOWN(3);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzauw
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzauy.zzb(i);
        }
    };
    private final int zzf;

    zzauy(int i) {
        this.zzf = i;
    }

    public static zzauy zzb(int i) {
        if (i == 1) {
            return PEDESTRIAN_GRADE_FLAT;
        }
        if (i == 2) {
            return PEDESTRIAN_GRADE_UP;
        }
        if (i != 3) {
            return null;
        }
        return PEDESTRIAN_GRADE_DOWN;
    }

    public static zzbfj zzc() {
        return zzaux.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzf);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzf;
    }
}
