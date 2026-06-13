package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzr implements zzbfh {
    NO_CACHE(1),
    PRIVATE(2),
    PUBLIC(3);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzp
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzr.zzb(i);
        }
    };
    private final int zzf;

    zzr(int i) {
        this.zzf = i;
    }

    public static zzr zzb(int i) {
        if (i == 1) {
            return NO_CACHE;
        }
        if (i == 2) {
            return PRIVATE;
        }
        if (i != 3) {
            return null;
        }
        return PUBLIC;
    }

    public static zzbfj zzc() {
        return zzq.zza;
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
