package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzalk extends zzbff implements zzbgt {
    private static final zzalk zza;
    private int zzb;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private boolean zzi;
    private int zzj;
    private zzbmd zzk;
    private byte zzl = 2;

    static {
        zzalk zzalkVar = new zzalk();
        zza = zzalkVar;
        zzbff.zzan(zzalk.class, zzalkVar);
    }

    private zzalk() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0003\u0001ᔄ\u0000\u0002ᔄ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005င\u0004\u0006ᐉ\u0005", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzalk();
        }
        zzali zzaliVar = null;
        if (i2 == 4) {
            return new zzalj(zzaliVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
