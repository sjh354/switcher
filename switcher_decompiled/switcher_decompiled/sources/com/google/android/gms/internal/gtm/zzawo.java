package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzawo extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzawo zzb;
    private int zzf;
    private zzamq zzg;
    private long zzn;
    private long zzo;
    private zzazb zzp;
    private zzazb zzq;
    private zzaky zzr;
    private zzbmd zzt;
    private byte zzu = 2;
    private zzbfp zzh = zzaj();
    private String zzi = "";
    private int zzj = 4369;
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";
    private zzbfp zzs = zzaj();

    static {
        zzawo zzawoVar = new zzawo();
        zzb = zzawoVar;
        zzbff.zzan(zzawo.class, zzawoVar);
        zza = zzbff.zzac(zzbmd.zze(), zzawoVar, zzawoVar, null, 18502900, zzbip.MESSAGE, zzawo.class);
    }

    private zzawo() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzu);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u000e\u0000\u0001\u0001\u000f\u000e\u0000\u0002\u0005\u0001ᐉ\u0000\u0002Л\u0003ဈ\u0001\u0004င\u0002\u0005ဈ\u0003\u0006ဈ\u0004\u0007ဈ\u0005\bဂ\u0006\tဂ\u0007\nᐉ\n\u000bᐉ\u000b\fЛ\u000eဉ\b\u000fဉ\t", new Object[]{"zzf", "zzg", "zzh", zzarp.class, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzr", "zzt", "zzs", zzayv.class, "zzp", "zzq"});
        }
        if (i2 == 3) {
            return new zzawo();
        }
        zzawm zzawmVar = null;
        if (i2 == 4) {
            return new zzawn(zzawmVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzu = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
