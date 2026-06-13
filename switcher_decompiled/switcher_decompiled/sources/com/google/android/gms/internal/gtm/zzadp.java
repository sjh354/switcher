package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzadp extends zzbff implements zzbgt {
    private static final zzadp zza;
    private int zzb;
    private zzbem zzh;
    private String zzf = "";
    private zzbfp zzg = zzaj();
    private String zzi = "";

    static {
        zzadp zzadpVar = new zzadp();
        zza = zzadpVar;
        zzbff.zzan(zzadp.class, zzadpVar);
    }

    private zzadp() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဉ\u0001\u0004ဈ\u0002", new Object[]{"zzb", "zzf", "zzg", zzadr.class, "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzadp();
        }
        zzacm zzacmVar = null;
        if (i2 == 4) {
            return new zzado(zzacmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
