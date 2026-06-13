package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbsu extends zzbff implements zzbgt {
    private static final zzbsu zza;
    private int zzb;
    private zzbfp zzf = zzaj();
    private zzbfp zzg = zzaj();
    private zzbhx zzh;
    private zzbhx zzi;
    private int zzj;

    static {
        zzbsu zzbsuVar = new zzbsu();
        zza = zzbsuVar;
        zzbff.zzan(zzbsu.class, zzbsuVar);
    }

    private zzbsu() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0005\u0000\u0001\u0001\u0007\u0005\u0000\u0002\u0000\u0001\u001b\u0004\u001b\u0005ဉ\u0000\u0006ဉ\u0001\u0007ဌ\u0002", new Object[]{"zzb", "zzf", zzbkl.class, "zzg", zzbkl.class, "zzh", "zzi", "zzj", zzbst.zzb()});
        }
        if (i2 == 3) {
            return new zzbsu();
        }
        zzbsp zzbspVar = null;
        if (i2 == 4) {
            return new zzbsq(zzbspVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
