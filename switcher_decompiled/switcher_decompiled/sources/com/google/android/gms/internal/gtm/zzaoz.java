package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzaoz implements zzbfh {
    TYPE_UNKNOWN(1),
    TYPE_NORMAL(2),
    TYPE_PASSING(3),
    TYPE_LEFT_TURN(4),
    TYPE_LEFT_TURN_OFF(65),
    TYPE_LEFT_TURN_ON_OFF(66),
    TYPE_RIGHT_TURN(5),
    TYPE_RIGHT_TURN_OFF(81),
    TYPE_RIGHT_TURN_ON_OFF(82),
    TYPE_BICYCLE(6),
    TYPE_PARKING(7),
    TYPE_PARKING_IMPLIED(113),
    TYPE_PARKING_MARKED(114),
    TYPE_EXIT_ENTRANCE(8),
    TYPE_EXIT_LANE(129),
    TYPE_ENTRANCE_LANE(130),
    TYPE_PEDESTRIAN(9),
    TYPE_SIDEWALK_SHOULDER(10),
    TYPE_VEHICLE_SHOULDER(11),
    TYPE_OFFSET(12);

    private static final zzbfi zzu = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaox
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzaoz.zzb(i);
        }
    };
    private final int zzw;

    zzaoz(int i) {
        this.zzw = i;
    }

    public static zzaoz zzb(int i) {
        if (i == 65) {
            return TYPE_LEFT_TURN_OFF;
        }
        if (i == 66) {
            return TYPE_LEFT_TURN_ON_OFF;
        }
        if (i == 81) {
            return TYPE_RIGHT_TURN_OFF;
        }
        if (i == 82) {
            return TYPE_RIGHT_TURN_ON_OFF;
        }
        if (i == 113) {
            return TYPE_PARKING_IMPLIED;
        }
        if (i == 114) {
            return TYPE_PARKING_MARKED;
        }
        if (i == 129) {
            return TYPE_EXIT_LANE;
        }
        if (i == 130) {
            return TYPE_ENTRANCE_LANE;
        }
        switch (i) {
            case 1:
                return TYPE_UNKNOWN;
            case 2:
                return TYPE_NORMAL;
            case 3:
                return TYPE_PASSING;
            case 4:
                return TYPE_LEFT_TURN;
            case 5:
                return TYPE_RIGHT_TURN;
            case 6:
                return TYPE_BICYCLE;
            case 7:
                return TYPE_PARKING;
            case 8:
                return TYPE_EXIT_ENTRANCE;
            case 9:
                return TYPE_PEDESTRIAN;
            case 10:
                return TYPE_SIDEWALK_SHOULDER;
            case 11:
                return TYPE_VEHICLE_SHOULDER;
            case 12:
                return TYPE_OFFSET;
            default:
                return null;
        }
    }

    public static zzbfj zzc() {
        return zzaoy.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzw);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzw;
    }
}
