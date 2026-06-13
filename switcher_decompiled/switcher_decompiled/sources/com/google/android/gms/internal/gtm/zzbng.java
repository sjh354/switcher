package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbng extends zzbff implements zzbgt {
    private static final zzbng zza;
    private int zzb;
    private int zzf;
    private zzbnb zzg;
    private zzbmq zzh;
    private zzbmu zzi;
    private zzbmz zzj;
    private zzbms zzk;

    static {
        zzbng zzbngVar = new zzbng();
        zza = zzbngVar;
        zzbff.zzan(zzbng.class, zzbngVar);
    }

    private zzbng() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005", new Object[]{"zzb", "zzf", zzbne.zzb(), "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzbng();
        }
        zzbmo zzbmoVar = null;
        if (i2 == 4) {
            return new zzbnf(zzbmoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
