package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzasn implements zzbfh {
    STYLE_CONTIGUOUS(0),
    STYLE_SINGLE(1),
    STYLE_TURN(2),
    STYLE_IN_OUT(3);

    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzasl
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzasn.zzb(i);
        }
    };
    private final int zzg;

    zzasn(int i) {
        this.zzg = i;
    }

    public static zzasn zzb(int i) {
        if (i == 0) {
            return STYLE_CONTIGUOUS;
        }
        if (i == 1) {
            return STYLE_SINGLE;
        }
        if (i == 2) {
            return STYLE_TURN;
        }
        if (i != 3) {
            return null;
        }
        return STYLE_IN_OUT;
    }

    public static zzbfj zzc() {
        return zzasm.zza;
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
