package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzun implements zzbfh {
    UNSPECIFIED(0),
    WIRE(1),
    TEXT(2),
    JSON(3);

    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzul
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzun.zzb(i);
        }
    };
    private final int zzg;

    zzun(int i) {
        this.zzg = i;
    }

    public static zzun zzb(int i) {
        if (i == 0) {
            return UNSPECIFIED;
        }
        if (i == 1) {
            return WIRE;
        }
        if (i == 2) {
            return TEXT;
        }
        if (i != 3) {
            return null;
        }
        return JSON;
    }

    public static zzbfj zzc() {
        return zzum.zza;
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
