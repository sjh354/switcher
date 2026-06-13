package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbvn extends zzbff implements zzbgt {
    private static final zzbvn zza;
    private int zzb;
    private boolean zzg;
    private zzbfp zzf = zzaj();
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";

    static {
        zzbvn zzbvnVar = new zzbvn();
        zza = zzbvnVar;
        zzbff.zzan(zzbvn.class, zzbvnVar);
    }

    private zzbvn() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u001b\u0002ဇ\u0000\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဈ\u0003\u0006ဈ\u0004\u0007ဈ\u0005\bဈ\u0006", new Object[]{"zzb", "zzf", zzbvl.class, "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zzbvn();
        }
        zzbte zzbteVar = null;
        if (i2 == 4) {
            return new zzbvm(zzbteVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
