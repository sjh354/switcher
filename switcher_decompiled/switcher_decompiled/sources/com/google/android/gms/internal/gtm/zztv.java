package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zztv implements zzbfh {
    UNKNOWN(0),
    ON(1),
    OFF(2);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zztt
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zztv.zzb(i);
        }
    };
    private final int zzf;

    zztv(int i) {
        this.zzf = i;
    }

    public static zztv zzb(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return ON;
        }
        if (i != 2) {
            return null;
        }
        return OFF;
    }

    public static zzbfj zzc() {
        return zztu.zza;
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
