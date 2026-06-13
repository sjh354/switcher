package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbwl extends zzbff implements zzbgt {
    private static final zzbwl zza;
    private int zzb;
    private int zzf;
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";
    private String zzn = "";
    private String zzo = "";

    static {
        zzbwl zzbwlVar = new zzbwl();
        zza = zzbwlVar;
        zzbff.zzan(zzbwl.class, zzbwlVar);
    }

    private zzbwl() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဈ\u0007\tဈ\b\nဈ\t", new Object[]{"zzb", "zzf", zzbwk.zzb(), "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo"});
        }
        if (i2 == 3) {
            return new zzbwl();
        }
        zzbte zzbteVar = null;
        if (i2 == 4) {
            return new zzbwh(zzbteVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
