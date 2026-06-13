package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzabg implements zzbfh {
    RESTRICTION_UNKNOWN(0),
    RESTRICTION_PARKING(1),
    RESTRICTION_STANDING(17),
    RESTRICTION_STOPPING(273),
    RESTRICTION_PICKUP_GOODS(18),
    RESTRICTION_PICKUP_PASSENGERS(19);

    private static final zzbfi zzg = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzabe
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzabg.zzb(i);
        }
    };
    private final int zzi;

    zzabg(int i) {
        this.zzi = i;
    }

    public static zzabg zzb(int i) {
        if (i == 0) {
            return RESTRICTION_UNKNOWN;
        }
        if (i == 1) {
            return RESTRICTION_PARKING;
        }
        if (i == 273) {
            return RESTRICTION_STOPPING;
        }
        switch (i) {
            case 17:
                return RESTRICTION_STANDING;
            case 18:
                return RESTRICTION_PICKUP_GOODS;
            case 19:
                return RESTRICTION_PICKUP_PASSENGERS;
            default:
                return null;
        }
    }

    public static zzbfj zzc() {
        return zzabf.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzi);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzi;
    }
}
