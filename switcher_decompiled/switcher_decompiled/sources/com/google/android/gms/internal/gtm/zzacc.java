package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzacc implements zzbfh {
    UNDEFINED_ENERGY_UNIT(0),
    CALORIE(1),
    JOULE(2);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaca
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzacc.zzb(i);
        }
    };
    private final int zzf;

    zzacc(int i) {
        this.zzf = i;
    }

    public static zzacc zzb(int i) {
        if (i == 0) {
            return UNDEFINED_ENERGY_UNIT;
        }
        if (i == 1) {
            return CALORIE;
        }
        if (i != 2) {
            return null;
        }
        return JOULE;
    }

    public static zzbfj zzc() {
        return zzacb.zza;
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
