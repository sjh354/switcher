package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzsq implements zzbfh {
    BUILD_TYPE_UNKNOWN(0),
    BUILD_TYPE_PROD(1),
    BUILD_TYPE_INTERNAL(2),
    BUILD_TYPE_PRODLMP(3),
    BUILD_TYPE_THINGS(4),
    BUILD_TYPE_PRODMNC(5),
    BUILD_TYPE_WEARABLE(6),
    BUILD_TYPE_AUTO(7),
    BUILD_TYPE_ATV(9),
    BUILD_TYPE_PRODPIX(10),
    BUILD_TYPE_PRODPI(11),
    BUILD_TYPE_PRODGO(12),
    BUILD_TYPE_PRODQT(13),
    BUILD_TYPE_PRODNEXT(15),
    BUILD_TYPE_PRODRVC(16),
    BUILD_TYPE_BSTAR(17),
    BUILD_TYPE_PRODGOR(18),
    BUILD_TYPE_ATVR(19),
    BUILD_TYPE_PRODSC(20),
    BUILD_TYPE_PRODGOS(21),
    BUILD_TYPE_ATVS(22),
    BUILD_TYPE_WEARABLERVC(23),
    BUILD_TYPE_AUTORVC(24);

    private static final zzbfi zzx = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzso
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzsq.zzb(i);
        }
    };
    private final int zzz;

    zzsq(int i) {
        this.zzz = i;
    }

    public static zzsq zzb(int i) {
        switch (i) {
            case 0:
                return BUILD_TYPE_UNKNOWN;
            case 1:
                return BUILD_TYPE_PROD;
            case 2:
                return BUILD_TYPE_INTERNAL;
            case 3:
                return BUILD_TYPE_PRODLMP;
            case 4:
                return BUILD_TYPE_THINGS;
            case 5:
                return BUILD_TYPE_PRODMNC;
            case 6:
                return BUILD_TYPE_WEARABLE;
            case 7:
                return BUILD_TYPE_AUTO;
            case 8:
            case 14:
            default:
                return null;
            case 9:
                return BUILD_TYPE_ATV;
            case 10:
                return BUILD_TYPE_PRODPIX;
            case 11:
                return BUILD_TYPE_PRODPI;
            case 12:
                return BUILD_TYPE_PRODGO;
            case 13:
                return BUILD_TYPE_PRODQT;
            case 15:
                return BUILD_TYPE_PRODNEXT;
            case 16:
                return BUILD_TYPE_PRODRVC;
            case 17:
                return BUILD_TYPE_BSTAR;
            case 18:
                return BUILD_TYPE_PRODGOR;
            case 19:
                return BUILD_TYPE_ATVR;
            case 20:
                return BUILD_TYPE_PRODSC;
            case 21:
                return BUILD_TYPE_PRODGOS;
            case 22:
                return BUILD_TYPE_ATVS;
            case 23:
                return BUILD_TYPE_WEARABLERVC;
            case 24:
                return BUILD_TYPE_AUTORVC;
        }
    }

    public static zzbfj zzc() {
        return zzsp.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzz);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzz;
    }
}
