package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzuc extends zzbff implements zzbgt {
    private static final zzuc zza;
    private int zzb;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private int zzx;

    static {
        zzuc zzucVar = new zzuc();
        zza = zzucVar;
        zzbff.zzan(zzuc.class, zzucVar);
    }

    private zzuc() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bဇ\u0007\tဇ\b\nဇ\t\u000bဇ\n\fဇ\u000b\rဇ\f\u000eဇ\r\u000fဇ\u000e\u0010ဇ\u000f\u0011ဇ\u0010\u0012ဇ\u0011\u0013ဌ\u0012", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", zzub.zzc()});
        }
        if (i2 == 3) {
            return new zzuc();
        }
        zztx zztxVar = null;
        if (i2 == 4) {
            return new zzty(zztxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
