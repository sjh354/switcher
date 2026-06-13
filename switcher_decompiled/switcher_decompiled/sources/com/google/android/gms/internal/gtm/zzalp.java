package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzalp implements zzbfh {
    ENTER_AND_EXIT(0),
    ENTER_ONLY(1),
    EXIT_ONLY(2);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaln
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzalp.zzb(i);
        }
    };
    private final int zzf;

    zzalp(int i) {
        this.zzf = i;
    }

    public static zzalp zzb(int i) {
        if (i == 0) {
            return ENTER_AND_EXIT;
        }
        if (i == 1) {
            return ENTER_ONLY;
        }
        if (i != 2) {
            return null;
        }
        return EXIT_ONLY;
    }

    public static zzbfj zzc() {
        return zzalo.zza;
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
