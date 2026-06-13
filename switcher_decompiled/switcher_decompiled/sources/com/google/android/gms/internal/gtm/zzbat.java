package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbat extends zzbff implements zzbgt {
    private static final zzbat zza;
    private int zzb;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;

    static {
        zzbat zzbatVar = new zzbat();
        zza = zzbatVar;
        zzbff.zzan(zzbat.class, zzbatVar);
    }

    private zzbat() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007င\u0006\bဂ\u0007", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zzbat();
        }
        zzbar zzbarVar = null;
        if (i2 == 4) {
            return new zzbas(zzbarVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
