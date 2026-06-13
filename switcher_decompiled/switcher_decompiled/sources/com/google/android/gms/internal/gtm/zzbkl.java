package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbkl extends zzbff implements zzbgt {
    private static final zzbkl zza;
    private zzbfp zzb = zzbff.zzaj();
    private int zzf;

    static {
        zzbkl zzbklVar = new zzbkl();
        zza = zzbklVar;
        zzbff.zzan(zzbkl.class, zzbklVar);
    }

    private zzbkl() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ț\u0002\f", new Object[]{"zzb", "zzf"});
        }
        if (i2 == 3) {
            return new zzbkl();
        }
        zzbkj zzbkjVar = null;
        if (i2 == 4) {
            return new zzbkk(zzbkjVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
