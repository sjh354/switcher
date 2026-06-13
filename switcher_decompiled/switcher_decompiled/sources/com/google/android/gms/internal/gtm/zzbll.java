package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbll implements zzbfh {
    THIRD_PARTY(1),
    CURATION(2),
    PARTNER_FEED(3),
    EXTRACTION(4);

    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzblj
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbll.zzc(i);
        }
    };
    private final int zzg;

    zzbll(int i) {
        this.zzg = i;
    }

    public static zzbfj zzb() {
        return zzblk.zza;
    }

    public static zzbll zzc(int i) {
        if (i == 1) {
            return THIRD_PARTY;
        }
        if (i == 2) {
            return CURATION;
        }
        if (i == 3) {
            return PARTNER_FEED;
        }
        if (i != 4) {
            return null;
        }
        return EXTRACTION;
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
