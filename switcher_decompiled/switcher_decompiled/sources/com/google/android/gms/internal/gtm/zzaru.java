package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzaru implements zzbfh {
    CONFLATION_PICK_FIRST_VALUE(0),
    CONFLATION_UNION_CSV(1),
    CONFLATION_SUM(2);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzars
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzaru.zzb(i);
        }
    };
    private final int zzf;

    zzaru(int i) {
        this.zzf = i;
    }

    public static zzaru zzb(int i) {
        if (i == 0) {
            return CONFLATION_PICK_FIRST_VALUE;
        }
        if (i == 1) {
            return CONFLATION_UNION_CSV;
        }
        if (i != 2) {
            return null;
        }
        return CONFLATION_SUM;
    }

    public static zzbfj zzc() {
        return zzart.zza;
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
