package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zztw extends zzbff implements zzbgt {
    private static final zztw zza;
    private int zzb;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    static {
        zztw zztwVar = new zztw();
        zza = zztwVar;
        zzbff.zzan(zztw.class, zztwVar);
    }

    private zztw() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဌ\u0004\u0006ဌ\u0005\u0007ဌ\u0006", new Object[]{"zzb", "zzf", zztv.zzc(), "zzg", zztv.zzc(), "zzh", zztv.zzc(), "zzi", zztv.zzc(), "zzj", zztv.zzc(), "zzk", zztv.zzc(), "zzl", zztv.zzc()});
        }
        if (i2 == 3) {
            return new zztw();
        }
        zztr zztrVar = null;
        if (i2 == 4) {
            return new zzts(zztrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
