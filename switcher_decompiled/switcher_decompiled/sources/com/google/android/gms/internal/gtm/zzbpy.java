package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbpy extends zzbff implements zzbgt {
    private static final zzbpy zza;
    private int zzb;
    private int zzf;
    private int zzg;
    private zzbrh zzh;

    static {
        zzbpy zzbpyVar = new zzbpy();
        zza = zzbpyVar;
        zzbff.zzan(zzbpy.class, zzbpyVar);
    }

    private zzbpy() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003ဉ\u0002", new Object[]{"zzb", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzbpy();
        }
        zzbpw zzbpwVar = null;
        if (i2 == 4) {
            return new zzbpx(zzbpwVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
