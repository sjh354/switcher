package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzayd implements zzbfh {
    TYPE_OCCASION(1),
    TYPE_RANGE(2);

    private static final zzbfi zzc = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzayb
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzayd.zzb(i);
        }
    };
    private final int zze;

    zzayd(int i) {
        this.zze = i;
    }

    public static zzayd zzb(int i) {
        if (i == 1) {
            return TYPE_OCCASION;
        }
        if (i != 2) {
            return null;
        }
        return TYPE_RANGE;
    }

    public static zzbfj zzc() {
        return zzayc.zza;
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
