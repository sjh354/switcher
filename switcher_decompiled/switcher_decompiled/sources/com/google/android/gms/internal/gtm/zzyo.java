package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzyo extends zzbff implements zzbgt {
    private static final zzyo zza;
    private int zzb;
    private zzamq zzf;
    private zzamq zzg;
    private zzamq zzh;
    private zzamu zzi;
    private byte zzk = 2;
    private zzbfp zzj = zzaj();

    static {
        zzyo zzyoVar = new zzyo();
        zza = zzyoVar;
        zzbff.zzan(zzyo.class, zzyoVar);
    }

    private zzyo() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0005\u0001ᐉ\u0000\u0002ᐉ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005Л", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", "zzj", zzamq.class});
        }
        if (i2 == 3) {
            return new zzyo();
        }
        zzym zzymVar = null;
        if (i2 == 4) {
            return new zzyn(zzymVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
