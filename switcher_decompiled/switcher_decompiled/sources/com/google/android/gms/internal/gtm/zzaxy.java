package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzaxy implements zzbfh {
    WEEK_OF_MONTH(0),
    WEEK_OF_YEAR(1);

    private static final zzbfi zzc = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaxw
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzaxy.zzb(i);
        }
    };
    private final int zze;

    zzaxy(int i) {
        this.zze = i;
    }

    public static zzaxy zzb(int i) {
        if (i == 0) {
            return WEEK_OF_MONTH;
        }
        if (i != 1) {
            return null;
        }
        return WEEK_OF_YEAR;
    }

    public static zzbfj zzc() {
        return zzaxx.zza;
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
