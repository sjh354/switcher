package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbny extends zzbff implements zzbgt {
    private static final zzbny zza;
    private int zzb;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    static {
        zzbny zzbnyVar = new zzbny();
        zza = zzbnyVar;
        zzbff.zzan(zzbny.class, zzbnyVar);
    }

    private zzbny() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zzb", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzbny();
        }
        zzbnw zzbnwVar = null;
        if (i2 == 4) {
            return new zzbnx(zzbnwVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
