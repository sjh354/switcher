package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzapa extends zzbff implements zzbgt {
    private static final zzapa zza;
    private int zzb;
    private int zzf;
    private boolean zzg;
    private float zzj;
    private float zzk;
    private float zzn;
    private float zzo;
    private int zzp;
    private zzana zzq;
    private zzaok zzr;
    private int zzu;
    private byte zzw = 2;
    private int zzh = 1;
    private int zzi = 1;
    private zzbfp zzl = zzaj();
    private zzbfp zzm = zzaj();
    private zzbfp zzs = zzaj();
    private zzbfp zzt = zzaj();
    private String zzv = "";

    static {
        zzapa zzapaVar = new zzapa();
        zza = zzapaVar;
        zzbff.zzan(zzapa.class, zzapaVar);
    }

    private zzapa() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzw);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0011\u0000\u0001\u0001Ǵ\u0011\u0000\u0004\u0005\u0001ᔄ\u0000\u0002ဇ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ခ\u0004\u0006ခ\u0005\u0007Л\bЛ\tခ\u0006\nခ\u0007\u000bဌ\b\fဉ\n\rЛ\u000eЛ\u000fဌ\u000b\u0010ဈ\fǴဉ\t", new Object[]{"zzb", "zzf", "zzg", "zzh", zzaoz.zzc(), "zzi", zzaot.zzc(), "zzj", "zzk", "zzl", zzasg.class, "zzm", zzaoq.class, "zzn", "zzo", "zzp", zzaow.zzc(), "zzr", "zzs", zzamq.class, "zzt", zzaoi.class, "zzu", zzaoo.zzc(), "zzv", "zzq"});
        }
        if (i2 == 3) {
            return new zzapa();
        }
        zzaod zzaodVar = null;
        if (i2 == 4) {
            return new zzaol(zzaodVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzw = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
