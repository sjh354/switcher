package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzzq extends zzbff implements zzbgt {
    private static final zzzq zza;
    private int zzb;
    private zzaaa zzh;
    private int zzf = 1;
    private int zzg = 1;
    private zzbfp zzi = zzaj();

    static {
        zzzq zzzqVar = new zzzq();
        zza = zzzqVar;
        zzbff.zzan(zzzq.class, zzzqVar);
    }

    private zzzq() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003\u001b\u0004ဉ\u0002", new Object[]{"zzb", "zzf", zzzp.zzc(), "zzg", zzzl.zzc(), "zzi", zzzz.class, "zzh"});
        }
        if (i2 == 3) {
            return new zzzq();
        }
        zzzd zzzdVar = null;
        if (i2 == 4) {
            return new zzzm(zzzdVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
