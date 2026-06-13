package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzblc extends zzbff implements zzbgt {
    private static final zzblc zza;
    private zzbfp zzb = zzaj();

    static {
        zzblc zzblcVar = new zzblc();
        zza = zzblcVar;
        zzbff.zzan(zzblc.class, zzblcVar);
    }

    private zzblc() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zzbla.class});
        }
        if (i2 == 3) {
            return new zzblc();
        }
        zzbku zzbkuVar = null;
        if (i2 == 4) {
            return new zzblb(zzbkuVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
