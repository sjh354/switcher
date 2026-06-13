package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbom extends zzbff implements zzbgt {
    private static final zzbom zza;
    private int zzb;
    private long zzf;
    private int zzg;

    static {
        zzbom zzbomVar = new zzbom();
        zza = zzbomVar;
        zzbff.zzan(zzbom.class, zzbomVar);
    }

    private zzbom() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဌ\u0001", new Object[]{"zzb", "zzf", "zzg", zzbol.zzb()});
        }
        if (i2 == 3) {
            return new zzbom();
        }
        zzboh zzbohVar = null;
        if (i2 == 4) {
            return new zzboi(zzbohVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
