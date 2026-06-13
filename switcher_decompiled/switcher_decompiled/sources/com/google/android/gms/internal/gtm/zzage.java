package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzage extends zzbff implements zzbgt {
    private static final zzage zza;
    private int zzb;
    private Object zzg;
    private Object zzi;
    private int zzf = 0;
    private int zzh = 0;
    private byte zzj = 2;

    static {
        zzage zzageVar = new zzage();
        zza = zzageVar;
        zzbff.zzan(zzage.class, zzageVar);
    }

    private zzage() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0004\u0002\u0001\u0001\u0004\u0004\u0000\u0000\u0004\u0001ᐼ\u0000\u0002ᐼ\u0001\u0003ᐼ\u0000\u0004ᐼ\u0001", new Object[]{"zzg", "zzf", "zzi", "zzh", "zzb", zzaky.class, zzaky.class, zzaky.class, zzaky.class});
        }
        if (i2 == 3) {
            return new zzage();
        }
        zzagc zzagcVar = null;
        if (i2 == 4) {
            return new zzagd(zzagcVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
