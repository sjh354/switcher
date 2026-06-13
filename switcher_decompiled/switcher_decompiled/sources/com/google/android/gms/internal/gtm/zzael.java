package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzael implements zzbfh {
    PROPERTY_VALUE_STATUS_UNSPECIFIED(0),
    HAS_NO_VALUE(2),
    HAS_UNKNOWN_VALUE(4);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaej
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzael.zzb(i);
        }
    };
    private final int zzf;

    zzael(int i) {
        this.zzf = i;
    }

    public static zzael zzb(int i) {
        if (i == 0) {
            return PROPERTY_VALUE_STATUS_UNSPECIFIED;
        }
        if (i == 2) {
            return HAS_NO_VALUE;
        }
        if (i != 4) {
            return null;
        }
        return HAS_UNKNOWN_VALUE;
    }

    public static zzbfj zzc() {
        return zzaek.zza;
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
