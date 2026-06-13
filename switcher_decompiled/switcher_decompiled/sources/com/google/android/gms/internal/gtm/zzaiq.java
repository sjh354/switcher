package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzaiq implements zzbfh {
    TRAVEL_MODE_MOTOR_VEHICLE(1),
    TRAVEL_MODE_AUTO(17),
    TRAVEL_MODE_TWO_WHEELER(18),
    TRAVEL_MODE_BICYCLE(2),
    TRAVEL_MODE_PEDESTRIAN(3),
    TRAVEL_MODE_PUBLIC_TRANSIT(4);

    private static final zzbfi zzg = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaio
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzaiq.zzb(i);
        }
    };
    private final int zzi;

    zzaiq(int i) {
        this.zzi = i;
    }

    public static zzaiq zzb(int i) {
        if (i == 1) {
            return TRAVEL_MODE_MOTOR_VEHICLE;
        }
        if (i == 2) {
            return TRAVEL_MODE_BICYCLE;
        }
        if (i == 3) {
            return TRAVEL_MODE_PEDESTRIAN;
        }
        if (i == 4) {
            return TRAVEL_MODE_PUBLIC_TRANSIT;
        }
        if (i == 17) {
            return TRAVEL_MODE_AUTO;
        }
        if (i != 18) {
            return null;
        }
        return TRAVEL_MODE_TWO_WHEELER;
    }

    public static zzbfj zzc() {
        return zzaip.zza;
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
