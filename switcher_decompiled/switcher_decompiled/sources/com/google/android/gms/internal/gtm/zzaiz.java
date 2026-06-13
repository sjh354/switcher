package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaiz extends zzbff implements zzbgt {
    private static final zzaiz zza;
    private int zzb;
    private int zzh;
    private zzamq zzi;
    private zzajf zzj;
    private zzbmd zzk;
    private int zzl;
    private byte zzn = 2;
    private int zzf = 17;
    private zzbfp zzg = zzaj();
    private zzbfp zzm = zzaj();

    static {
        zzaiz zzaizVar = new zzaiz();
        zza = zzaizVar;
        zzbff.zzan(zzaiz.class, zzaizVar);
    }

    private zzaiz() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzn);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\b\u0000\u0001\u0001\u000f\b\u0000\u0002\u0004\u0001ဌ\u0000\u0003Л\u0004င\u0001\u0005ᐉ\u0002\u0006ᐉ\u0003\u0007င\u0005\b\u001b\u000fᐉ\u0004", new Object[]{"zzb", "zzf", zzaiy.zzc(), "zzg", zzapo.class, "zzh", "zzi", "zzj", "zzl", "zzm", zzaxd.class, "zzk"});
        }
        if (i2 == 3) {
            return new zzaiz();
        }
        zzaiu zzaiuVar = null;
        if (i2 == 4) {
            return new zzaiv(zzaiuVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzn = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
