package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbvz extends zzbff implements zzbgt {
    private static final zzbvz zza;
    private int zzb;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";

    static {
        zzbvz zzbvzVar = new zzbvz();
        zza = zzbvzVar;
        zzbff.zzan(zzbvz.class, zzbvzVar);
    }

    private zzbvz() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0007\u0000\u0001\u0001\b\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0001\bဈ\u0006", new Object[]{"zzb", "zzf", "zzh", "zzi", "zzj", "zzk", "zzg", "zzl"});
        }
        if (i2 == 3) {
            return new zzbvz();
        }
        zzbte zzbteVar = null;
        if (i2 == 4) {
            return new zzbvy(zzbteVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
