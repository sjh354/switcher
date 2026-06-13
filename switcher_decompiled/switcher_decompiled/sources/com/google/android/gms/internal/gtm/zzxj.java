package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzxj extends zzbff implements zzbgt {
    private static final zzxj zza;
    private int zzb;
    private int zzf = 0;
    private Object zzg;
    private int zzh;

    static {
        zzxj zzxjVar = new zzxj();
        zza = zzxjVar;
        zzbff.zzan(zzxj.class, zzxjVar);
    }

    private zzxj() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ြ\u0000\u0003ြ\u0000", new Object[]{"zzg", "zzf", "zzb", "zzh", zzxi.zzc(), zzxc.class, zzxf.class});
        }
        if (i2 == 3) {
            return new zzxj();
        }
        zzwy zzwyVar = null;
        if (i2 == 4) {
            return new zzxd(zzwyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
