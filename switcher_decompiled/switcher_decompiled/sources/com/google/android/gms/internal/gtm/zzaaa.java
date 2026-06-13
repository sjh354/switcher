package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaaa extends zzbff implements zzbgt {
    private static final zzbfm zza = new zzbfm<Integer, zzaah>() { // from class: com.google.android.gms.internal.gtm.zzaaa.1
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzaah zzb(Integer num) {
            throw null;
        }
    };
    private static final zzaaa zzb;
    private int zzf;
    private float zzh;
    private float zzi;
    private zzzz zzj;
    private zzzz zzk;
    private int zzg = 1;
    private zzbfl zzl = zzah();
    private String zzm = "";

    static {
        zzaaa zzaaaVar = new zzaaa();
        zzb = zzaaaVar;
        zzbff.zzan(zzaaa.class, zzaaaVar);
    }

    private zzaaa() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဌ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006\u001e\u0007ဈ\u0005", new Object[]{"zzf", "zzg", zzaae.zzc(), "zzh", "zzi", "zzj", "zzk", "zzl", zzaah.zzc(), "zzm"});
        }
        if (i2 == 3) {
            return new zzaaa();
        }
        zzzd zzzdVar = null;
        if (i2 == 4) {
            return new zzaab(zzzdVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
