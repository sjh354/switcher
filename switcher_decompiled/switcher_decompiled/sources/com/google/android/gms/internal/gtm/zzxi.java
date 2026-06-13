package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzxi implements zzbfh {
    UNSPECIFIED(0),
    BEZIER(1),
    CIRCLE(2),
    STRAIGHT_EDGE(3);

    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzxg
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzxi.zzb(i);
        }
    };
    private final int zzg;

    zzxi(int i) {
        this.zzg = i;
    }

    public static zzxi zzb(int i) {
        if (i == 0) {
            return UNSPECIFIED;
        }
        if (i == 1) {
            return BEZIER;
        }
        if (i == 2) {
            return CIRCLE;
        }
        if (i != 3) {
            return null;
        }
        return STRAIGHT_EDGE;
    }

    public static zzbfj zzc() {
        return zzxh.zza;
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
