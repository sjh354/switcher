package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzalq extends zzbff implements zzbgt {
    private static final zzalq zza;
    private int zzb;
    private int zzf;
    private boolean zzg;
    private boolean zzh;

    static {
        zzalq zzalqVar = new zzalq();
        zza = zzalqVar;
        zzbff.zzan(zzalq.class, zzalqVar);
    }

    private zzalq() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0002\u0004\u0003\u0000\u0000\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဌ\u0000", new Object[]{"zzb", "zzg", "zzh", "zzf", zzalp.zzc()});
        }
        if (i2 == 3) {
            return new zzalq();
        }
        zzall zzallVar = null;
        if (i2 == 4) {
            return new zzalm(zzallVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
