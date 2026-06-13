package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbaw extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzbaw zzb;
    private int zzf;
    private int zzg;
    private String zzh = "";
    private String zzi = "";
    private zzbfp zzj = zzbff.zzaj();
    private String zzk = "";

    static {
        zzbaw zzbawVar = new zzbaw();
        zzb = zzbawVar;
        zzbff.zzan(zzbaw.class, zzbawVar);
        zza = zzbff.zzac(zzbmd.zze(), zzbawVar, zzbawVar, null, 3546500, zzbip.MESSAGE, zzbaw.class);
    }

    private zzbaw() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004\u001a\u0005ဈ\u0003", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzbaw();
        }
        zzbau zzbauVar = null;
        if (i2 == 4) {
            return new zzbav(zzbauVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
