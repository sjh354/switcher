package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzanj implements zzbfh {
    HTML_DESCRIPTION(17);

    private static final zzbfi zzb = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzanh
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzanj.zzb(i);
        }
    };
    private final int zzd = 17;

    zzanj(int i) {
    }

    public static zzanj zzb(int i) {
        if (i != 17) {
            return null;
        }
        return HTML_DESCRIPTION;
    }

    public static zzbfj zzc() {
        return zzani.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzd);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzd;
    }
}
