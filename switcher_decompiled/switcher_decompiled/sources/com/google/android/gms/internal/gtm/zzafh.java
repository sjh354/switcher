package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzafh implements zzbfh {
    DIRECTION_NONE(0),
    DIRECTION_NORTH(1),
    DIRECTION_EAST(2),
    DIRECTION_SOUTH(3),
    DIRECTION_WEST(4),
    DIRECTION_NORTHEAST(5),
    DIRECTION_NORTHWEST(6),
    DIRECTION_SOUTHEAST(7),
    DIRECTION_SOUTHWEST(8),
    DIRECTION_INNER(9),
    DIRECTION_OUTER(10);

    private static final zzbfi zzl = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaff
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzafh.zzb(i);
        }
    };
    private final int zzn;

    zzafh(int i) {
        this.zzn = i;
    }

    public static zzafh zzb(int i) {
        switch (i) {
            case 0:
                return DIRECTION_NONE;
            case 1:
                return DIRECTION_NORTH;
            case 2:
                return DIRECTION_EAST;
            case 3:
                return DIRECTION_SOUTH;
            case 4:
                return DIRECTION_WEST;
            case 5:
                return DIRECTION_NORTHEAST;
            case 6:
                return DIRECTION_NORTHWEST;
            case 7:
                return DIRECTION_SOUTHEAST;
            case 8:
                return DIRECTION_SOUTHWEST;
            case 9:
                return DIRECTION_INNER;
            case 10:
                return DIRECTION_OUTER;
            default:
                return null;
        }
    }

    public static zzbfj zzc() {
        return zzafg.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzn);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzn;
    }
}
