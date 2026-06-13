package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzany implements zzbfh {
    GROUP_ARTIFACT(1),
    GROUP_LOGICAL(2);

    private static final zzbfi zzc = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzanw
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzany.zzb(i);
        }
    };
    private final int zze;

    zzany(int i) {
        this.zze = i;
    }

    public static zzany zzb(int i) {
        if (i == 1) {
            return GROUP_ARTIFACT;
        }
        if (i != 2) {
            return null;
        }
        return GROUP_LOGICAL;
    }

    public static zzbfj zzc() {
        return zzanx.zza;
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
