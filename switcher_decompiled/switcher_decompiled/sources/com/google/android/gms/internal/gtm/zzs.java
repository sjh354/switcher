package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzs extends zzbff implements zzbgt {
    private static final zzs zza;
    private int zzb;
    private int zzf = 1;
    private int zzg;
    private int zzh;

    static {
        zzs zzsVar = new zzs();
        zza = zzsVar;
        zzbff.zzan(zzs.class, zzsVar);
    }

    private zzs() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzb", "zzf", zzr.zzc(), "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzs();
        }
        zzn zznVar = null;
        if (i2 == 4) {
            return new zzo(zznVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
