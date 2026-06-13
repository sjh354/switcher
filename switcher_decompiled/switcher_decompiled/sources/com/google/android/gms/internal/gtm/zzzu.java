package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzzu extends zzbff implements zzbgt {
    private static final zzzu zza;
    private zzbfp zzb = zzaj();

    static {
        zzzu zzzuVar = new zzzu();
        zza = zzzuVar;
        zzbff.zzan(zzzu.class, zzzuVar);
    }

    private zzzu() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zzaaa.class});
        }
        if (i2 == 3) {
            return new zzzu();
        }
        zzzd zzzdVar = null;
        if (i2 == 4) {
            return new zzzt(zzzdVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
