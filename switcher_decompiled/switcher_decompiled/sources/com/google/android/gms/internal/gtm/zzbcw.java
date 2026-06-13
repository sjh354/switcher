package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbcw implements zzbfh {
    JS_NORMAL(0),
    JS_STRING(1),
    JS_NUMBER(2);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbcu
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbcw.zzb(i);
        }
    };
    private final int zzf;

    zzbcw(int i) {
        this.zzf = i;
    }

    public static zzbcw zzb(int i) {
        if (i == 0) {
            return JS_NORMAL;
        }
        if (i == 1) {
            return JS_STRING;
        }
        if (i != 2) {
            return null;
        }
        return JS_NUMBER;
    }

    public static zzbfj zzc() {
        return zzbcv.zza;
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
