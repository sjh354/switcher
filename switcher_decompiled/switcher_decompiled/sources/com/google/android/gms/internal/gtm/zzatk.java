package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzatk implements zzbfh {
    TYPE_UNIFIED(0),
    TYPE_ELEMENTARY(1),
    TYPE_SECONDARY(2);

    private static final zzbfi zzd = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzati
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzatk.zzb(i);
        }
    };
    private final int zzf;

    zzatk(int i) {
        this.zzf = i;
    }

    public static zzatk zzb(int i) {
        if (i == 0) {
            return TYPE_UNIFIED;
        }
        if (i == 1) {
            return TYPE_ELEMENTARY;
        }
        if (i != 2) {
            return null;
        }
        return TYPE_SECONDARY;
    }

    public static zzbfj zzc() {
        return zzatj.zza;
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
