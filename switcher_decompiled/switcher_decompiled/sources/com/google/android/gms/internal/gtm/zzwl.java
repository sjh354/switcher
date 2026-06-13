package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzwl extends zzbff implements zzbgt {
    private static final zzwl zza;
    private int zzb;
    private zzafq zzf;
    private int zzg;

    static {
        zzwl zzwlVar = new zzwl();
        zza = zzwlVar;
        zzbff.zzan(zzwl.class, zzwlVar);
    }

    private zzwl() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001", new Object[]{"zzb", "zzf", "zzg", zzwk.zzc()});
        }
        if (i2 == 3) {
            return new zzwl();
        }
        zzwg zzwgVar = null;
        if (i2 == 4) {
            return new zzwh(zzwgVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
