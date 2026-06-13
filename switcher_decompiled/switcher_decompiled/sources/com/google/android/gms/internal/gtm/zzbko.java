package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbko extends zzbff implements zzbgt {
    private static final zzbko zza;
    private int zzb;
    private boolean zzf;

    static {
        zzbko zzbkoVar = new zzbko();
        zza = zzbkoVar;
        zzbff.zzan(zzbko.class, zzbkoVar);
    }

    private zzbko() {
    }

    public static zzbko zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဇ\u0000", new Object[]{"zzb", "zzf"});
        }
        if (i2 == 3) {
            return new zzbko();
        }
        zzbkm zzbkmVar = null;
        if (i2 == 4) {
            return new zzbkn(zzbkmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
