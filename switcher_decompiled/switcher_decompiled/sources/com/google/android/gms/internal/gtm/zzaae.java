package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzaae implements zzbfh {
    UNKNOWN_DASH_PATTERN(1),
    SOLID(2),
    DASHED(3),
    DOTTED(4),
    DOTTED_DASHED(5);

    private static final zzbfi zzf = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaac
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzaae.zzb(i);
        }
    };
    private final int zzh;

    zzaae(int i) {
        this.zzh = i;
    }

    public static zzaae zzb(int i) {
        if (i == 1) {
            return UNKNOWN_DASH_PATTERN;
        }
        if (i == 2) {
            return SOLID;
        }
        if (i == 3) {
            return DASHED;
        }
        if (i == 4) {
            return DOTTED;
        }
        if (i != 5) {
            return null;
        }
        return DOTTED_DASHED;
    }

    public static zzbfj zzc() {
        return zzaad.zza;
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
