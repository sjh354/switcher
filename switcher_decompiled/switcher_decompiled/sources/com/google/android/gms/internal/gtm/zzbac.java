package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbac extends zzbff implements zzbgt {
    private static final zzbac zza;
    private int zzb;
    private String zzf = "";
    private int zzg;
    private zzana zzh;

    static {
        zzbac zzbacVar = new zzbac();
        zza = zzbacVar;
        zzbff.zzan(zzbac.class, zzbacVar);
    }

    private zzbac() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0001Ǵ\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဌ\u0001Ǵဉ\u0002", new Object[]{"zzb", "zzf", "zzg", zzbab.zzc(), "zzh"});
        }
        if (i2 == 3) {
            return new zzbac();
        }
        zzazx zzazxVar = null;
        if (i2 == 4) {
            return new zzazy(zzazxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
