package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzarg extends zzbff implements zzbgt {
    private static final zzarg zza;
    private int zzb;
    private zzbfp zzf = zzaj();
    private int zzg;

    static {
        zzarg zzargVar = new zzarg();
        zza = zzargVar;
        zzbff.zzan(zzarg.class, zzargVar);
    }

    private zzarg() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\r\u0010\u0002\u0000\u0001\u0000\r\u001b\u0010ဌ\u0000", new Object[]{"zzb", "zzf", zzarm.class, "zzg", zzarf.zzc()});
        }
        if (i2 == 3) {
            return new zzarg();
        }
        zzarb zzarbVar = null;
        if (i2 == 4) {
            return new zzarc(zzarbVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
