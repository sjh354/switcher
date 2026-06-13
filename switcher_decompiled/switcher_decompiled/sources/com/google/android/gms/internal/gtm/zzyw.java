package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzyw extends zzbff implements zzbgt {
    private static final zzyw zza;
    private int zzb;
    private zzyr zzh;
    private int zzi;
    private zzyo zzj;
    private zzyj zzk;
    private byte zzl = 2;
    private zzbbw zzf = zzbbw.zzb;
    private zzbbw zzg = zzbbw.zzb;

    static {
        zzyw zzywVar = new zzyw();
        zza = zzywVar;
        zzbff.zzan(zzyw.class, zzywVar);
    }

    private zzyw() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001ည\u0000\u0002ဉ\u0002\u0003ဌ\u0003\u0004ᐉ\u0004\u0005ည\u0001\u0006ဉ\u0005", new Object[]{"zzb", "zzf", "zzh", "zzi", zzyv.zzc(), "zzj", "zzg", "zzk"});
        }
        if (i2 == 3) {
            return new zzyw();
        }
        zzyp zzypVar = null;
        if (i2 == 4) {
            return new zzys(zzypVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
