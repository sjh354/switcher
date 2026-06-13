package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzafq extends zzbff implements zzbgt {
    private static final zzafq zza;
    private int zzb;
    private Object zzg;
    private int zzh;
    private int zzf = 0;
    private zzbfp zzi = zzaj();

    static {
        zzafq zzafqVar = new zzafq();
        zza = zzafqVar;
        zzbff.zzan(zzafq.class, zzafqVar);
    }

    private zzafq() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0005\u0001\u0001\u0003\u0007\u0005\u0000\u0001\u0000\u0003ဌ\u0000\u0004\u001b\u0005ြ\u0000\u0006ြ\u0000\u0007ြ\u0000", new Object[]{"zzg", "zzf", "zzb", "zzh", zzafp.zzc(), "zzi", zzafa.class, zzafw.class, zzahj.class, zzahg.class});
        }
        if (i2 == 3) {
            return new zzafq();
        }
        zzafl zzaflVar = null;
        if (i2 == 4) {
            return new zzafm(zzaflVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
