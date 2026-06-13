package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzalh extends zzbff implements zzbgt {
    private static final zzalh zza;
    private int zzb;
    private double zzf;
    private zzapz zzg;

    static {
        zzalh zzalhVar = new zzalh();
        zza = zzalhVar;
        zzbff.zzan(zzalh.class, zzalhVar);
    }

    private zzalh() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0000\u0001က\u0000\u0003ဉ\u0001", new Object[]{"zzb", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzalh();
        }
        zzalf zzalfVar = null;
        if (i2 == 4) {
            return new zzalg(zzalfVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
