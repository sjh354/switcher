package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzayj extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzayj zzb;
    private zzbfp zzf = zzaj();

    static {
        zzayj zzayjVar = new zzayj();
        zzb = zzayjVar;
        zzbff.zzan(zzayj.class, zzayjVar);
        zza = zzbff.zzac(zzbmd.zze(), zzayjVar, zzayjVar, null, 15256124, zzbip.MESSAGE, zzayj.class);
    }

    private zzayj() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzf", zzaxo.class});
        }
        if (i2 == 3) {
            return new zzayj();
        }
        zzaxj zzaxjVar = null;
        if (i2 == 4) {
            return new zzayi(zzaxjVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
