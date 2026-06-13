package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbbe extends zzbff implements zzbgt {
    private static final zzbbe zza;
    private String zzb = "";
    private zzbbw zzf = zzbbw.zzb;

    static {
        zzbbe zzbbeVar = new zzbbe();
        zza = zzbbeVar;
        zzbff.zzan(zzbbe.class, zzbbeVar);
    }

    private zzbbe() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzbhd(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\n", new Object[]{"zzb", "zzf"});
        }
        if (i2 == 3) {
            return new zzbbe();
        }
        zzbbc zzbbcVar = null;
        if (i2 == 4) {
            return new zzbbd(zzbbcVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
