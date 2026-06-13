package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaqr extends zzbff implements zzbgt {
    private static final zzaqr zza;
    private int zzb;
    private zzana zzg;
    private zzbmd zzh;
    private byte zzi = 2;
    private zzbfp zzf = zzaj();

    static {
        zzaqr zzaqrVar = new zzaqr();
        zza = zzaqrVar;
        zzbff.zzan(zzaqr.class, zzaqrVar);
    }

    private zzaqr() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0001Ǵ\u0003\u0000\u0001\u0002\u0001Л\u000fᐉ\u0001Ǵဉ\u0000", new Object[]{"zzb", "zzf", zzaqi.class, "zzh", "zzg"});
        }
        if (i2 == 3) {
            return new zzaqr();
        }
        zzaqp zzaqpVar = null;
        if (i2 == 4) {
            return new zzaqq(zzaqpVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
