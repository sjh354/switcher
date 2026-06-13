package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzazt extends zzbff implements zzbgt {
    private static final zzazt zza;
    private zzbfp zzb = zzaj();

    static {
        zzazt zzaztVar = new zzazt();
        zza = zzaztVar;
        zzbff.zzan(zzazt.class, zzaztVar);
    }

    private zzazt() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zzazw.class});
        }
        if (i2 == 3) {
            return new zzazt();
        }
        zzazr zzazrVar = null;
        if (i2 == 4) {
            return new zzazs(zzazrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
