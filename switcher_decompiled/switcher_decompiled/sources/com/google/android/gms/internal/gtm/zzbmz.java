package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbmz extends zzbff implements zzbgt {
    private static final zzbmz zza;
    private int zzb;
    private int zzg;
    private int zzi;
    private zzbng zzj;
    private int zzk;
    private int zzf = 1;
    private zzbbw zzh = zzbbw.zzb;

    static {
        zzbmz zzbmzVar = new zzbmz();
        zza = zzbmzVar;
        zzbff.zzan(zzbmz.class, zzbmzVar);
    }

    private zzbmz() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ည\u0002\u0004ဌ\u0003\u0005ဉ\u0004\u0006ဌ\u0005", new Object[]{"zzb", "zzf", zzbqt.zzb(), "zzg", zzbqw.zzb(), "zzh", "zzi", zzbrf.zzb(), "zzj", "zzk", zzbqq.zzb()});
        }
        if (i2 == 3) {
            return new zzbmz();
        }
        zzbmo zzbmoVar = null;
        if (i2 == 4) {
            return new zzbmy(zzbmoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
