package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbdd implements zzbfh {
    SPEED(1),
    CODE_SIZE(2),
    LITE_RUNTIME(3);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbdb
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbdd.zzb(i);
        }
    };
    private final int zzf;

    zzbdd(int i) {
        this.zzf = i;
    }

    public static zzbdd zzb(int i) {
        if (i == 1) {
            return SPEED;
        }
        if (i == 2) {
            return CODE_SIZE;
        }
        if (i != 3) {
            return null;
        }
        return LITE_RUNTIME;
    }

    public static zzbfj zzc() {
        return zzbdc.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzf);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzf;
    }
}
