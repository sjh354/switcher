package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzacq implements zzbfh {
    CTA_TYPE_UNSPECIFIED(0),
    CTA_TYPE_BOOK(1),
    CTA_TYPE_BUY(2),
    CTA_TYPE_ORDER_ONLINE(3),
    CTA_TYPE_LEARN_MORE(4),
    CTA_TYPE_SIGN_UP(5),
    CTA_TYPE_GET_OFFER(6);

    private static final zzbfi zzh = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzaco
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzacq.zzb(i);
        }
    };
    private final int zzj;

    zzacq(int i) {
        this.zzj = i;
    }

    public static zzacq zzb(int i) {
        switch (i) {
            case 0:
                return CTA_TYPE_UNSPECIFIED;
            case 1:
                return CTA_TYPE_BOOK;
            case 2:
                return CTA_TYPE_BUY;
            case 3:
                return CTA_TYPE_ORDER_ONLINE;
            case 4:
                return CTA_TYPE_LEARN_MORE;
            case 5:
                return CTA_TYPE_SIGN_UP;
            case 6:
                return CTA_TYPE_GET_OFFER;
            default:
                return null;
        }
    }

    public static zzbfj zzc() {
        return zzacp.zza;
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
