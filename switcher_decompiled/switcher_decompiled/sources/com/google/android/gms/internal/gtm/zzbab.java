package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbab implements zzbfh {
    NON_PRIMARY(0),
    PRIMARY(1000);

    private static final zzbfi zzc = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzazz
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbab.zzb(i);
        }
    };
    private final int zze;

    zzbab(int i) {
        this.zze = i;
    }

    public static zzbab zzb(int i) {
        if (i == 0) {
            return NON_PRIMARY;
        }
        if (i != 1000) {
            return null;
        }
        return PRIMARY;
    }

    public static zzbfj zzc() {
        return zzbaa.zza;
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
