package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzadr extends zzbff implements zzbgt {
    private static final zzadr zza;
    private int zzb;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    static {
        zzadr zzadrVar = new zzadr();
        zza = zzadrVar;
        zzbff.zzan(zzadr.class, zzadrVar);
    }

    private zzadr() {
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
            return new zzadr();
        }
        zzacm zzacmVar = null;
        if (i2 == 4) {
            return new zzadq(zzacmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
