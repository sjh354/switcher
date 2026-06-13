package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbse implements zzbfh {
    REQUIRES_CITATION(1),
    REQUIRES_PCOUNSEL_REVIEW(2),
    REQUIRES_ACCESS_CONTROL(3),
    UNRESTRICTED_WITHIN_GOOGLE_NO_3P_USE(4);

    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbsc
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbse.zzc(i);
        }
    };
    private final int zzg;

    zzbse(int i) {
        this.zzg = i;
    }

    public static zzbfj zzb() {
        return zzbsd.zza;
    }

    public static zzbse zzc(int i) {
        if (i == 1) {
            return REQUIRES_CITATION;
        }
        if (i == 2) {
            return REQUIRES_PCOUNSEL_REVIEW;
        }
        if (i == 3) {
            return REQUIRES_ACCESS_CONTROL;
        }
        if (i != 4) {
            return null;
        }
        return UNRESTRICTED_WITHIN_GOOGLE_NO_3P_USE;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzg);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzg;
    }
}
