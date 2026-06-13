package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbox extends zzbff implements zzbgt {
    private static final zzbox zza;
    private int zzb;
    private int zzf;

    static {
        zzbox zzboxVar = new zzbox();
        zza = zzboxVar;
        zzbff.zzan(zzbox.class, zzboxVar);
    }

    private zzbox() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzb", "zzf"});
        }
        if (i2 == 3) {
            return new zzbox();
        }
        zzbov zzbovVar = null;
        if (i2 == 4) {
            return new zzbow(zzbovVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
