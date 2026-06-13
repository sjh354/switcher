package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzwu implements zzbfh {
    COMPARISONOPERATOR_UNKNOWN(0),
    LESS_THAN(1),
    GREATER_THAN(2);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzws
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzwu.zzb(i);
        }
    };
    private final int zzf;

    zzwu(int i) {
        this.zzf = i;
    }

    public static zzwu zzb(int i) {
        if (i == 0) {
            return COMPARISONOPERATOR_UNKNOWN;
        }
        if (i == 1) {
            return LESS_THAN;
        }
        if (i != 2) {
            return null;
        }
        return GREATER_THAN;
    }

    public static zzbfj zzc() {
        return zzwt.zza;
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
