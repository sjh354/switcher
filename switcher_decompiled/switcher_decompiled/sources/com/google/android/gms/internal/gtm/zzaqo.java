package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaqo extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzaqo zzb;
    private int zzf;
    private float zzi;
    private float zzj;
    private long zzk;
    private boolean zzl;
    private zzana zzm;
    private zzbmd zzn;
    private byte zzp = 2;
    private zzbfp zzg = zzaj();
    private zzbbw zzh = zzbbw.zzb;
    private String zzo = "";

    static {
        zzaqo zzaqoVar = new zzaqo();
        zzb = zzaqoVar;
        zzbff.zzan(zzaqo.class, zzaqoVar);
        zza = zzbff.zzac(zzbmd.zze(), zzaqoVar, zzaqoVar, null, 5464057, zzbip.MESSAGE, zzaqo.class);
    }

    private zzaqo() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzp);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\t\u0000\u0001\u0001Ǵ\t\u0000\u0001\u0002\u0001Л\u0002ခ\u0001\u0003ခ\u0002\u0004ဃ\u0003\u0005ည\u0000\u0006ဇ\u0004\u0007ဈ\u0007\u000fᐉ\u0006Ǵဉ\u0005", new Object[]{"zzf", "zzg", zzaqr.class, "zzi", "zzj", "zzk", "zzh", "zzl", "zzo", "zzn", "zzm"});
        }
        if (i2 == 3) {
            return new zzaqo();
        }
        zzaqm zzaqmVar = null;
        if (i2 == 4) {
            return new zzaqn(zzaqmVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzp = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
