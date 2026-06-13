package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzawu implements zzbfh {
    CONTACT_CATEGORY_UNSPECIFIED(0),
    CUSTOMER_SERVICE(1),
    RESERVATIONS(2),
    SALES(3);

    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaws
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzawu.zzb(i);
        }
    };
    private final int zzg;

    zzawu(int i) {
        this.zzg = i;
    }

    public static zzawu zzb(int i) {
        if (i == 0) {
            return CONTACT_CATEGORY_UNSPECIFIED;
        }
        if (i == 1) {
            return CUSTOMER_SERVICE;
        }
        if (i == 2) {
            return RESERVATIONS;
        }
        if (i != 3) {
            return null;
        }
        return SALES;
    }

    public static zzbfj zzc() {
        return zzawt.zza;
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
