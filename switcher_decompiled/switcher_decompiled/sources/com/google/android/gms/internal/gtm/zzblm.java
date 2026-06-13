package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzblm extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzblm zzb;
    private int zzf;
    private zzblq zzi;
    private boolean zzj;
    private String zzg = "";
    private String zzh = "";
    private zzbfp zzk = zzaj();
    private zzbfp zzl = zzaj();

    static {
        zzblm zzblmVar = new zzblm();
        zzb = zzblmVar;
        zzbff.zzan(zzblm.class, zzblmVar);
        zza = zzbff.zzac(zzbmd.zze(), zzblmVar, zzblmVar, null, 75852567, zzbip.MESSAGE, zzblm.class);
    }

    private zzblm() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0006\u0000\u0001\u0001\u0014\u0006\u0000\u0002\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0010\u001b\u0011ဉ\u0002\u0013ဇ\u0003\u0014\u001b", new Object[]{"zzf", "zzg", "zzh", "zzk", zzble.class, "zzi", "zzj", "zzl", zzblc.class});
        }
        if (i2 == 3) {
            return new zzblm();
        }
        zzbku zzbkuVar = null;
        if (i2 == 4) {
            return new zzbld(zzbkuVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
