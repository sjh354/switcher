package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzabj implements zzbfh {
    ANY(0),
    CAR(1),
    MOTORCYCLE(2),
    TRUCK(3);

    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzabh
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzabj.zzb(i);
        }
    };
    private final int zzg;

    zzabj(int i) {
        this.zzg = i;
    }

    public static zzabj zzb(int i) {
        if (i == 0) {
            return ANY;
        }
        if (i == 1) {
            return CAR;
        }
        if (i == 2) {
            return MOTORCYCLE;
        }
        if (i != 3) {
            return null;
        }
        return TRUCK;
    }

    public static zzbfj zzc() {
        return zzabi.zza;
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
