package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzyv implements zzbfh {
    NOT_BULK_UPDATABLE(0),
    BULK_UPDATABLE(1);

    private static final zzbfi zzc = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzyt
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzyv.zzb(i);
        }
    };
    private final int zze;

    zzyv(int i) {
        this.zze = i;
    }

    public static zzyv zzb(int i) {
        if (i == 0) {
            return NOT_BULK_UPDATABLE;
        }
        if (i != 1) {
            return null;
        }
        return BULK_UPDATABLE;
    }

    public static zzbfj zzc() {
        return zzyu.zza;
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
