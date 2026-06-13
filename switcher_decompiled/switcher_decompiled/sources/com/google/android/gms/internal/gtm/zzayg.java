package com.google.android.gms.internal.gtm;

import androidx.core.view.InputDeviceCompat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzayg implements zzbfh {
    OCCASION_SEASON(1),
    OCCASION_SEASON_WINTER(InputDeviceCompat.SOURCE_KEYBOARD),
    OCCASION_SEASON_SUMMER(258),
    OCCASION_DAYS(2),
    OCCASION_DAYS_SCHOOL(InputDeviceCompat.SOURCE_DPAD),
    OCCASION_DAYS_HOLIDAY(514),
    OCCASION_DAYS_PRE_HOLIDAY(515),
    OCCASION_HOURS(3),
    OCCASION_HOURS_PEAK(769),
    OCCASION_HOURS_SCHOOL(770),
    OCCASION_HOURS_MARKET(771),
    OCCASION_HOURS_BUSINESS(772),
    OCCASION_HOURS_DUSK_TO_DAWN(773),
    OCCASION_HOURS_HIGH_TIDE(774),
    OCCASION_CONDITIONS(4),
    OCCASION_CONDITIONS_HIGH_WATER(InputDeviceCompat.SOURCE_GAMEPAD),
    OCCASION_CONDITIONS_ADVERSE(1026),
    OCCASION_CONDITIONS_ADVERSE_RAIN(262657),
    OCCASION_CONDITIONS_ADVERSE_WET(262658),
    OCCASION_CONDITIONS_ADVERSE_FOG(262659),
    OCCASION_CONDITIONS_WINTERY(1027),
    OCCASION_CONDITIONS_WINTERY_AVALANCHE(262913),
    OCCASION_CONDITIONS_WINTERY_SNOW(262914),
    OCCASION_CONDITIONS_WINTERY_ICE(262915),
    OCCASION_CONDITIONS_EVENT(1028),
    OCCASION_CONDITIONS_POLLUTION(1029),
    OCCASION_CONDITIONS_LOW_WATER(1030),
    OCCASION_UNDEFINED(5),
    OCCASION_UNDEFINED_REGULAR(1281),
    OCCASION_UNDEFINED_SELDOM(1282);

    private static final zzbfi zzE = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaye
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzayg.zzb(i);
        }
    };
    private final int zzG;

    zzayg(int i) {
        this.zzG = i;
    }

    public static zzayg zzb(int i) {
        if (i == 1) {
            return OCCASION_SEASON;
        }
        if (i == 2) {
            return OCCASION_DAYS;
        }
        if (i == 3) {
            return OCCASION_HOURS;
        }
        if (i == 4) {
            return OCCASION_CONDITIONS;
        }
        if (i == 5) {
            return OCCASION_UNDEFINED;
        }
        if (i == 257) {
            return OCCASION_SEASON_WINTER;
        }
        if (i == 258) {
            return OCCASION_SEASON_SUMMER;
        }
        if (i == 1281) {
            return OCCASION_UNDEFINED_REGULAR;
        }
        if (i == 1282) {
            return OCCASION_UNDEFINED_SELDOM;
        }
        switch (i) {
            case InputDeviceCompat.SOURCE_DPAD /* 513 */:
                return OCCASION_DAYS_SCHOOL;
            case 514:
                return OCCASION_DAYS_HOLIDAY;
            case 515:
                return OCCASION_DAYS_PRE_HOLIDAY;
            default:
                switch (i) {
                    case 769:
                        return OCCASION_HOURS_PEAK;
                    case 770:
                        return OCCASION_HOURS_SCHOOL;
                    case 771:
                        return OCCASION_HOURS_MARKET;
                    case 772:
                        return OCCASION_HOURS_BUSINESS;
                    case 773:
                        return OCCASION_HOURS_DUSK_TO_DAWN;
                    case 774:
                        return OCCASION_HOURS_HIGH_TIDE;
                    default:
                        switch (i) {
                            case InputDeviceCompat.SOURCE_GAMEPAD /* 1025 */:
                                return OCCASION_CONDITIONS_HIGH_WATER;
                            case 1026:
                                return OCCASION_CONDITIONS_ADVERSE;
                            case 1027:
                                return OCCASION_CONDITIONS_WINTERY;
                            case 1028:
                                return OCCASION_CONDITIONS_EVENT;
                            case 1029:
                                return OCCASION_CONDITIONS_POLLUTION;
                            case 1030:
                                return OCCASION_CONDITIONS_LOW_WATER;
                            default:
                                switch (i) {
                                    case 262657:
                                        return OCCASION_CONDITIONS_ADVERSE_RAIN;
                                    case 262658:
                                        return OCCASION_CONDITIONS_ADVERSE_WET;
                                    case 262659:
                                        return OCCASION_CONDITIONS_ADVERSE_FOG;
                                    default:
                                        switch (i) {
                                            case 262913:
                                                return OCCASION_CONDITIONS_WINTERY_AVALANCHE;
                                            case 262914:
                                                return OCCASION_CONDITIONS_WINTERY_SNOW;
                                            case 262915:
                                                return OCCASION_CONDITIONS_WINTERY_ICE;
                                            default:
                                                return null;
                                        }
                                }
                        }
                }
        }
    }

    public static zzbfj zzc() {
        return zzayf.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzG);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzG;
    }
}
