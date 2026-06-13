package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbhx extends zzbff implements zzbgt {
    private static final zzbhx zza;
    private long zzb;
    private int zzf;

    static {
        zzbhx zzbhxVar = new zzbhx();
        zza = zzbhxVar;
        zzbff.zzan(zzbhx.class, zzbhxVar);
    }

    private zzbhx() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzbhd(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzb", "zzf"});
        }
        if (i2 == 3) {
            return new zzbhx();
        }
        zzbhv zzbhvVar = null;
        if (i2 == 4) {
            return new zzbhw(zzbhvVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
