package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzaot implements zzbfh {
    CROSSING_ALLOWED(1),
    CROSSING_DISALLOWED(2),
    CROSSING_LEGALLY_DISALLOWED(33),
    CROSSING_PHYSICALLY_IMPOSSIBLE(34);

    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaor
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzaot.zzb(i);
        }
    };
    private final int zzg;

    zzaot(int i) {
        this.zzg = i;
    }

    public static zzaot zzb(int i) {
        if (i == 1) {
            return CROSSING_ALLOWED;
        }
        if (i == 2) {
            return CROSSING_DISALLOWED;
        }
        if (i == 33) {
            return CROSSING_LEGALLY_DISALLOWED;
        }
        if (i != 34) {
            return null;
        }
        return CROSSING_PHYSICALLY_IMPOSSIBLE;
    }

    public static zzbfj zzc() {
        return zzaos.zza;
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
