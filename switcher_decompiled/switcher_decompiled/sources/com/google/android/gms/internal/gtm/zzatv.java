package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzatv implements zzbfh {
    DISPLAY_PREFERRED(1),
    DISPLAY_BEST(17),
    DISPLAY_OK(2),
    DISPLAY_HIDE(3);

    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzatt
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzatv.zzb(i);
        }
    };
    private final int zzg;

    zzatv(int i) {
        this.zzg = i;
    }

    public static zzatv zzb(int i) {
        if (i == 1) {
            return DISPLAY_PREFERRED;
        }
        if (i == 2) {
            return DISPLAY_OK;
        }
        if (i == 3) {
            return DISPLAY_HIDE;
        }
        if (i != 17) {
            return null;
        }
        return DISPLAY_BEST;
    }

    public static zzbfj zzc() {
        return zzatu.zza;
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
