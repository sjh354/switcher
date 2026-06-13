package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzadx extends zzbff implements zzbgt {
    private static final zzadx zza;
    private int zzb;
    private int zzf;
    private int zzg;

    static {
        zzadx zzadxVar = new zzadx();
        zza = zzadxVar;
        zzbff.zzan(zzadx.class, zzadxVar);
    }

    private zzadx() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzb", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzadx();
        }
        zzacm zzacmVar = null;
        if (i2 == 4) {
            return new zzadw(zzacmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
