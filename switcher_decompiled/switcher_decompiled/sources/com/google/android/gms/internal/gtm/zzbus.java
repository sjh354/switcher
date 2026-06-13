package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbus extends zzbff implements zzbgt {
    private static final zzbus zza;
    private int zzb;
    private String zzf = "";
    private int zzg;

    static {
        zzbus zzbusVar = new zzbus();
        zza = zzbusVar;
        zzbff.zzan(zzbus.class, zzbusVar);
    }

    private zzbus() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဌ\u0001", new Object[]{"zzb", "zzf", "zzg", zzbur.zzb()});
        }
        if (i2 == 3) {
            return new zzbus();
        }
        zzbte zzbteVar = null;
        if (i2 == 4) {
            return new zzbuo(zzbteVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
