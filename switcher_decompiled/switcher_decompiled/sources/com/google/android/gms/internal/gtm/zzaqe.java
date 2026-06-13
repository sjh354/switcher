package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzaqe implements zzbfh {
    UNKNOWN(0),
    CROSSABLE(1),
    UNMARKED_CROSSING(17),
    MARKED_CROSSING(18),
    UNCROSSABLE(2);

    private static final zzbfi zzf = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaqc
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzaqe.zzb(i);
        }
    };
    private final int zzh;

    zzaqe(int i) {
        this.zzh = i;
    }

    public static zzaqe zzb(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return CROSSABLE;
        }
        if (i == 2) {
            return UNCROSSABLE;
        }
        if (i == 17) {
            return UNMARKED_CROSSING;
        }
        if (i != 18) {
            return null;
        }
        return MARKED_CROSSING;
    }

    public static zzbfj zzc() {
        return zzaqd.zza;
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
