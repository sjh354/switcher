package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbli implements zzbfh {
    REQUIRES_CITATION(1),
    REQUIRES_PCOUNSEL_REVIEW(2),
    UNRESTRICTED_WITHIN_GOOGLE_NO_3P_USE(3);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzblg
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbli.zzc(i);
        }
    };
    private final int zzf;

    zzbli(int i) {
        this.zzf = i;
    }

    public static zzbfj zzb() {
        return zzblh.zza;
    }

    public static zzbli zzc(int i) {
        if (i == 1) {
            return REQUIRES_CITATION;
        }
        if (i == 2) {
            return REQUIRES_PCOUNSEL_REVIEW;
        }
        if (i != 3) {
            return null;
        }
        return UNRESTRICTED_WITHIN_GOOGLE_NO_3P_USE;
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
