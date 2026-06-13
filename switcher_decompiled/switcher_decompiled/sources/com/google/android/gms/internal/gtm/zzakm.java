package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzakm extends zzbff implements zzbgt {
    private static final zzakm zza;
    private zzbfo zzb = zzai();

    static {
        zzakm zzakmVar = new zzakm();
        zza = zzakmVar;
        zzbff.zzan(zzakm.class, zzakmVar);
    }

    private zzakm() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0015", new Object[]{"zzb"});
        }
        if (i2 == 3) {
            return new zzakm();
        }
        zzakk zzakkVar = null;
        if (i2 == 4) {
            return new zzakl(zzakkVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
