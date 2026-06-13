package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzti extends zzbff implements zzbgt {
    private static final zzti zza;
    private zzbfp zzb = zzaj();

    static {
        zzti zztiVar = new zzti();
        zza = zztiVar;
        zzbff.zzan(zzti.class, zztiVar);
    }

    private zzti() {
    }

    public static zzti zzc() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zzth.class});
        }
        if (i2 == 3) {
            return new zzti();
        }
        zzte zzteVar = null;
        if (i2 == 4) {
            return new zztf(zzteVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
