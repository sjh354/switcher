package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzady extends zzbff implements zzbgt {
    private static final zzady zza;
    private int zzb;
    private String zzf = "";
    private String zzg = "";
    private zzadx zzh;
    private int zzi;

    static {
        zzady zzadyVar = new zzady();
        zza = zzadyVar;
        zzbff.zzan(zzady.class, zzadyVar);
    }

    private zzady() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0002\u0003ဌ\u0003\u0004ဈ\u0001", new Object[]{"zzb", "zzf", "zzh", "zzi", zzadv.zzc(), "zzg"});
        }
        if (i2 == 3) {
            return new zzady();
        }
        zzacm zzacmVar = null;
        if (i2 == 4) {
            return new zzads(zzacmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
