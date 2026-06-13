package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzxr implements zzbfh {
    UNIT_UNKNOWN(0),
    METERS(1),
    FEET(2);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzxp
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzxr.zzb(i);
        }
    };
    private final int zzf;

    zzxr(int i) {
        this.zzf = i;
    }

    public static zzxr zzb(int i) {
        if (i == 0) {
            return UNIT_UNKNOWN;
        }
        if (i == 1) {
            return METERS;
        }
        if (i != 2) {
            return null;
        }
        return FEET;
    }

    public static zzbfj zzc() {
        return zzxq.zza;
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
