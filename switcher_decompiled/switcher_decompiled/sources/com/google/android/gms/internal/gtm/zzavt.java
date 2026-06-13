package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzavt extends zzbff implements zzbgt {
    private static final zzavt zza;
    private int zzb;
    private int zzf = 2;

    static {
        zzavt zzavtVar = new zzavt();
        zza = zzavtVar;
        zzbff.zzan(zzavt.class, zzavtVar);
    }

    private zzavt() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzb", "zzf", zzavs.zzc()});
        }
        if (i2 == 3) {
            return new zzavt();
        }
        zzavo zzavoVar = null;
        if (i2 == 4) {
            return new zzavp(zzavoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
