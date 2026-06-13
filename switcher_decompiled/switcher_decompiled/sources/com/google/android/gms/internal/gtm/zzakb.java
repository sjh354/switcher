package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzakb extends zzbff implements zzbgt {
    private static final zzakb zza;
    private int zzb;
    private int zzf;
    private zzamq zzh;
    private zzamq zzi;
    private byte zzl = 2;
    private int zzg = 1;
    private zzbfp zzj = zzaj();
    private zzbfp zzk = zzaj();

    static {
        zzakb zzakbVar = new zzakb();
        zza = zzakbVar;
        zzbff.zzan(zzakb.class, zzakbVar);
    }

    private zzakb() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0004\u0001ᔄ\u0000\u0002ဌ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005\u001b\u0006Л", new Object[]{"zzb", "zzf", "zzg", zzajz.zzc(), "zzh", "zzi", "zzj", zzakd.class, "zzk", zzamq.class});
        }
        if (i2 == 3) {
            return new zzakb();
        }
        zzajw zzajwVar = null;
        if (i2 == 4) {
            return new zzaka(zzajwVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
