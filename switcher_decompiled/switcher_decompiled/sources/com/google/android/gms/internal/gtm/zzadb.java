package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzadb implements zzbfh {
    DIET_HALAL(0),
    DIET_KOSHER(1),
    DIET_ORGANIC(2),
    DIET_VEGAN(3),
    DIET_VEGETARIAN(4);

    private static final zzbfi zzf = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzacz
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzadb.zzb(i);
        }
    };
    private final int zzh;

    zzadb(int i) {
        this.zzh = i;
    }

    public static zzadb zzb(int i) {
        if (i == 0) {
            return DIET_HALAL;
        }
        if (i == 1) {
            return DIET_KOSHER;
        }
        if (i == 2) {
            return DIET_ORGANIC;
        }
        if (i == 3) {
            return DIET_VEGAN;
        }
        if (i != 4) {
            return null;
        }
        return DIET_VEGETARIAN;
    }

    public static zzbfj zzc() {
        return zzada.zza;
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
