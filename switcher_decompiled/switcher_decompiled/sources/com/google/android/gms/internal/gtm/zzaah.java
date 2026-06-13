package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzaah implements zzbfh {
    UNKNOWN_STRIPE_MATERIAL(1),
    PAINT_STRIPE(2),
    ROUND_DOT(3),
    SQUARE_DOT(4);

    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaaf
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzaah.zzb(i);
        }
    };
    private final int zzg;

    zzaah(int i) {
        this.zzg = i;
    }

    public static zzaah zzb(int i) {
        if (i == 1) {
            return UNKNOWN_STRIPE_MATERIAL;
        }
        if (i == 2) {
            return PAINT_STRIPE;
        }
        if (i == 3) {
            return ROUND_DOT;
        }
        if (i != 4) {
            return null;
        }
        return SQUARE_DOT;
    }

    public static zzbfj zzc() {
        return zzaag.zza;
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
