package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzafv implements zzbfh {
    UNIT_UNKNOWN(0),
    MILES_PER_HOUR(1),
    KILOMETERS_PER_HOUR(2);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaft
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzafv.zzb(i);
        }
    };
    private final int zzf;

    zzafv(int i) {
        this.zzf = i;
    }

    public static zzafv zzb(int i) {
        if (i == 0) {
            return UNIT_UNKNOWN;
        }
        if (i == 1) {
            return MILES_PER_HOUR;
        }
        if (i != 2) {
            return null;
        }
        return KILOMETERS_PER_HOUR;
    }

    public static zzbfj zzc() {
        return zzafu.zza;
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
