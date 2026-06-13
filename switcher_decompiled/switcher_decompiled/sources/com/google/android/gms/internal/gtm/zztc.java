package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zztc implements zzbfh {
    INT52(0),
    NUMBER(1),
    STRING(2);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zztb
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zztc.zzb(i);
        }
    };
    private final int zzf;

    zztc(int i) {
        this.zzf = i;
    }

    public static zztc zzb(int i) {
        if (i == 0) {
            return INT52;
        }
        if (i == 1) {
            return NUMBER;
        }
        if (i != 2) {
            return null;
        }
        return STRING;
    }

    public static zzbfi zzc() {
        return zzd;
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
