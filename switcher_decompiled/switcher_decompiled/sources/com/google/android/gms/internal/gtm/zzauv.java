package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzauv implements zzbfh {
    PEDESTRIAN_FACILITY_UNKNOWN(1),
    PEDESTRIAN_FACILITY_NONE(2),
    PEDESTRIAN_FACILITY_PRESENT(3),
    PEDESTRIAN_FACILITY_SIDEWALK(49),
    PEDESTRIAN_FACILITY_WIDE_SHOULDER(50);

    private static final zzbfi zzf = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaut
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzauv.zzb(i);
        }
    };
    private final int zzh;

    zzauv(int i) {
        this.zzh = i;
    }

    public static zzauv zzb(int i) {
        if (i == 1) {
            return PEDESTRIAN_FACILITY_UNKNOWN;
        }
        if (i == 2) {
            return PEDESTRIAN_FACILITY_NONE;
        }
        if (i == 3) {
            return PEDESTRIAN_FACILITY_PRESENT;
        }
        if (i == 49) {
            return PEDESTRIAN_FACILITY_SIDEWALK;
        }
        if (i != 50) {
            return null;
        }
        return PEDESTRIAN_FACILITY_WIDE_SHOULDER;
    }

    public static zzbfj zzc() {
        return zzauu.zza;
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
