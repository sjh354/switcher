package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbnb extends zzbff implements zzbgt {
    private static final zzbnb zza;
    private int zzb;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzbnb zzbnbVar = new zzbnb();
        zza = zzbnbVar;
        zzbff.zzan(zzbnb.class, zzbnbVar);
    }

    private zzbnb() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဋ\u0001\u0003ဋ\u0002", new Object[]{"zzb", "zzf", zzbqw.zzb(), "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzbnb();
        }
        zzbmo zzbmoVar = null;
        if (i2 == 4) {
            return new zzbna(zzbmoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
