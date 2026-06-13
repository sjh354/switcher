package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzakj extends zzbff implements zzbgt {
    private static final zzakj zza;
    private int zzb;
    private int zzf;
    private int zzg;
    private zzana zzh;
    private float zzi;
    private zzana zzj;
    private float zzk;
    private zzamq zzm;
    private byte zzn = 2;
    private zzbfp zzl = zzaj();

    static {
        zzakj zzakjVar = new zzakj();
        zza = zzakjVar;
        zzbff.zzan(zzakj.class, zzakjVar);
    }

    private zzakj() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzn);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\b\u0000\u0001\u0001ǵ\b\u0000\u0001\u0002\u0001ဌ\u0000\u0002င\u0001\u0003ခ\u0003\u0004ခ\u0005\u0006Л\u0007ᐉ\u0006Ǵဉ\u0002ǵဉ\u0004", new Object[]{"zzb", "zzf", zzaki.zzc(), "zzg", "zzi", "zzk", "zzl", zzamq.class, "zzm", "zzh", "zzj"});
        }
        if (i2 == 3) {
            return new zzakj();
        }
        zzake zzakeVar = null;
        if (i2 == 4) {
            return new zzakf(zzakeVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzn = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
