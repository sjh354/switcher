package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzagb extends zzbff implements zzbgt {
    private static final zzagb zza;
    private zzbfp zzb = zzaj();

    static {
        zzagb zzagbVar = new zzagb();
        zza = zzagbVar;
        zzbff.zzan(zzagb.class, zzagbVar);
    }

    private zzagb() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zzaga.class});
        }
        if (i2 == 3) {
            return new zzagb();
        }
        zzafx zzafxVar = null;
        if (i2 == 4) {
            return new zzafy(zzafxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
