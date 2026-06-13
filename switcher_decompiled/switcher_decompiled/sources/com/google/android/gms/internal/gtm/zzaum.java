package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzaum implements zzbfh {
    CONSTRUCTION_PLANNED(1),
    CONSTRUCTION_STARTED(2),
    CONSTRUCTION_COMPLETE(3),
    CONSTRUCTION_CLOSED_FOR_MAINTENANCE(4),
    CONSTRUCTION_DISTURBED_BY_MAINTENANCE(5);

    private static final zzbfi zzf = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzauk
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzaum.zzb(i);
        }
    };
    private final int zzh;

    zzaum(int i) {
        this.zzh = i;
    }

    public static zzaum zzb(int i) {
        if (i == 1) {
            return CONSTRUCTION_PLANNED;
        }
        if (i == 2) {
            return CONSTRUCTION_STARTED;
        }
        if (i == 3) {
            return CONSTRUCTION_COMPLETE;
        }
        if (i == 4) {
            return CONSTRUCTION_CLOSED_FOR_MAINTENANCE;
        }
        if (i != 5) {
            return null;
        }
        return CONSTRUCTION_DISTURBED_BY_MAINTENANCE;
    }

    public static zzbfj zzc() {
        return zzaul.zza;
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
