package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzast implements zzbfh {
    TRAVEL_ANY(0),
    TRAVEL_MOTOR_VEHICLE(17),
    TRAVEL_AUTO(273),
    TRAVEL_CARPOOL(274),
    TRAVEL_MOTORCYCLE(275),
    TRAVEL_BUS(276),
    TRAVEL_TRUCK(277),
    TRAVEL_DELIVERY(278),
    TRAVEL_TAXI(279),
    TRAVEL_EMERGENCY(280),
    TRAVEL_THROUGH_TRAFFIC(281),
    TRAVEL_AUTONOMOUS_VEHICLE(282),
    TRAVEL_PEDESTRIAN(18),
    TRAVEL_BICYCLE(19);

    private static final zzbfi zzo = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzasr
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzast.zzb(i);
        }
    };
    private final int zzq;

    zzast(int i) {
        this.zzq = i;
    }

    public static zzast zzb(int i) {
        if (i == 0) {
            return TRAVEL_ANY;
        }
        switch (i) {
            case 17:
                return TRAVEL_MOTOR_VEHICLE;
            case 18:
                return TRAVEL_PEDESTRIAN;
            case 19:
                return TRAVEL_BICYCLE;
            default:
                switch (i) {
                    case 273:
                        return TRAVEL_AUTO;
                    case 274:
                        return TRAVEL_CARPOOL;
                    case 275:
                        return TRAVEL_MOTORCYCLE;
                    case 276:
                        return TRAVEL_BUS;
                    case 277:
                        return TRAVEL_TRUCK;
                    case 278:
                        return TRAVEL_DELIVERY;
                    case 279:
                        return TRAVEL_TAXI;
                    case 280:
                        return TRAVEL_EMERGENCY;
                    case 281:
                        return TRAVEL_THROUGH_TRAFFIC;
                    case 282:
                        return TRAVEL_AUTONOMOUS_VEHICLE;
                    default:
                        return null;
                }
        }
    }

    public static zzbfj zzc() {
        return zzass.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzq);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzq;
    }
}
