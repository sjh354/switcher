package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbdk implements zzbfh {
    UNCOMPRESSED(0),
    ZIPPY_COMPRESSED(1);

    private static final zzbfi zzc = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbdi
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbdk.zzb(i);
        }
    };
    private final int zze;

    zzbdk(int i) {
        this.zze = i;
    }

    public static zzbdk zzb(int i) {
        if (i == 0) {
            return UNCOMPRESSED;
        }
        if (i != 1) {
            return null;
        }
        return ZIPPY_COMPRESSED;
    }

    public static zzbfj zzc() {
        return zzbdj.zza;
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
