package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzxb extends zzbff implements zzbgt {
    private static final zzxb zza;
    private int zzb;
    private double zzf;
    private double zzg;

    static {
        zzxb zzxbVar = new zzxb();
        zza = zzxbVar;
        zzbff.zzan(zzxb.class, zzxbVar);
    }

    private zzxb() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001က\u0000\u0002က\u0001", new Object[]{"zzb", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzxb();
        }
        zzwy zzwyVar = null;
        if (i2 == 4) {
            return new zzxa(zzwyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
