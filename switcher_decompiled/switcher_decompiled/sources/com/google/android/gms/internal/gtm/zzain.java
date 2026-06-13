package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzain implements zzbfh {
    TYPE_PRIMARY(1),
    TYPE_SECONDARY(2);

    private static final zzbfi zzc = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzail
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzain.zzb(i);
        }
    };
    private final int zze;

    zzain(int i) {
        this.zze = i;
    }

    public static zzain zzb(int i) {
        if (i == 1) {
            return TYPE_PRIMARY;
        }
        if (i != 2) {
            return null;
        }
        return TYPE_SECONDARY;
    }

    public static zzbfj zzc() {
        return zzaim.zza;
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
