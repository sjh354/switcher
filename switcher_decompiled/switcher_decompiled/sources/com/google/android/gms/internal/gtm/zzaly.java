package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaly extends zzbff implements zzbgt {
    private static final zzaly zza;
    private int zzb;
    private zzayj zzh;
    private zzaaq zzi;
    private zzalt zzj;
    private zzaea zzk;
    private zzafk zzl;
    private byte zzm = 2;
    private int zzf = 241;
    private zzbfp zzg = zzaj();

    static {
        zzaly zzalyVar = new zzaly();
        zza = zzalyVar;
        zzbff.zzan(zzaly.class, zzalyVar);
    }

    private zzaly() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0007\u0000\u0001\u0001\u000e\u0007\u0000\u0001\u0004\u0001ဌ\u0000\u0002Л\u0007ဉ\u0001\tဉ\u0003\nᐉ\u0004\rᐉ\u0002\u000eᐉ\u0005", new Object[]{"zzb", "zzf", zzalx.zzc(), "zzg", zzawq.class, "zzh", "zzj", "zzk", "zzi", "zzl"});
        }
        if (i2 == 3) {
            return new zzaly();
        }
        zzalr zzalrVar = null;
        if (i2 == 4) {
            return new zzalu(zzalrVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
