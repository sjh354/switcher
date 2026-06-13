package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzble extends zzbff implements zzbgt {
    private static final zzbfm zza = new zzbfm<Integer, zzbli>() { // from class: com.google.android.gms.internal.gtm.zzble.1
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzbli zzb(Integer num) {
            throw null;
        }
    };
    private static final zzble zzb;
    private int zzf;
    private long zzi;
    private long zzk;
    private boolean zzm;
    private int zzn;
    private zzbtd zzo;
    private zzbso zzq;
    private zzbsu zzr;
    private String zzg = "";
    private String zzh = "";
    private int zzj = 1;
    private zzbfl zzl = zzah();
    private String zzp = "";

    static {
        zzble zzbleVar = new zzble();
        zzb = zzbleVar;
        zzbff.zzan(zzble.class, zzbleVar);
    }

    private zzble() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဌ\u0003\u0005ဃ\u0004\u0006\u001e\u0007ဇ\u0005\bင\u0006\tဉ\u0007\nဈ\b\u000bဉ\t\fဉ\n", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", zzbll.zzb(), "zzk", "zzl", zzbli.zzb(), "zzm", "zzn", "zzo", "zzp", "zzq", "zzr"});
        }
        if (i2 == 3) {
            return new zzble();
        }
        zzbku zzbkuVar = null;
        if (i2 == 4) {
            return new zzblf(zzbkuVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
