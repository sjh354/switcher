package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzach extends zzbff implements zzbgt {
    private static final zzach zza;
    private int zzb;
    private double zzf;
    private double zzg;
    private int zzh;

    static {
        zzach zzachVar = new zzach();
        zza = zzachVar;
        zzbff.zzan(zzach.class, zzachVar);
    }

    private zzach() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001က\u0000\u0002က\u0001\u0003ဌ\u0002", new Object[]{"zzb", "zzf", "zzg", "zzh", zzacf.zzc()});
        }
        if (i2 == 3) {
            return new zzach();
        }
        zzabt zzabtVar = null;
        if (i2 == 4) {
            return new zzacg(zzabtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
