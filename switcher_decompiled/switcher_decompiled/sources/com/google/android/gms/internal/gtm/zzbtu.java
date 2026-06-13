package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbtu extends zzbff implements zzbgt {
    private static final zzbtu zza;
    private int zzb;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private int zzi;
    private zzbtt zzj;
    private int zzk;

    static {
        zzbtu zzbtuVar = new zzbtu();
        zza = zzbtuVar;
        zzbff.zzan(zzbtu.class, zzbtuVar);
    }

    private zzbtu() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဌ\u0003\u0003ဉ\u0004\u0004ဈ\u0001\u0005ဈ\u0002\u0006ဌ\u0005", new Object[]{"zzb", "zzf", "zzi", zzbtn.zzb(), "zzj", "zzg", "zzh", "zzk", zzbtq.zzb()});
        }
        if (i2 == 3) {
            return new zzbtu();
        }
        zzbte zzbteVar = null;
        if (i2 == 4) {
            return new zzbtr(zzbteVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
