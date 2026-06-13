package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzat implements zzbfh {
    STRING(1),
    LIST(2),
    MAP(3),
    MACRO_REFERENCE(4),
    FUNCTION_ID(5),
    INTEGER(6),
    TEMPLATE(7),
    BOOLEAN(8);

    private static final zzbfi zzi = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzar
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzat.zzb(i);
        }
    };
    private final int zzk;

    zzat(int i) {
        this.zzk = i;
    }

    public static zzat zzb(int i) {
        switch (i) {
            case 1:
                return STRING;
            case 2:
                return LIST;
            case 3:
                return MAP;
            case 4:
                return MACRO_REFERENCE;
            case 5:
                return FUNCTION_ID;
            case 6:
                return INTEGER;
            case 7:
                return TEMPLATE;
            case 8:
                return BOOLEAN;
            default:
                return null;
        }
    }

    public static zzbfj zzc() {
        return zzas.zza;
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
