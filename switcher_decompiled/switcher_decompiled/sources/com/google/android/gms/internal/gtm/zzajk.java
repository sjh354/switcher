package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzajk implements zzbfh {
    ITEMCLASS(1),
    ATTRIBUTE(2),
    VALUESPACE(3),
    DATASTORE(4);

    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaji
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzajk.zzb(i);
        }
    };
    private final int zzg;

    zzajk(int i) {
        this.zzg = i;
    }

    public static zzajk zzb(int i) {
        if (i == 1) {
            return ITEMCLASS;
        }
        if (i == 2) {
            return ATTRIBUTE;
        }
        if (i == 3) {
            return VALUESPACE;
        }
        if (i != 4) {
            return null;
        }
        return DATASTORE;
    }

    public static zzbfj zzc() {
        return zzajj.zza;
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
