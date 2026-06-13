package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzase extends zzbff implements zzbgt {
    private static final zzase zza;
    private int zzb;
    private zzamq zzg;
    private int zzh;
    private float zzk;
    private boolean zzm;
    private zzbmd zzn;
    private zzana zzo;
    private byte zzp = 2;
    private int zzf = 1;
    private String zzi = "";
    private String zzj = "";
    private zzbfp zzl = zzaj();

    static {
        zzase zzaseVar = new zzase();
        zza = zzaseVar;
        zzbff.zzan(zzase.class, zzaseVar);
    }

    private zzase() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzp);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\n\u0000\u0001\u0001Ǵ\n\u0000\u0001\u0004\u0001ဌ\u0000\u0002ᐉ\u0001\u0003ᔄ\u0002\u0004ဈ\u0003\u0005ခ\u0005\u0006Л\u0007ဇ\u0006\bဈ\u0004\u0010ᐉ\u0007Ǵဉ\b", new Object[]{"zzb", "zzf", zzasd.zzc(), "zzg", "zzh", "zzi", "zzk", "zzl", zzapo.class, "zzm", "zzj", "zzn", "zzo"});
        }
        if (i2 == 3) {
            return new zzase();
        }
        zzarz zzarzVar = null;
        if (i2 == 4) {
            return new zzasa(zzarzVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzp = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
