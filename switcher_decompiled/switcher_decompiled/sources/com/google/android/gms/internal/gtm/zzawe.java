package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzawe implements zzbfh {
    DIFFICULTY_EASIEST(0),
    DIFFICULTY_EASY(1),
    DIFFICULTY_INTERMEDIATE(2),
    DIFFICULTY_ADVANCED_INTERMEDIATE(3),
    DIFFICULTY_DIFFICULT(4),
    DIFFICULTY_ADVANCED_DIFFICULT(5);

    private static final zzbfi zzg = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzawc
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzawe.zzb(i);
        }
    };
    private final int zzi;

    zzawe(int i) {
        this.zzi = i;
    }

    public static zzawe zzb(int i) {
        if (i == 0) {
            return DIFFICULTY_EASIEST;
        }
        if (i == 1) {
            return DIFFICULTY_EASY;
        }
        if (i == 2) {
            return DIFFICULTY_INTERMEDIATE;
        }
        if (i == 3) {
            return DIFFICULTY_ADVANCED_INTERMEDIATE;
        }
        if (i == 4) {
            return DIFFICULTY_DIFFICULT;
        }
        if (i != 5) {
            return null;
        }
        return DIFFICULTY_ADVANCED_DIFFICULT;
    }

    public static zzbfj zzc() {
        return zzawd.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzi);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzi;
    }
}
