package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzaho implements zzbfh {
    HAZARDOUS_GOODS_TYPE_UNSPECIFIED(0),
    EXPLOSIVES(1),
    GASES(2),
    FLAMMABLE(3),
    COMBUSTIBLE(4),
    ORGANIC(5),
    POISON(6),
    RADIOACTIVE(7),
    CORROSIVE(8),
    ASPIRATION_HAZARD(9),
    ENVIRONMENTAL_HAZARD(10),
    OTHER(11);

    private static final zzbfi zzm = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzahm
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzaho.zzb(i);
        }
    };
    private final int zzo;

    zzaho(int i) {
        this.zzo = i;
    }

    public static zzaho zzb(int i) {
        switch (i) {
            case 0:
                return HAZARDOUS_GOODS_TYPE_UNSPECIFIED;
            case 1:
                return EXPLOSIVES;
            case 2:
                return GASES;
            case 3:
                return FLAMMABLE;
            case 4:
                return COMBUSTIBLE;
            case 5:
                return ORGANIC;
            case 6:
                return POISON;
            case 7:
                return RADIOACTIVE;
            case 8:
                return CORROSIVE;
            case 9:
                return ASPIRATION_HAZARD;
            case 10:
                return ENVIRONMENTAL_HAZARD;
            case 11:
                return OTHER;
            default:
                return null;
        }
    }

    public static zzbfj zzc() {
        return zzahn.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzo);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzo;
    }
}
