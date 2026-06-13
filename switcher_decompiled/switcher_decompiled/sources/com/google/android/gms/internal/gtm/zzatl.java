package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzatl extends zzbff implements zzbgt {
    private static final zzatl zza;
    private int zzb;
    private int zzf;

    static {
        zzatl zzatlVar = new zzatl();
        zza = zzatlVar;
        zzbff.zzan(zzatl.class, zzatlVar);
    }

    private zzatl() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzb", "zzf", zzatk.zzc()});
        }
        if (i2 == 3) {
            return new zzatl();
        }
        zzatg zzatgVar = null;
        if (i2 == 4) {
            return new zzath(zzatgVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
