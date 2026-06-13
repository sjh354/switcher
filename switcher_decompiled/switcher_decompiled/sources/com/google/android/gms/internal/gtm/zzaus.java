package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzaus implements zzbfh {
    ENDPOINT_UNKNOWN(17),
    ENDPOINT_UNRESTRICTED(18),
    ENDPOINT_UNCONTROLLED(19),
    ENDPOINT_STOP_SIGN(20),
    ENDPOINT_ALL_WAY_STOP(321),
    ENDPOINT_TRAFFIC_LIGHT(21),
    ENDPOINT_THREE_WAY(337),
    ENDPOINT_FLASHING_RED(338),
    ENDPOINT_FLASHING_YELLOW(339),
    ENDPOINT_YIELD(22),
    ENDPOINT_MERGE(23),
    ENDPOINT_ROUNDABOUT(24),
    ENDPOINT_RAILROAD_CROSSING(25),
    ENDPOINT_NO_EXIT(26),
    ENDPOINT_WRONG_WAY(27),
    ENDPOINT_TOLL_BOOTH(28);

    private static final zzbfi zzq = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzauq
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzaus.zzb(i);
        }
    };
    private final int zzs;

    zzaus(int i) {
        this.zzs = i;
    }

    public static zzaus zzb(int i) {
        if (i == 321) {
            return ENDPOINT_ALL_WAY_STOP;
        }
        switch (i) {
            case 17:
                return ENDPOINT_UNKNOWN;
            case 18:
                return ENDPOINT_UNRESTRICTED;
            case 19:
                return ENDPOINT_UNCONTROLLED;
            case 20:
                return ENDPOINT_STOP_SIGN;
            case 21:
                return ENDPOINT_TRAFFIC_LIGHT;
            case 22:
                return ENDPOINT_YIELD;
            case 23:
                return ENDPOINT_MERGE;
            case 24:
                return ENDPOINT_ROUNDABOUT;
            case 25:
                return ENDPOINT_RAILROAD_CROSSING;
            case 26:
                return ENDPOINT_NO_EXIT;
            case 27:
                return ENDPOINT_WRONG_WAY;
            case 28:
                return ENDPOINT_TOLL_BOOTH;
            default:
                switch (i) {
                    case 337:
                        return ENDPOINT_THREE_WAY;
                    case 338:
                        return ENDPOINT_FLASHING_RED;
                    case 339:
                        return ENDPOINT_FLASHING_YELLOW;
                    default:
                        return null;
                }
        }
    }

    public static zzbfj zzc() {
        return zzaur.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzs);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzs;
    }
}
