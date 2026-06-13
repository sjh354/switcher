package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbqn extends zzbff implements zzbgt {
    private static final zzbqn zza;
    private int zzb;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;

    static {
        zzbqn zzbqnVar = new zzbqn();
        zza = zzbqnVar;
        zzbff.zzan(zzbqn.class, zzbqnVar);
    }

    private zzbqn() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဌ\u0004\u0006င\u0005\u0007ဌ\u0006\bင\u0007\tင\b", new Object[]{"zzb", "zzf", zzbqq.zzb(), "zzg", zzbrf.zzb(), "zzh", zzbqz.zzb(), "zzi", zzbqm.zzb(), "zzj", zzbrf.zzb(), "zzk", "zzl", zzbqw.zzb(), "zzm", "zzn"});
        }
        if (i2 == 3) {
            return new zzbqn();
        }
        zzbqi zzbqiVar = null;
        if (i2 == 4) {
            return new zzbqj(zzbqiVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
