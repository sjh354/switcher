package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzabp extends zzbff implements zzbgt {
    private static final zzabp zza;
    private int zzb;
    private int zzf;
    private double zzg;
    private double zzh;
    private double zzi;
    private double zzj;
    private double zzk;
    private double zzl;

    static {
        zzabp zzabpVar = new zzabp();
        zza = zzabpVar;
        zzbff.zzan(zzabp.class, zzabpVar);
    }

    private zzabp() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001င\u0000\u0002က\u0001\u0003က\u0002\u0004က\u0003\u0005က\u0004\u0006က\u0005\u0007က\u0006", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i2 == 3) {
            return new zzabp();
        }
        zzabn zzabnVar = null;
        if (i2 == 4) {
            return new zzabo(zzabnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
