package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzwx extends zzbff implements zzbgt {
    private static final zzwx zza;
    private int zzb;
    private int zzf;
    private int zzg;

    static {
        zzwx zzwxVar = new zzwx();
        zza = zzwxVar;
        zzbff.zzan(zzwx.class, zzwxVar);
    }

    private zzwx() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002င\u0001", new Object[]{"zzb", "zzf", zzbki.zzb(), "zzg"});
        }
        if (i2 == 3) {
            return new zzwx();
        }
        zzwv zzwvVar = null;
        if (i2 == 4) {
            return new zzww(zzwvVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
