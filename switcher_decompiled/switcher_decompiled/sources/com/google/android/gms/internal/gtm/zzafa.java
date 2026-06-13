package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzafa extends zzbff implements zzbgt {
    private static final zzbfm zza = new zzbfm<Integer, zzahr>() { // from class: com.google.android.gms.internal.gtm.zzafa.1
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzahr zzb(Integer num) {
            throw null;
        }
    };
    private static final zzafa zzb;
    private int zzf;
    private zzayj zzg;
    private zzbfl zzh = zzah();
    private zzahk zzi;

    static {
        zzafa zzafaVar = new zzafa();
        zzb = zzafaVar;
        zzbff.zzan(zzafa.class, zzafaVar);
    }

    private zzafa() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001e\u0004ဉ\u0001", new Object[]{"zzf", "zzg", "zzh", zzahr.zzc(), "zzi"});
        }
        if (i2 == 3) {
            return new zzafa();
        }
        AnonymousClass1 anonymousClass1 = null;
        if (i2 == 4) {
            return new zzafb(anonymousClass1);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
