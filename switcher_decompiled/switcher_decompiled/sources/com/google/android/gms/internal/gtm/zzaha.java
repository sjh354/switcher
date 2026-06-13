package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzaha implements zzbfh {
    UNKNOWN(0),
    BLOCKED(16),
    NOT_TRUSTED(32),
    YP_FEEDS(40),
    TRUSTED(48),
    SUPER_TRUSTED(64);

    private static final zzbfi zzg = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzagy
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzaha.zzb(i);
        }
    };
    private final int zzi;

    zzaha(int i) {
        this.zzi = i;
    }

    public static zzaha zzb(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 16) {
            return BLOCKED;
        }
        if (i == 32) {
            return NOT_TRUSTED;
        }
        if (i == 40) {
            return YP_FEEDS;
        }
        if (i == 48) {
            return TRUSTED;
        }
        if (i != 64) {
            return null;
        }
        return SUPER_TRUSTED;
    }

    public static zzbfj zzc() {
        return zzagz.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzi);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzi;
    }
}
