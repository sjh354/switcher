package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzuv implements zzbfh {
    ROLLOUT_STATE_UNKNOWN(0),
    ROLLOUT_DISABLED_KEEP_OVERRIDES(1),
    ROLLOUT_ENABLED_KEEP_OVERRIDES(2),
    ROLLOUT_ENABLED_REMOVE_OVERRIDES(3),
    ROLLOUT_DISABLED_REMOVE_OVERRIDES(4);

    private static final zzbfi zzf = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzut
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzuv.zzb(i);
        }
    };
    private final int zzh;

    zzuv(int i) {
        this.zzh = i;
    }

    public static zzuv zzb(int i) {
        if (i == 0) {
            return ROLLOUT_STATE_UNKNOWN;
        }
        if (i == 1) {
            return ROLLOUT_DISABLED_KEEP_OVERRIDES;
        }
        if (i == 2) {
            return ROLLOUT_ENABLED_KEEP_OVERRIDES;
        }
        if (i == 3) {
            return ROLLOUT_ENABLED_REMOVE_OVERRIDES;
        }
        if (i != 4) {
            return null;
        }
        return ROLLOUT_DISABLED_REMOVE_OVERRIDES;
    }

    public static zzbfj zzc() {
        return zzuu.zza;
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
