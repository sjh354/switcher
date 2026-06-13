package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbnr implements zzbfh {
    USASCIIBYTES(1),
    RAWBYTES(2);

    private static final zzbfi zzc = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbnp
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbnr.zzc(i);
        }
    };
    private final int zze;

    zzbnr(int i) {
        this.zze = i;
    }

    public static zzbfj zzb() {
        return zzbnq.zza;
    }

    public static zzbnr zzc(int i) {
        if (i == 1) {
            return USASCIIBYTES;
        }
        if (i != 2) {
            return null;
        }
        return RAWBYTES;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zze);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zze;
    }
}
