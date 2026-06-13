package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbty implements zzbfh {
    CLIENT_UNKNOWN(0),
    CHIRP(1),
    WAYMO(2),
    GV_ANDROID(3),
    GV_IOS(4);

    private static final zzbfi zzf = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbtw
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbty.zzc(i);
        }
    };
    private final int zzh;

    zzbty(int i) {
        this.zzh = i;
    }

    public static zzbfj zzb() {
        return zzbtx.zza;
    }

    public static zzbty zzc(int i) {
        if (i == 0) {
            return CLIENT_UNKNOWN;
        }
        if (i == 1) {
            return CHIRP;
        }
        if (i == 2) {
            return WAYMO;
        }
        if (i == 3) {
            return GV_ANDROID;
        }
        if (i != 4) {
            return null;
        }
        return GV_IOS;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzh);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzh;
    }
}
