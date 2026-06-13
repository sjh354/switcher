package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzayh extends zzbff implements zzbgt {
    private static final zzayh zza;
    private int zzb;
    private boolean zzg;
    private zzaxz zzi;
    private zzaxz zzj;
    private int zzf = 1;
    private int zzh = 1;

    static {
        zzayh zzayhVar = new zzayh();
        zza = zzayhVar;
        zzbff.zzan(zzayh.class, zzayhVar);
    }

    private zzayh() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0005\u0000\u0001\u0001\u0007\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဌ\u0002\u0006ဉ\u0003\u0007ဉ\u0004", new Object[]{"zzb", "zzf", zzayd.zzc(), "zzg", "zzh", zzayg.zzc(), "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzayh();
        }
        zzaxj zzaxjVar = null;
        if (i2 == 4) {
            return new zzaya(zzaxjVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
