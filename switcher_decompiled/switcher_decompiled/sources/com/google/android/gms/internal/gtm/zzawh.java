package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzawh implements zzbfh {
    TYPE_ANY(0),
    TYPE_GLADE(1),
    TYPE_TRAIL_TERRAIN(2),
    TYPE_TRAIL(3),
    TYPE_RACE_COURSE(4),
    TYPE_BOWL(5);

    private static final zzbfi zzg = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzawf
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzawh.zzb(i);
        }
    };
    private final int zzi;

    zzawh(int i) {
        this.zzi = i;
    }

    public static zzawh zzb(int i) {
        if (i == 0) {
            return TYPE_ANY;
        }
        if (i == 1) {
            return TYPE_GLADE;
        }
        if (i == 2) {
            return TYPE_TRAIL_TERRAIN;
        }
        if (i == 3) {
            return TYPE_TRAIL;
        }
        if (i == 4) {
            return TYPE_RACE_COURSE;
        }
        if (i != 5) {
            return null;
        }
        return TYPE_BOWL;
    }

    public static zzbfj zzc() {
        return zzawg.zza;
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
