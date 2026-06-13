package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzaxa implements zzbfh {
    VOICE(0),
    FAX(1),
    TDD(2),
    DATA(3),
    MOBILE(4),
    MESSAGING(5);

    private static final zzbfi zzg = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzawy
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzaxa.zzb(i);
        }
    };
    private final int zzi;

    zzaxa(int i) {
        this.zzi = i;
    }

    public static zzaxa zzb(int i) {
        if (i == 0) {
            return VOICE;
        }
        if (i == 1) {
            return FAX;
        }
        if (i == 2) {
            return TDD;
        }
        if (i == 3) {
            return DATA;
        }
        if (i == 4) {
            return MOBILE;
        }
        if (i != 5) {
            return null;
        }
        return MESSAGING;
    }

    public static zzbfj zzc() {
        return zzawz.zza;
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
