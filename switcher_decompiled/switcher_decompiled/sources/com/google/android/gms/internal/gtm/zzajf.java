package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzajf extends zzbff implements zzbgt {
    private static final zzajf zza;
    private int zzb;
    private zzbmd zzk;
    private byte zzl = 2;
    private zzbfl zzf = zzah();
    private zzbfk zzg = zzag();
    private boolean zzh = true;
    private String zzi = "";
    private String zzj = "";

    static {
        zzajf zzajfVar = new zzajf();
        zza = zzajfVar;
        zzbff.zzan(zzajf.class, zzajfVar);
    }

    private zzajf() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0006\u0000\u0001\u0001\u000f\u0006\u0000\u0002\u0001\u0001\u0016\u0002\u0013\u0003ဇ\u0000\u0004ဈ\u0001\u0005ဈ\u0002\u000fᐉ\u0003", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzajf();
        }
        zzajd zzajdVar = null;
        if (i2 == 4) {
            return new zzaje(zzajdVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
