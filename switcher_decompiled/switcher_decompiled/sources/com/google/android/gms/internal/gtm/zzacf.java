package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzacf implements zzbfh {
    UNDEFINED_MASS_UNIT(0),
    GRAM(1),
    MILLIGRAM(2);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzacd
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzacf.zzb(i);
        }
    };
    private final int zzf;

    zzacf(int i) {
        this.zzf = i;
    }

    public static zzacf zzb(int i) {
        if (i == 0) {
            return UNDEFINED_MASS_UNIT;
        }
        if (i == 1) {
            return GRAM;
        }
        if (i != 2) {
            return null;
        }
        return MILLIGRAM;
    }

    public static zzbfj zzc() {
        return zzace.zza;
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
