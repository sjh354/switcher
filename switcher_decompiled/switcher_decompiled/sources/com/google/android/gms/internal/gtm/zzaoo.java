package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzaoo implements zzbfh {
    CONJOINED_NONE(0),
    CONJOINED_SPLIT_LEFT(1),
    CONJOINED_SPLIT_MIDDLE(2),
    CONJOINED_SPLIT_RIGHT(3),
    CONJOINED_MERGE_LEFT(4),
    CONJOINED_MERGE_MIDDLE(5),
    CONJOINED_MERGE_RIGHT(6);

    private static final zzbfi zzh = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaom
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzaoo.zzb(i);
        }
    };
    private final int zzj;

    zzaoo(int i) {
        this.zzj = i;
    }

    public static zzaoo zzb(int i) {
        switch (i) {
            case 0:
                return CONJOINED_NONE;
            case 1:
                return CONJOINED_SPLIT_LEFT;
            case 2:
                return CONJOINED_SPLIT_MIDDLE;
            case 3:
                return CONJOINED_SPLIT_RIGHT;
            case 4:
                return CONJOINED_MERGE_LEFT;
            case 5:
                return CONJOINED_MERGE_MIDDLE;
            case 6:
                return CONJOINED_MERGE_RIGHT;
            default:
                return null;
        }
    }

    public static zzbfj zzc() {
        return zzaon.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzj);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzj;
    }
}
