package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzzs extends zzbff implements zzbgt {
    private static final zzzs zza;
    private int zzb;
    private zzzu zzf;
    private zzzq zzg;
    private zzze zzh;

    static {
        zzzs zzzsVar = new zzzs();
        zza = zzzsVar;
        zzbff.zzan(zzzs.class, zzzsVar);
    }

    private zzzs() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzb", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzzs();
        }
        zzzd zzzdVar = null;
        if (i2 == 4) {
            return new zzzr(zzzdVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
