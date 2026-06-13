package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzadl implements zzbfh {
    SPICINESS_NONE(0),
    SPICINESS_MILD(1),
    SPICINESS_MEDIUM(2),
    SPICINESS_HOT(3);

    private static final zzbfi zze = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzadj
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzadl.zzb(i);
        }
    };
    private final int zzg;

    zzadl(int i) {
        this.zzg = i;
    }

    public static zzadl zzb(int i) {
        if (i == 0) {
            return SPICINESS_NONE;
        }
        if (i == 1) {
            return SPICINESS_MILD;
        }
        if (i == 2) {
            return SPICINESS_MEDIUM;
        }
        if (i != 3) {
            return null;
        }
        return SPICINESS_HOT;
    }

    public static zzbfj zzc() {
        return zzadk.zza;
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
