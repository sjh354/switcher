package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzavb implements zzbfh {
    PRIORITY_UNKNOWN(0),
    PRIORITY_NON_TRAFFIC(16),
    PRIORITY_TERMINAL(32),
    PRIORITY_LOCAL(48),
    PRIORITY_MINOR_ARTERIAL(64),
    PRIORITY_MAJOR_ARTERIAL(80),
    PRIORITY_SECONDARY_ROAD(96),
    PRIORITY_PRIMARY_HIGHWAY(112),
    PRIORITY_LIMITED_ACCESS(128),
    PRIORITY_CONTROLLED_ACCESS(144);

    private static final zzbfi zzk = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzauz
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzavb.zzb(i);
        }
    };
    private final int zzm;

    zzavb(int i) {
        this.zzm = i;
    }

    public static zzavb zzb(int i) {
        if (i == 0) {
            return PRIORITY_UNKNOWN;
        }
        if (i == 16) {
            return PRIORITY_NON_TRAFFIC;
        }
        if (i == 32) {
            return PRIORITY_TERMINAL;
        }
        if (i == 48) {
            return PRIORITY_LOCAL;
        }
        if (i == 64) {
            return PRIORITY_MINOR_ARTERIAL;
        }
        if (i == 80) {
            return PRIORITY_MAJOR_ARTERIAL;
        }
        if (i == 96) {
            return PRIORITY_SECONDARY_ROAD;
        }
        if (i == 112) {
            return PRIORITY_PRIMARY_HIGHWAY;
        }
        if (i == 128) {
            return PRIORITY_LIMITED_ACCESS;
        }
        if (i != 144) {
            return null;
        }
        return PRIORITY_CONTROLLED_ACCESS;
    }

    public static zzbfj zzc() {
        return zzava.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzm);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzm;
    }
}
