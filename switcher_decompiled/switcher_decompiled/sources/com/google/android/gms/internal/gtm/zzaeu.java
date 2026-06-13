package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzaeu implements zzbfh {
    UNKNOWN_RIGHTS(0),
    GT_RIGHTS(5),
    FULL_RIGHTS(10);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaes
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzaeu.zzb(i);
        }
    };
    private final int zzf;

    zzaeu(int i) {
        this.zzf = i;
    }

    public static zzaeu zzb(int i) {
        if (i == 0) {
            return UNKNOWN_RIGHTS;
        }
        if (i == 5) {
            return GT_RIGHTS;
        }
        if (i != 10) {
            return null;
        }
        return FULL_RIGHTS;
    }

    public static zzbfj zzc() {
        return zzaet.zza;
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
