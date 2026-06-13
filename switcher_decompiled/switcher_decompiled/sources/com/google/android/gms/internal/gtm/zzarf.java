package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzarf implements zzbfh {
    MIXER_INVALID(0),
    MIXER_MISSING(1),
    MIXER_ADDRESS_AREA(2),
    MIXER_ROUTE_SEGMENT_INTERSECTION(3),
    MIXER_POLITICAL_EUROPA(4),
    MIXER_POLITICAL_AREA(5),
    MIXER_POLITICAL(6),
    MIXER_COUNTRY_EUROPA(7),
    MIXER_COUNTRY_AREA(8),
    MIXER_COUNTRY(9),
    MIXER_LOCALITY(10),
    MIXER_LOCALITY_GEOWIKI(11),
    MIXER_LOCALITY_EUROPA(12),
    MIXER_LOCALITY_AREA(13),
    MIXER_RIVER(14),
    MIXER_LENGTH_WEBSCORE(15),
    MIXER_SKENERGY(16),
    MIXER_GEOCENTRE_GEOCODED_ADDRESS(17),
    MIXER_PLACERANK(18),
    MIXER_TRANSIT(19),
    MIXER_LOCALITY_EUROPA_AREA(20),
    MIXER_WEBSCORE(21),
    MIXER_LOCALITY_MAPDATA_SCIENCES(22),
    MIXER_SUBLOCALITY_MAPDATA_SCIENCES(23),
    MIXER_PEAK(24),
    MIXER_BUILDING(27),
    MIXER_RESERVATION(28),
    MIXER_AIRPORT(29),
    MIXER_AREA(30),
    MIXER_MANAGER(10000),
    MIXER_TEST_1(10001),
    MIXER_TEST_2(10002),
    MIXER_TEST_3(10003),
    MIXER_TEST_4(10004),
    MIXER_TEST_5(10005);

    private static final zzbfi zzJ = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzard
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzarf.zzb(i);
        }
    };
    private final int zzL;

    zzarf(int i) {
        this.zzL = i;
    }

    public static zzarf zzb(int i) {
        switch (i) {
            case 0:
                return MIXER_INVALID;
            case 1:
                return MIXER_MISSING;
            case 2:
                return MIXER_ADDRESS_AREA;
            case 3:
                return MIXER_ROUTE_SEGMENT_INTERSECTION;
            case 4:
                return MIXER_POLITICAL_EUROPA;
            case 5:
                return MIXER_POLITICAL_AREA;
            case 6:
                return MIXER_POLITICAL;
            case 7:
                return MIXER_COUNTRY_EUROPA;
            case 8:
                return MIXER_COUNTRY_AREA;
            case 9:
                return MIXER_COUNTRY;
            case 10:
                return MIXER_LOCALITY;
            case 11:
                return MIXER_LOCALITY_GEOWIKI;
            case 12:
                return MIXER_LOCALITY_EUROPA;
            case 13:
                return MIXER_LOCALITY_AREA;
            case 14:
                return MIXER_RIVER;
            case 15:
                return MIXER_LENGTH_WEBSCORE;
            case 16:
                return MIXER_SKENERGY;
            case 17:
                return MIXER_GEOCENTRE_GEOCODED_ADDRESS;
            case 18:
                return MIXER_PLACERANK;
            case 19:
                return MIXER_TRANSIT;
            case 20:
                return MIXER_LOCALITY_EUROPA_AREA;
            case 21:
                return MIXER_WEBSCORE;
            case 22:
                return MIXER_LOCALITY_MAPDATA_SCIENCES;
            case 23:
                return MIXER_SUBLOCALITY_MAPDATA_SCIENCES;
            case 24:
                return MIXER_PEAK;
            default:
                switch (i) {
                    case 27:
                        return MIXER_BUILDING;
                    case 28:
                        return MIXER_RESERVATION;
                    case 29:
                        return MIXER_AIRPORT;
                    case 30:
                        return MIXER_AREA;
                    default:
                        switch (i) {
                            case 10000:
                                return MIXER_MANAGER;
                            case 10001:
                                return MIXER_TEST_1;
                            case 10002:
                                return MIXER_TEST_2;
                            case 10003:
                                return MIXER_TEST_3;
                            case 10004:
                                return MIXER_TEST_4;
                            case 10005:
                                return MIXER_TEST_5;
                            default:
                                return null;
                        }
                }
        }
    }

    public static zzbfj zzc() {
        return zzare.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzL);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzL;
    }
}
