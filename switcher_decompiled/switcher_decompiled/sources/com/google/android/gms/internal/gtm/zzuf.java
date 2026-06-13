package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzuf extends zzbff implements zzbgt {
    private static final zzuf zza;
    private String zzb = "";
    private zzbbw zzf = zzbbw.zzb;
    private int zzg;

    static {
        zzuf zzufVar = new zzuf();
        zza = zzufVar;
        zzbff.zzan(zzuf.class, zzufVar);
    }

    private zzuf() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzb", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzuf();
        }
        zzud zzudVar = null;
        if (i2 == 4) {
            return new zzue(zzudVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
