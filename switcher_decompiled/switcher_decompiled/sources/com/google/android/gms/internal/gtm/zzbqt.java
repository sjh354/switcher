package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbqt implements zzbfh {
    NIST_P224(1),
    NIST_P256(2),
    NIST_P384(3),
    NIST_P521(4);

    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbqr
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbqt.zzc(i);
        }
    };
    private final int zzg;

    zzbqt(int i) {
        this.zzg = i;
    }

    public static zzbfj zzb() {
        return zzbqs.zza;
    }

    public static zzbqt zzc(int i) {
        if (i == 1) {
            return NIST_P224;
        }
        if (i == 2) {
            return NIST_P256;
        }
        if (i == 3) {
            return NIST_P384;
        }
        if (i != 4) {
            return null;
        }
        return NIST_P521;
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
