package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzayo implements zzbfh {
    VEHICLE_TYPE_ANY(0),
    VEHICLE_TYPE_RAIL(1),
    VEHICLE_TYPE_METRO_RAIL(17),
    VEHICLE_TYPE_SUBWAY(273),
    VEHICLE_TYPE_TRAM(274),
    VEHICLE_TYPE_MONORAIL(275),
    VEHICLE_TYPE_HEAVY_RAIL(18),
    VEHICLE_TYPE_COMMUTER_TRAIN(289),
    VEHICLE_TYPE_HIGH_SPEED_TRAIN(290),
    VEHICLE_TYPE_LONG_DISTANCE_TRAIN(291),
    VEHICLE_TYPE_BUS(2),
    VEHICLE_TYPE_INTERCITY_BUS(33),
    VEHICLE_TYPE_TROLLEYBUS(34),
    VEHICLE_TYPE_SHARE_TAXI(35),
    VEHICLE_TYPE_FERRY(3),
    VEHICLE_TYPE_CABLE_CAR(4),
    VEHICLE_TYPE_GONDOLA_LIFT(65),
    VEHICLE_TYPE_FUNICULAR(66),
    VEHICLE_TYPE_SPECIAL(5),
    VEHICLE_TYPE_HORSE_CARRIAGE(81),
    VEHICLE_TYPE_AIRPLANE(6);

    private static final zzbfi zzv = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaym
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzayo.zzb(i);
        }
    };
    private final int zzx;

    zzayo(int i) {
        this.zzx = i;
    }

    public static zzayo zzb(int i) {
        if (i == 17) {
            return VEHICLE_TYPE_METRO_RAIL;
        }
        if (i == 18) {
            return VEHICLE_TYPE_HEAVY_RAIL;
        }
        if (i == 65) {
            return VEHICLE_TYPE_GONDOLA_LIFT;
        }
        if (i == 66) {
            return VEHICLE_TYPE_FUNICULAR;
        }
        if (i == 81) {
            return VEHICLE_TYPE_HORSE_CARRIAGE;
        }
        switch (i) {
            case 0:
                return VEHICLE_TYPE_ANY;
            case 1:
                return VEHICLE_TYPE_RAIL;
            case 2:
                return VEHICLE_TYPE_BUS;
            case 3:
                return VEHICLE_TYPE_FERRY;
            case 4:
                return VEHICLE_TYPE_CABLE_CAR;
            case 5:
                return VEHICLE_TYPE_SPECIAL;
            case 6:
                return VEHICLE_TYPE_AIRPLANE;
            default:
                switch (i) {
                    case 33:
                        return VEHICLE_TYPE_INTERCITY_BUS;
                    case 34:
                        return VEHICLE_TYPE_TROLLEYBUS;
                    case 35:
                        return VEHICLE_TYPE_SHARE_TAXI;
                    default:
                        switch (i) {
                            case 273:
                                return VEHICLE_TYPE_SUBWAY;
                            case 274:
                                return VEHICLE_TYPE_TRAM;
                            case 275:
                                return VEHICLE_TYPE_MONORAIL;
                            default:
                                switch (i) {
                                    case 289:
                                        return VEHICLE_TYPE_COMMUTER_TRAIN;
                                    case 290:
                                        return VEHICLE_TYPE_HIGH_SPEED_TRAIN;
                                    case 291:
                                        return VEHICLE_TYPE_LONG_DISTANCE_TRAIN;
                                    default:
                                        return null;
                                }
                        }
                }
        }
    }

    public static zzbfj zzc() {
        return zzayn.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzx);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzx;
    }
}
