package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbjj implements zzbfh {
    NONE(0),
    SD_CLEARCUT_SOURCE_EXTENSION(1),
    SD_CLEARCUT_SOURCE_EXTENSION_JS(2),
    SD_CLEARCUT_LOGEVENTS(3);

    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbji
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbjj.zzc(i);
        }
    };
    private final int zzg;

    zzbjj(int i) {
        this.zzg = i;
    }

    public static zzbfi zzb() {
        return zze;
    }

    public static zzbjj zzc(int i) {
        if (i == 0) {
            return NONE;
        }
        if (i == 1) {
            return SD_CLEARCUT_SOURCE_EXTENSION;
        }
        if (i == 2) {
            return SD_CLEARCUT_SOURCE_EXTENSION_JS;
        }
        if (i != 3) {
            return null;
        }
        return SD_CLEARCUT_LOGEVENTS;
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
