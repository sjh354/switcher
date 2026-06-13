package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzyi extends zzbff implements zzbgt {
    private static final zzyi zza;
    private int zzb;
    private zzbfp zzf = zzaj();
    private zzyl zzg;

    static {
        zzyi zzyiVar = new zzyi();
        zza = zzyiVar;
        zzbff.zzan(zzyi.class, zzyiVar);
    }

    private zzyi() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzb", "zzf", zzagb.class, "zzg"});
        }
        if (i2 == 3) {
            return new zzyi();
        }
        zzyf zzyfVar = null;
        if (i2 == 4) {
            return new zzyh(zzyfVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
