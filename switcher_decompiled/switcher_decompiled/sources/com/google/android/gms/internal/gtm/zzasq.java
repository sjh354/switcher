package com.google.android.gms.internal.gtm;

import kr.switcher.device.SReturnCode;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzasq implements zzbfh {
    RESTRICTION_TRAVEL_RESTRICTED(17),
    RESTRICTION_ILLEGAL(273),
    RESTRICTION_PHYSICAL(274),
    RESTRICTION_LOGICAL(275),
    RESTRICTION_GATE(276),
    RESTRICTION_CONSTRUCTION(277),
    RESTRICTION_SEASONAL_CLOSURE(278),
    RESTRICTION_PRIVATE(279),
    RESTRICTION_WRONG_WAY(280),
    RESTRICTION_TERMINAL(281),
    RESTRICTION_PAYMENT_REQUIRED(18),
    RESTRICTION_TOLL_BOOTH(289),
    RESTRICTION_USAGE_FEE_REQUIRED(290),
    RESTRICTION_ENTRANCE_FEE_REQUIRED(291),
    RESTRICTION_ADVISORY(19),
    RESTRICTION_HIGH_CRIME(305),
    RESTRICTION_POLITICALLY_SENSITIVE(SReturnCode.INVALID_CHECKER_TYPE),
    RESTRICTION_DISTURBED_BY_MAINTENANCE(307),
    RESTRICTION_CHECKPOINT(StatusLine.HTTP_PERM_REDIRECT),
    RESTRICTION_REGION_SPECIFIC(20);

    private static final zzbfi zzu = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaso
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzasq.zzb(i);
        }
    };
    private final int zzw;

    zzasq(int i) {
        this.zzw = i;
    }

    public static zzasq zzb(int i) {
        switch (i) {
            case 17:
                return RESTRICTION_TRAVEL_RESTRICTED;
            case 18:
                return RESTRICTION_PAYMENT_REQUIRED;
            case 19:
                return RESTRICTION_ADVISORY;
            case 20:
                return RESTRICTION_REGION_SPECIFIC;
            default:
                switch (i) {
                    case 273:
                        return RESTRICTION_ILLEGAL;
                    case 274:
                        return RESTRICTION_PHYSICAL;
                    case 275:
                        return RESTRICTION_LOGICAL;
                    case 276:
                        return RESTRICTION_GATE;
                    case 277:
                        return RESTRICTION_CONSTRUCTION;
                    case 278:
                        return RESTRICTION_SEASONAL_CLOSURE;
                    case 279:
                        return RESTRICTION_PRIVATE;
                    case 280:
                        return RESTRICTION_WRONG_WAY;
                    case 281:
                        return RESTRICTION_TERMINAL;
                    default:
                        switch (i) {
                            case 289:
                                return RESTRICTION_TOLL_BOOTH;
                            case 290:
                                return RESTRICTION_USAGE_FEE_REQUIRED;
                            case 291:
                                return RESTRICTION_ENTRANCE_FEE_REQUIRED;
                            default:
                                switch (i) {
                                    case 305:
                                        return RESTRICTION_HIGH_CRIME;
                                    case SReturnCode.INVALID_CHECKER_TYPE /* 306 */:
                                        return RESTRICTION_POLITICALLY_SENSITIVE;
                                    case 307:
                                        return RESTRICTION_DISTURBED_BY_MAINTENANCE;
                                    case StatusLine.HTTP_PERM_REDIRECT /* 308 */:
                                        return RESTRICTION_CHECKPOINT;
                                    default:
                                        return null;
                                }
                        }
                }
        }
    }

    public static zzbfj zzc() {
        return zzasp.zza;
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
