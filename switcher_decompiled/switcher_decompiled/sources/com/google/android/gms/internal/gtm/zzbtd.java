package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbtd extends zzbff implements zzbgt {
    private static final zzbtd zza;
    private int zzb;
    private int zzf = 0;
    private Object zzg;

    static {
        zzbtd zzbtdVar = new zzbtd();
        zza = zzbtdVar;
        zzbff.zzan(zzbtd.class, zzbtdVar);
    }

    private zzbtd() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ြ\u0000\u0002ြ\u0000\u0003ြ\u0000", new Object[]{"zzg", "zzf", "zzb", zzbsx.class, zzbsz.class, zzbtb.class});
        }
        if (i2 == 3) {
            return new zzbtd();
        }
        zzbsv zzbsvVar = null;
        if (i2 == 4) {
            return new zzbtc(zzbsvVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
