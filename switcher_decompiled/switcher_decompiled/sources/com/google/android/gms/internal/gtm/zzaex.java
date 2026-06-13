package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaex extends zzbff implements zzbgt {
    private static final zzaex zza;
    private int zzb;
    private int zzf;
    private String zzg = "";
    private zzazk zzh;
    private int zzi;

    static {
        zzaex zzaexVar = new zzaex();
        zza = zzaexVar;
        zzbff.zzan(zzaex.class, zzaexVar);
    }

    private zzaex() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဌ\u0003\u0004ဉ\u0002", new Object[]{"zzb", "zzf", "zzg", "zzi", zzaeu.zzc(), "zzh"});
        }
        if (i2 == 3) {
            return new zzaex();
        }
        zzaev zzaevVar = null;
        if (i2 == 4) {
            return new zzaew(zzaevVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
