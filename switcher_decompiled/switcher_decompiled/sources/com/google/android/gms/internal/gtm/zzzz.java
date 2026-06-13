package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzzz extends zzbff implements zzbgt {
    private static final zzzz zza;
    private int zzb;
    private int zzf = 1;

    static {
        zzzz zzzzVar = new zzzz();
        zza = zzzzVar;
        zzbff.zzan(zzzz.class, zzzzVar);
    }

    private zzzz() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzb", "zzf", zzzy.zzc()});
        }
        if (i2 == 3) {
            return new zzzz();
        }
        zzzd zzzdVar = null;
        if (i2 == 4) {
            return new zzzv(zzzdVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
