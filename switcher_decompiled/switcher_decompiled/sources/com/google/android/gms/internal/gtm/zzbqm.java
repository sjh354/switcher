package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbqm implements zzbfh {
    KEYMASTER_PERMUTE(0),
    KEYMASTER_PERMUTE_V2(1);

    private static final zzbfi zzc = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbqk
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbqm.zzc(i);
        }
    };
    private final int zze;

    zzbqm(int i) {
        this.zze = i;
    }

    public static zzbfj zzb() {
        return zzbql.zza;
    }

    public static zzbqm zzc(int i) {
        if (i == 0) {
            return KEYMASTER_PERMUTE;
        }
        if (i != 1) {
            return null;
        }
        return KEYMASTER_PERMUTE_V2;
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
