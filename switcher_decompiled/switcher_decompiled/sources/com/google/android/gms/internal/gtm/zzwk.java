package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzwk implements zzbfh {
    SPEED_LIMIT_TRUST_LEVEL_UNKNOWN(0),
    LOW_QUALITY(1),
    HIGH_QUALITY(2),
    EXACT(3);

    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzwi
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzwk.zzb(i);
        }
    };
    private final int zzg;

    zzwk(int i) {
        this.zzg = i;
    }

    public static zzwk zzb(int i) {
        if (i == 0) {
            return SPEED_LIMIT_TRUST_LEVEL_UNKNOWN;
        }
        if (i == 1) {
            return LOW_QUALITY;
        }
        if (i == 2) {
            return HIGH_QUALITY;
        }
        if (i != 3) {
            return null;
        }
        return EXACT;
    }

    public static zzbfj zzc() {
        return zzwj.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzg);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzg;
    }
}
