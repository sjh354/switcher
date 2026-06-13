package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzaaz implements zzbfh {
    STANDARD(0),
    VALET(1),
    PERMIT(2),
    PICKUP_GOODS(3),
    PICKUP_PASSENGERS(4);

    private static final zzbfi zzf = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaax
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzaaz.zzb(i);
        }
    };
    private final int zzh;

    zzaaz(int i) {
        this.zzh = i;
    }

    public static zzaaz zzb(int i) {
        if (i == 0) {
            return STANDARD;
        }
        if (i == 1) {
            return VALET;
        }
        if (i == 2) {
            return PERMIT;
        }
        if (i == 3) {
            return PICKUP_GOODS;
        }
        if (i != 4) {
            return null;
        }
        return PICKUP_PASSENGERS;
    }

    public static zzbfj zzc() {
        return zzaay.zza;
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
