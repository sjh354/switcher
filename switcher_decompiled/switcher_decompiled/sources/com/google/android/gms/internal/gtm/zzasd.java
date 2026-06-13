package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzasd implements zzbfh {
    RELATION_OVERLAPS(1),
    RELATION_CONTAINED_BY(17),
    RELATION_EQUAL_TO(273),
    RELATION_POLITICAL_DEPRECATED(2),
    RELATION_CAPITAL_OF(3),
    RELATION_DISAMBIGUATED_BY(4),
    RELATION_NEIGHBOR_OF(65),
    RELATION_OPPOSITE_TO(1041),
    RELATION_NEXT_TO(1042),
    RELATION_RIGHT_OF(16673),
    RELATION_LEFT_OF(16674),
    RELATION_BEHIND(1043),
    RELATION_IN_FRONT_OF(1044),
    RELATION_SAME_BUILDING(66),
    RELATION_ABOVE(1057),
    RELATION_BELOW(1058),
    RELATION_NEAR(67),
    RELATION_ORGANIZATIONALLY_PART_OF(6),
    RELATION_DEPARTMENT_OF(97),
    RELATION_WORKS_AT(99),
    RELATION_INDEPENDENT_ESTABLISHMENT_IN(100),
    RELATION_ON_LEVEL(7),
    RELATION_OCCUPIES(8),
    RELATION_BUSINESS_LIFE_CYCLE(9),
    RELATION_BUSINESS_MOVED(145),
    RELATION_BUSINESS_REBRANDED(146),
    RELATION_MEMBER_OF_CHAIN(10),
    RELATION_AUTHORIZED_DEALER_FOR_CHAIN(161),
    RELATION_SUBSIDIARY_OF(11),
    RELATION_PRIMARILY_OCCUPIED_BY(12),
    RELATION_VARIATION(13),
    RELATION_HAS_VARIANT(209),
    RELATION_VARIANT_OF(210),
    RELATION_VARIANT_SIBLING(211),
    RELATION_CLIENT_DEFINED(15);

    private static final zzbfi zzJ = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzasb
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzasd.zzb(i);
        }
    };
    private final int zzL;

    zzasd(int i) {
        this.zzL = i;
    }

    public static zzasd zzb(int i) {
        if (i == 1) {
            return RELATION_OVERLAPS;
        }
        if (i == 2) {
            return RELATION_POLITICAL_DEPRECATED;
        }
        if (i == 3) {
            return RELATION_CAPITAL_OF;
        }
        if (i == 4) {
            return RELATION_DISAMBIGUATED_BY;
        }
        if (i == 15) {
            return RELATION_CLIENT_DEFINED;
        }
        if (i == 17) {
            return RELATION_CONTAINED_BY;
        }
        if (i == 97) {
            return RELATION_DEPARTMENT_OF;
        }
        if (i == 161) {
            return RELATION_AUTHORIZED_DEALER_FOR_CHAIN;
        }
        if (i == 273) {
            return RELATION_EQUAL_TO;
        }
        if (i == 99) {
            return RELATION_WORKS_AT;
        }
        if (i == 100) {
            return RELATION_INDEPENDENT_ESTABLISHMENT_IN;
        }
        if (i == 145) {
            return RELATION_BUSINESS_MOVED;
        }
        if (i == 146) {
            return RELATION_BUSINESS_REBRANDED;
        }
        if (i == 1057) {
            return RELATION_ABOVE;
        }
        if (i == 1058) {
            return RELATION_BELOW;
        }
        if (i == 16673) {
            return RELATION_RIGHT_OF;
        }
        if (i == 16674) {
            return RELATION_LEFT_OF;
        }
        switch (i) {
            case 6:
                return RELATION_ORGANIZATIONALLY_PART_OF;
            case 7:
                return RELATION_ON_LEVEL;
            case 8:
                return RELATION_OCCUPIES;
            case 9:
                return RELATION_BUSINESS_LIFE_CYCLE;
            case 10:
                return RELATION_MEMBER_OF_CHAIN;
            case 11:
                return RELATION_SUBSIDIARY_OF;
            case 12:
                return RELATION_PRIMARILY_OCCUPIED_BY;
            case 13:
                return RELATION_VARIATION;
            default:
                switch (i) {
                    case 65:
                        return RELATION_NEIGHBOR_OF;
                    case 66:
                        return RELATION_SAME_BUILDING;
                    case 67:
                        return RELATION_NEAR;
                    default:
                        switch (i) {
                            case 209:
                                return RELATION_HAS_VARIANT;
                            case 210:
                                return RELATION_VARIANT_OF;
                            case 211:
                                return RELATION_VARIANT_SIBLING;
                            default:
                                switch (i) {
                                    case 1041:
                                        return RELATION_OPPOSITE_TO;
                                    case 1042:
                                        return RELATION_NEXT_TO;
                                    case 1043:
                                        return RELATION_BEHIND;
                                    case 1044:
                                        return RELATION_IN_FRONT_OF;
                                    default:
                                        return null;
                                }
                        }
                }
        }
    }

    public static zzbfj zzc() {
        return zzasc.zza;
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
