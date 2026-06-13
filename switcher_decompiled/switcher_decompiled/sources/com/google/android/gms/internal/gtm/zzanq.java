package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzanq extends zzbff implements zzbgt {
    private static final zzanq zza;
    private int zzb;
    private int zzf = 4369;
    private String zzg = "";

    static {
        zzanq zzanqVar = new zzanq();
        zza = zzanqVar;
        zzbff.zzan(zzanq.class, zzanqVar);
    }

    private zzanq() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001", new Object[]{"zzb", "zzf", zzaks.zzc(), "zzg"});
        }
        if (i2 == 3) {
            return new zzanq();
        }
        zzano zzanoVar = null;
        if (i2 == 4) {
            return new zzanp(zzanoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
