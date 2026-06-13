package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzuq extends zzbff implements zzbgt {
    private static final zzuq zza;
    private int zzb;
    private int zzf = 0;
    private Object zzg;

    static {
        zzuq zzuqVar = new zzuq();
        zza = zzuqVar;
        zzbff.zzan(zzuq.class, zzuqVar);
    }

    private zzuq() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0001\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001်\u0000\u0002ျ\u0000", new Object[]{"zzg", "zzf", "zzb"});
        }
        if (i2 == 3) {
            return new zzuq();
        }
        zzug zzugVar = null;
        if (i2 == 4) {
            return new zzup(zzugVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
