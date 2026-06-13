package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbrj implements zzbfh {
    DEFAULT_ENCODING(0),
    DATE_PACKED32(1),
    __FieldFormat_Encoding__switch_must_have_a_default__(-1);

    private final int zzg;
    public static final zzbrj zzd = DATE_PACKED32;
    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbri
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbrj.zzc(i);
        }
    };

    zzbrj(int i) {
        this.zzg = i;
    }

    public static zzbfi zzb() {
        return zze;
    }

    public static zzbrj zzc(int i) {
        if (i == -1) {
            return __FieldFormat_Encoding__switch_must_have_a_default__;
        }
        if (i == 0) {
            return DEFAULT_ENCODING;
        }
        if (i != 1) {
            return null;
        }
        return DATE_PACKED32;
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
