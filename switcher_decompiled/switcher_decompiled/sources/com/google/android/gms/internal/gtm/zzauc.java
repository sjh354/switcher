package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzauc implements zzbfh {
    BICYCLE_FACILITY_SEPARATE_TRAIL(1),
    BICYCLE_FACILITY_PEDESTRIAN_PATH(2),
    BICYCLE_FACILITY_SHARED_ROAD(3),
    BICYCLE_FACILITY_BIKE_LANE(49),
    BICYCLE_FACILITY_WIDE_SHOULDER(50),
    BICYCLE_FACILITY_SHARROW(51);

    private static final zzbfi zzg = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaua
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzauc.zzb(i);
        }
    };
    private final int zzi;

    zzauc(int i) {
        this.zzi = i;
    }

    public static zzauc zzb(int i) {
        if (i == 1) {
            return BICYCLE_FACILITY_SEPARATE_TRAIL;
        }
        if (i == 2) {
            return BICYCLE_FACILITY_PEDESTRIAN_PATH;
        }
        if (i == 3) {
            return BICYCLE_FACILITY_SHARED_ROAD;
        }
        switch (i) {
            case 49:
                return BICYCLE_FACILITY_BIKE_LANE;
            case 50:
                return BICYCLE_FACILITY_WIDE_SHOULDER;
            case 51:
                return BICYCLE_FACILITY_SHARROW;
            default:
                return null;
        }
    }

    public static zzbfj zzc() {
        return zzaub.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzi);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzi;
    }
}
