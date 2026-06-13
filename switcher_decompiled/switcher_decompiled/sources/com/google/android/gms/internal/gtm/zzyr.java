package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzyr extends zzbff implements zzbgt {
    private static final zzyr zza;
    private int zzb;
    private long zzf;
    private long zzg;
    private long zzh;

    static {
        zzyr zzyrVar = new zzyr();
        zza = zzyrVar;
        zzbff.zzan(zzyr.class, zzyrVar);
    }

    private zzyr() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002", new Object[]{"zzb", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzyr();
        }
        zzyp zzypVar = null;
        if (i2 == 4) {
            return new zzyq(zzypVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
