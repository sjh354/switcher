package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbqw implements zzbfh {
    SHA1(0),
    SHA224(1),
    SHA256(2),
    SHA384(4),
    SHA512(3),
    USE_DEFAULT_HASH_ALGORITHM(100),
    NO_HASH_ALGORITHM(101);

    private static final zzbfi zzh = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbqu
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbqw.zzc(i);
        }
    };
    private final int zzj;

    zzbqw(int i) {
        this.zzj = i;
    }

    public static zzbfj zzb() {
        return zzbqv.zza;
    }

    public static zzbqw zzc(int i) {
        if (i == 0) {
            return SHA1;
        }
        if (i == 1) {
            return SHA224;
        }
        if (i == 2) {
            return SHA256;
        }
        if (i == 3) {
            return SHA512;
        }
        if (i == 4) {
            return SHA384;
        }
        if (i == 100) {
            return USE_DEFAULT_HASH_ALGORITHM;
        }
        if (i != 101) {
            return null;
        }
        return NO_HASH_ALGORITHM;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzj);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzj;
    }
}
