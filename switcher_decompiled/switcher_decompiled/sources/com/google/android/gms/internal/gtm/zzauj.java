package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzauj implements zzbfh {
    CONDITION_GOOD(1),
    CONDITION_POOR(2);

    private static final zzbfi zzc = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzauh
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzauj.zzb(i);
        }
    };
    private final int zze;

    zzauj(int i) {
        this.zze = i;
    }

    public static zzauj zzb(int i) {
        if (i == 1) {
            return CONDITION_GOOD;
        }
        if (i != 2) {
            return null;
        }
        return CONDITION_POOR;
    }

    public static zzbfj zzc() {
        return zzaui.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zze);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zze;
    }
}
