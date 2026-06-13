package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzaiy implements zzbfh {
    TYPE_FEATURE(17),
    TYPE_POSTAL_CODE_SUFFIX(18),
    TYPE_POST_BOX(21),
    TYPE_STREET_NUMBER(22),
    TYPE_FLOOR(23),
    TYPE_ROOM(24),
    TYPE_HOUSE_ID(25),
    TYPE_DISTANCE_MARKER(26),
    TYPE_LANDMARK(27),
    TYPE_PLUS_CODE(28);

    private static final zzbfi zzk = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaiw
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzaiy.zzb(i);
        }
    };
    private final int zzm;

    zzaiy(int i) {
        this.zzm = i;
    }

    public static zzaiy zzb(int i) {
        switch (i) {
            case 17:
                return TYPE_FEATURE;
            case 18:
                return TYPE_POSTAL_CODE_SUFFIX;
            case 19:
            case 20:
            default:
                return null;
            case 21:
                return TYPE_POST_BOX;
            case 22:
                return TYPE_STREET_NUMBER;
            case 23:
                return TYPE_FLOOR;
            case 24:
                return TYPE_ROOM;
            case 25:
                return TYPE_HOUSE_ID;
            case 26:
                return TYPE_DISTANCE_MARKER;
            case 27:
                return TYPE_LANDMARK;
            case 28:
                return TYPE_PLUS_CODE;
        }
    }

    public static zzbfj zzc() {
        return zzaix.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzm);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzm;
    }
}
