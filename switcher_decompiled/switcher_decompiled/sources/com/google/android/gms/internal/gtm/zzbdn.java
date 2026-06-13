package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbdn implements zzbfh {
    IDEMPOTENCY_UNKNOWN(0),
    NO_SIDE_EFFECTS(1),
    IDEMPOTENT(2);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbdl
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbdn.zzb(i);
        }
    };
    private final int zzf;

    zzbdn(int i) {
        this.zzf = i;
    }

    public static zzbdn zzb(int i) {
        if (i == 0) {
            return IDEMPOTENCY_UNKNOWN;
        }
        if (i == 1) {
            return NO_SIDE_EFFECTS;
        }
        if (i != 2) {
            return null;
        }
        return IDEMPOTENT;
    }

    public static zzbfj zzc() {
        return zzbdm.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzf);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzf;
    }
}
