package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzatz implements zzbfh {
    BARRIER_NONE(1),
    BARRIER_PRESENT(2),
    BARRIER_LEGAL(33),
    BARRIER_PHYSICAL(34);

    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzatx
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzatz.zzb(i);
        }
    };
    private final int zzg;

    zzatz(int i) {
        this.zzg = i;
    }

    public static zzatz zzb(int i) {
        if (i == 1) {
            return BARRIER_NONE;
        }
        if (i == 2) {
            return BARRIER_PRESENT;
        }
        if (i == 33) {
            return BARRIER_LEGAL;
        }
        if (i != 34) {
            return null;
        }
        return BARRIER_PHYSICAL;
    }

    public static zzbfj zzc() {
        return zzaty.zza;
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
