package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzask implements zzbfh {
    SCOPE_DIRECTION(0),
    SCOPE_SIDE(1);

    private static final zzbfi zzc = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzasi
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzask.zzb(i);
        }
    };
    private final int zze;

    zzask(int i) {
        this.zze = i;
    }

    public static zzask zzb(int i) {
        if (i == 0) {
            return SCOPE_DIRECTION;
        }
        if (i != 1) {
            return null;
        }
        return SCOPE_SIDE;
    }

    public static zzbfj zzc() {
        return zzasj.zza;
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
