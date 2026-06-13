package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbkx extends zzbff implements zzbgt {
    private static final zzbkx zza;
    private int zzb;
    private String zzf = "";
    private zzbfp zzg = zzaj();

    static {
        zzbkx zzbkxVar = new zzbkx();
        zza = zzbkxVar;
        zzbff.zzan(zzbkx.class, zzbkxVar);
    }

    private zzbkx() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzb", "zzf", "zzg", zzblq.class});
        }
        if (i2 == 3) {
            return new zzbkx();
        }
        zzbku zzbkuVar = null;
        if (i2 == 4) {
            return new zzbkw(zzbkuVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
