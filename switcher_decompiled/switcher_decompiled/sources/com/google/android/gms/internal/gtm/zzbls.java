package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbls extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzbls zzb;
    private zzbfp zzf = zzaj();

    static {
        zzbls zzblsVar = new zzbls();
        zzb = zzblsVar;
        zzbff.zzan(zzbls.class, zzblsVar);
        zza = zzbff.zzac(zzbmd.zze(), zzblsVar, zzblsVar, null, 75852568, zzbip.MESSAGE, zzbls.class);
    }

    private zzbls() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzf", zzblm.class});
        }
        if (i2 == 3) {
            return new zzbls();
        }
        zzbku zzbkuVar = null;
        if (i2 == 4) {
            return new zzblr(zzbkuVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
