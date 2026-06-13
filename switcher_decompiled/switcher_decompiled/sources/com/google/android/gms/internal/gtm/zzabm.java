package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzabm implements zzbfh {
    SERVICE_ALL(0),
    SERVICE_GENERAL_DRIVER(1),
    SERVICE_RIDESHARE(2),
    SERVICE_TAXI(3),
    SERVICE_COMMERCIAL(4);

    private static final zzbfi zzf = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzabk
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzabm.zzb(i);
        }
    };
    private final int zzh;

    zzabm(int i) {
        this.zzh = i;
    }

    public static zzabm zzb(int i) {
        if (i == 0) {
            return SERVICE_ALL;
        }
        if (i == 1) {
            return SERVICE_GENERAL_DRIVER;
        }
        if (i == 2) {
            return SERVICE_RIDESHARE;
        }
        if (i == 3) {
            return SERVICE_TAXI;
        }
        if (i != 4) {
            return null;
        }
        return SERVICE_COMMERCIAL;
    }

    public static zzbfj zzc() {
        return zzabl.zza;
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
