package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbap extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzbap zzb;
    private int zzf;
    private String zzg = "";
    private String zzh = "";

    static {
        zzbap zzbapVar = new zzbap();
        zzb = zzbapVar;
        zzbff.zzan(zzbap.class, zzbapVar);
        zza = zzbff.zzac(zzban.zzc(), zzbapVar, zzbapVar, null, 10000, zzbip.MESSAGE, zzbap.class);
    }

    private zzbap() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzbap();
        }
        zzbaj zzbajVar = null;
        if (i2 == 4) {
            return new zzbao(zzbajVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
