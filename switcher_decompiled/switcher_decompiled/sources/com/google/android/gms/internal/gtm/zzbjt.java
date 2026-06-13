package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbjt implements zzbfh {
    DF_NONE(0),
    DF_HTTPHEADER(1),
    DF_COOKIE(2),
    DF_URL(3),
    DF_CGI_ARGS(4),
    DF_HOST_ORDER(5),
    DF_BYTE_SWAPPED(6),
    DF_LOGGING_ELEMENT_TYPE_ID(7);

    private static final zzbfi zzi = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbjs
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbjt.zzc(i);
        }
    };
    private final int zzk;

    zzbjt(int i) {
        this.zzk = i;
    }

    public static zzbfi zzb() {
        return zzi;
    }

    public static zzbjt zzc(int i) {
        switch (i) {
            case 0:
                return DF_NONE;
            case 1:
                return DF_HTTPHEADER;
            case 2:
                return DF_COOKIE;
            case 3:
                return DF_URL;
            case 4:
                return DF_CGI_ARGS;
            case 5:
                return DF_HOST_ORDER;
            case 6:
                return DF_BYTE_SWAPPED;
            case 7:
                return DF_LOGGING_ELEMENT_TYPE_ID;
            default:
                return null;
        }
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzk);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzk;
    }
}
