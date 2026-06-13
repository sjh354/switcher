package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzahr implements zzbfh {
    UNKNOWN(0),
    ANY(1),
    CAR(2),
    MOTORCYCLE(3),
    TRUCK(4),
    BUS(5);

    private static final zzbfi zzg = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzahp
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzahr.zzb(i);
        }
    };
    private final int zzi;

    zzahr(int i) {
        this.zzi = i;
    }

    public static zzahr zzb(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return ANY;
        }
        if (i == 2) {
            return CAR;
        }
        if (i == 3) {
            return MOTORCYCLE;
        }
        if (i == 4) {
            return TRUCK;
        }
        if (i != 5) {
            return null;
        }
        return BUS;
    }

    public static zzbfj zzc() {
        return zzahq.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzi);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzi;
    }
}
