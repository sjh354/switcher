package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzayv extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzayv zzb;
    private int zzf;
    private int zzi;
    private zzana zzj;
    private byte zzk = 2;
    private String zzg = "";
    private String zzh = "";

    static {
        zzayv zzayvVar = new zzayv();
        zzb = zzayvVar;
        zzbff.zzan(zzayv.class, zzayvVar);
        zza = zzbff.zzac(zzbmd.zze(), zzayvVar, zzayvVar, null, 23880165, zzbip.MESSAGE, zzayv.class);
    }

    private zzayv() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0004\u0000\u0001\u0001Ǵ\u0004\u0000\u0000\u0001\u0001ᔈ\u0000\u0002ဈ\u0001\u0005င\u0002Ǵဉ\u0003", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzayv();
        }
        zzayt zzaytVar = null;
        if (i2 == 4) {
            return new zzayu(zzaytVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
