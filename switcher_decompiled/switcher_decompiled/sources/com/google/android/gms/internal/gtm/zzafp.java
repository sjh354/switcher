package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzafp implements zzbfh {
    SPEED_LIMIT_CATEGORY_UNKNOWN(0),
    NONE(1),
    SCHOOL(2),
    CONSTRUCTION(3);

    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzafn
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzafp.zzb(i);
        }
    };
    private final int zzg;

    zzafp(int i) {
        this.zzg = i;
    }

    public static zzafp zzb(int i) {
        if (i == 0) {
            return SPEED_LIMIT_CATEGORY_UNKNOWN;
        }
        if (i == 1) {
            return NONE;
        }
        if (i == 2) {
            return SCHOOL;
        }
        if (i != 3) {
            return null;
        }
        return CONSTRUCTION;
    }

    public static zzbfj zzc() {
        return zzafo.zza;
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
