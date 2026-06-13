package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbpm extends zzbff implements zzbgt {
    private static final zzbpm zza;
    private int zzb;
    private int zzf = 1;

    static {
        zzbpm zzbpmVar = new zzbpm();
        zza = zzbpmVar;
        zzbff.zzan(zzbpm.class, zzbpmVar);
    }

    private zzbpm() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzb", "zzf", zzbqt.zzb()});
        }
        if (i2 == 3) {
            return new zzbpm();
        }
        zzbpk zzbpkVar = null;
        if (i2 == 4) {
            return new zzbpl(zzbpkVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
