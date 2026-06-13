package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzabw implements zzbfh {
    CUISINE_UNDEFINED(0),
    FAST_FOOD(1),
    AMERICAN(2),
    JAPANESE(3),
    BREAK_FAST(4),
    PIZZA(5),
    HAMBURGER(6),
    ITALIAN(7),
    SEAFOOD(8),
    FAMILY(9),
    MEXICAN(10),
    CHINESE(11),
    VEGETARIAN(12),
    SUSHI(13),
    CHICKEN(14),
    INDIAN(15),
    ASIAN(16),
    MEDITERRANEAN(17),
    FRENCH(18),
    BRUNCH(19),
    KOREAN(20),
    THAI(21),
    SPANISH(22),
    VIETNAMESE(23),
    LATIN_AMERICAN(24),
    INDONESIAN(25),
    GREEK(26),
    GERMAN(27),
    TURKISH(28),
    BRAZILIAN(29),
    PAKISTANI(30),
    OTHER_CUISINE(99);

    private static final zzbfi zzG = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzabu
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzabw.zzb(i);
        }
    };
    private final int zzI;

    zzabw(int i) {
        this.zzI = i;
    }

    public static zzabw zzb(int i) {
        if (i == 99) {
            return OTHER_CUISINE;
        }
        switch (i) {
            case 0:
                return CUISINE_UNDEFINED;
            case 1:
                return FAST_FOOD;
            case 2:
                return AMERICAN;
            case 3:
                return JAPANESE;
            case 4:
                return BREAK_FAST;
            case 5:
                return PIZZA;
            case 6:
                return HAMBURGER;
            case 7:
                return ITALIAN;
            case 8:
                return SEAFOOD;
            case 9:
                return FAMILY;
            case 10:
                return MEXICAN;
            case 11:
                return CHINESE;
            case 12:
                return VEGETARIAN;
            case 13:
                return SUSHI;
            case 14:
                return CHICKEN;
            case 15:
                return INDIAN;
            case 16:
                return ASIAN;
            case 17:
                return MEDITERRANEAN;
            case 18:
                return FRENCH;
            case 19:
                return BRUNCH;
            case 20:
                return KOREAN;
            case 21:
                return THAI;
            case 22:
                return SPANISH;
            case 23:
                return VIETNAMESE;
            case 24:
                return LATIN_AMERICAN;
            case 25:
                return INDONESIAN;
            case 26:
                return GREEK;
            case 27:
                return GERMAN;
            case 28:
                return TURKISH;
            case 29:
                return BRAZILIAN;
            case 30:
                return PAKISTANI;
            default:
                return null;
        }
    }

    public static zzbfj zzc() {
        return zzabv.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzI);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzI;
    }
}
