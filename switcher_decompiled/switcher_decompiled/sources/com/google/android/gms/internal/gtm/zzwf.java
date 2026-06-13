package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzwf extends zzbff implements zzbgt {
    private static final zzwf zza;
    private int zzb;
    private String zzf = "";

    static {
        zzwf zzwfVar = new zzwf();
        zza = zzwfVar;
        zzbff.zzan(zzwf.class, zzwfVar);
    }

    private zzwf() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzb", "zzf"});
        }
        if (i2 == 3) {
            return new zzwf();
        }
        zzwd zzwdVar = null;
        if (i2 == 4) {
            return new zzwe(zzwdVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
