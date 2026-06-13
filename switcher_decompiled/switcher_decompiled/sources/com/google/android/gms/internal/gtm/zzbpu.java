package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbpu implements zzbfh {
    NONCE(1),
    TWEAK(2),
    WITH_DATA(3);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbps
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbpu.zzc(i);
        }
    };
    private final int zzf;

    zzbpu(int i) {
        this.zzf = i;
    }

    public static zzbfj zzb() {
        return zzbpt.zza;
    }

    public static zzbpu zzc(int i) {
        if (i == 1) {
            return NONCE;
        }
        if (i == 2) {
            return TWEAK;
        }
        if (i != 3) {
            return null;
        }
        return WITH_DATA;
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
