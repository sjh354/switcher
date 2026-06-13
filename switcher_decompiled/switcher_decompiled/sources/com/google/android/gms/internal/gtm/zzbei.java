package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbei extends zzbff implements zzbgt {
    private static final zzbei zza;
    private int zzb;
    private long zzh;
    private long zzi;
    private double zzj;
    private byte zzm = 2;
    private zzbfp zzf = zzbhc.zze();
    private String zzg = "";
    private zzbbw zzk = zzbbw.zzb;
    private String zzl = "";

    static {
        zzbei zzbeiVar = new zzbei();
        zza = zzbeiVar;
        zzbff.zzan(zzbei.class, zzbeiVar);
    }

    private zzbei() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i2 == 2) {
            return new zzbhd(zza, "\u0001\u0007\u0000\u0001\u0002\b\u0007\u0000\u0001\u0001\u0002Л\u0003ဈ\u0000\u0004ဃ\u0001\u0005ဂ\u0002\u0006က\u0003\u0007ည\u0004\bဈ\u0005", new Object[]{"zzb", "zzf", zzbeh.class, "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i2 == 3) {
            return new zzbei();
        }
        zzbcl zzbclVar = null;
        if (i2 == 4) {
            return new zzbef(zzbclVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
