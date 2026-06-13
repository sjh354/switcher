package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbpp extends zzbff implements zzbgt {
    private static final zzbpp zza;
    private int zzb;
    private int zzf = 1;
    private zzbqn zzg;

    static {
        zzbpp zzbppVar = new zzbpp();
        zza = zzbppVar;
        zzbff.zzan(zzbpp.class, zzbppVar);
    }

    private zzbpp() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001", new Object[]{"zzb", "zzf", zzbqt.zzb(), "zzg"});
        }
        if (i2 == 3) {
            return new zzbpp();
        }
        zzbpn zzbpnVar = null;
        if (i2 == 4) {
            return new zzbpo(zzbpnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
