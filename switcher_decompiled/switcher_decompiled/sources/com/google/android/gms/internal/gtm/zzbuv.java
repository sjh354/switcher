package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbuv implements zzbfh {
    BACKEND_TYPE_UNKNOWN(0),
    BACKEND_TYPE_PRODUCTION(1),
    BACKEND_TYPE_ENG(2),
    BACKEND_TYPE_TEAMFOOD(3),
    BACKEND_TYPE_DOGFOOD(4);

    private static final zzbfi zzf = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbut
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbuv.zzc(i);
        }
    };
    private final int zzh;

    zzbuv(int i) {
        this.zzh = i;
    }

    public static zzbfj zzb() {
        return zzbuu.zza;
    }

    public static zzbuv zzc(int i) {
        if (i == 0) {
            return BACKEND_TYPE_UNKNOWN;
        }
        if (i == 1) {
            return BACKEND_TYPE_PRODUCTION;
        }
        if (i == 2) {
            return BACKEND_TYPE_ENG;
        }
        if (i == 3) {
            return BACKEND_TYPE_TEAMFOOD;
        }
        if (i != 4) {
            return null;
        }
        return BACKEND_TYPE_DOGFOOD;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzh);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzh;
    }
}
