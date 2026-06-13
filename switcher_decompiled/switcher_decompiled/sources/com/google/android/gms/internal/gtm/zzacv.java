package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzacv implements zzbfh {
    OFFERED_UNSPECIFIED(0),
    OFFERED(1),
    OFFERED_NOT(2),
    OFFERED_ON_WEBSITE(3);

    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzact
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzacv.zzb(i);
        }
    };
    private final int zzg;

    zzacv(int i) {
        this.zzg = i;
    }

    public static zzacv zzb(int i) {
        if (i == 0) {
            return OFFERED_UNSPECIFIED;
        }
        if (i == 1) {
            return OFFERED;
        }
        if (i == 2) {
            return OFFERED_NOT;
        }
        if (i != 3) {
            return null;
        }
        return OFFERED_ON_WEBSITE;
    }

    public static zzbfj zzc() {
        return zzacu.zza;
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
