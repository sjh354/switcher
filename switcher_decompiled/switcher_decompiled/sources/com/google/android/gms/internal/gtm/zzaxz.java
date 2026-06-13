package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaxz extends zzbff implements zzbgt {
    private static final zzaxz zza;
    private int zzb;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm = 1;
    private int zzn;

    static {
        zzaxz zzaxzVar = new zzaxz();
        zza = zzaxzVar;
        zzbff.zzan(zzaxz.class, zzaxzVar);
    }

    private zzaxz() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005ဌ\u0004\u0006င\u0005\u0007ဌ\u0006\bဌ\u0007\tင\b", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", "zzj", zzaxs.zzc(), "zzk", "zzl", zzaxy.zzc(), "zzm", zzaxv.zzc(), "zzn"});
        }
        if (i2 == 3) {
            return new zzaxz();
        }
        zzaxj zzaxjVar = null;
        if (i2 == 4) {
            return new zzaxp(zzaxjVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
