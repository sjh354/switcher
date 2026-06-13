package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbla extends zzbff implements zzbgt {
    private static final zzbla zza;
    private int zzb;
    private String zzf = "";
    private zzblq zzg;

    static {
        zzbla zzblaVar = new zzbla();
        zza = zzblaVar;
        zzbff.zzan(zzbla.class, zzblaVar);
    }

    private zzbla() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001", new Object[]{"zzb", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbla();
        }
        zzbku zzbkuVar = null;
        if (i2 == 4) {
            return new zzbkz(zzbkuVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
