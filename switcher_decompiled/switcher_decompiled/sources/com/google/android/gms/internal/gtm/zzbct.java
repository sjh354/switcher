package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbct implements zzbfh {
    STRING(0),
    CORD(1),
    STRING_PIECE(2);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbcr
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbct.zzb(i);
        }
    };
    private final int zzf;

    zzbct(int i) {
        this.zzf = i;
    }

    public static zzbct zzb(int i) {
        if (i == 0) {
            return STRING;
        }
        if (i == 1) {
            return CORD;
        }
        if (i != 2) {
            return null;
        }
        return STRING_PIECE;
    }

    public static zzbfj zzc() {
        return zzbcs.zza;
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
