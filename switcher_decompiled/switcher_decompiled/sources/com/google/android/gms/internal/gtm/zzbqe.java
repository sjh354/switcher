package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbqe extends zzbff implements zzbgt {
    private static final zzbqe zza;
    private int zzb;
    private int zzf;
    private int zzg;

    static {
        zzbqe zzbqeVar = new zzbqe();
        zza = zzbqeVar;
        zzbff.zzan(zzbqe.class, zzbqeVar);
    }

    private zzbqe() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဌ\u0001", new Object[]{"zzb", "zzf", "zzg", zzbrf.zzb()});
        }
        if (i2 == 3) {
            return new zzbqe();
        }
        zzbqc zzbqcVar = null;
        if (i2 == 4) {
            return new zzbqd(zzbqcVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
