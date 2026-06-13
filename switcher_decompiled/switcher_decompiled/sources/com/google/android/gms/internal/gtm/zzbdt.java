package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbdt implements zzbfh {
    TCP(0),
    UDP(1);

    private static final zzbfi zzc = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbdr
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbdt.zzb(i);
        }
    };
    private final int zze;

    zzbdt(int i) {
        this.zze = i;
    }

    public static zzbdt zzb(int i) {
        if (i == 0) {
            return TCP;
        }
        if (i != 1) {
            return null;
        }
        return UDP;
    }

    public static zzbfj zzc() {
        return zzbds.zza;
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
