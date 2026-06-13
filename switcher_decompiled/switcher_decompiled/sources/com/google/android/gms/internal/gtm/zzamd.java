package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzamd implements zzbfh {
    CLOSED(0),
    MOVED(1),
    REBRANDED(2);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzamb
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzamd.zzb(i);
        }
    };
    private final int zzf;

    zzamd(int i) {
        this.zzf = i;
    }

    public static zzamd zzb(int i) {
        if (i == 0) {
            return CLOSED;
        }
        if (i == 1) {
            return MOVED;
        }
        if (i != 2) {
            return null;
        }
        return REBRANDED;
    }

    public static zzbfj zzc() {
        return zzamc.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzf);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzf;
    }
}
