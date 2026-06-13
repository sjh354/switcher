package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbdz implements zzbfh {
    MESSAGE(0),
    BYTE(1);

    private static final zzbfi zzc = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbdx
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbdz.zzb(i);
        }
    };
    private final int zze;

    zzbdz(int i) {
        this.zze = i;
    }

    public static zzbdz zzb(int i) {
        if (i == 0) {
            return MESSAGE;
        }
        if (i != 1) {
            return null;
        }
        return BYTE;
    }

    public static zzbfj zzc() {
        return zzbdy.zza;
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
