package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaav extends zzbff implements zzbgt {
    private static final zzbfm zza = new zzbfm<Integer, zzabm>() { // from class: com.google.android.gms.internal.gtm.zzaav.1
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzabm zzb(Integer num) {
            throw null;
        }
    };
    private static final zzaav zzb;
    private int zzf;
    private int zzg;
    private int zzh;
    private boolean zzl;
    private byte zzn = 2;
    private zzbfl zzi = zzah();
    private zzbfp zzj = zzaj();
    private zzbfp zzk = zzaj();
    private zzbfp zzm = zzaj();

    static {
        zzaav zzaavVar = new zzaav();
        zzb = zzaavVar;
        zzbff.zzan(zzaav.class, zzaavVar);
    }

    private zzaav() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzn);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0004\u0002\u0001ဌ\u0000\u0002ဌ\u0001\u0003\u001b\u0004Л\u0005ဇ\u0002\u0006Л\u0007\u001e", new Object[]{"zzf", "zzg", zzaaz.zzc(), "zzh", zzabj.zzc(), "zzj", zzapd.class, "zzk", zzvx.class, "zzl", "zzm", zzagh.class, "zzi", zzabm.zzc()});
        }
        if (i2 == 3) {
            return new zzaav();
        }
        zzaau zzaauVar = null;
        if (i2 == 4) {
            return new zzaaw(zzaauVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzn = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
