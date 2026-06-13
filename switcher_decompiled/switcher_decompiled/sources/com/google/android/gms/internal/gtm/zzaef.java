package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaef extends zzbff implements zzbgt {
    private static final zzbfm zza = new zzbfm<Integer, zzabw>() { // from class: com.google.android.gms.internal.gtm.zzaef.1
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzabw zzb(Integer num) {
            throw null;
        }
    };
    private static final zzaef zzb;
    private int zzf;
    private zzayy zzh;
    private zzayj zzi;
    private byte zzl = 2;
    private zzbfp zzg = zzaj();
    private zzbfp zzj = zzaj();
    private zzbfl zzk = zzah();

    static {
        zzaef zzaefVar = new zzaef();
        zzb = zzaefVar;
        zzbff.zzan(zzaef.class, zzaefVar);
    }

    private zzaef() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0002\u0001\u001b\u0002ᐉ\u0000\u0003ဉ\u0001\u0004Л\u0005\u001e", new Object[]{"zzf", "zzg", zzaee.class, "zzh", "zzi", "zzj", zzaeh.class, "zzk", zzabw.zzc()});
        }
        if (i2 == 3) {
            return new zzaef();
        }
        zzacm zzacmVar = null;
        if (i2 == 4) {
            return new zzaeg(zzacmVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
