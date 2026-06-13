package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzux extends zzbff implements zzbgt {
    private static final zzux zza;
    private int zzb;
    private Object zzg;
    private int zzf = 0;
    private int zzh = 3;

    static {
        zzux zzuxVar = new zzux();
        zza = zzuxVar;
        zzbff.zzan(zzux.class, zzuxVar);
    }

    private zzux() {
    }

    public static zzux zzc() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001်\u0000\u0002်\u0000\u0003ဿ\u0000\u0004ျ\u0000\u0005ျ\u0000\u0006ြ\u0000\u0007ဌ\u0006", new Object[]{"zzg", "zzf", "zzb", zzvc.zzc(), zzuz.class, "zzh", zzuv.zzc()});
        }
        if (i2 == 3) {
            return new zzux();
        }
        zzus zzusVar = null;
        if (i2 == 4) {
            return new zzuw(zzusVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
