package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzboq extends zzbff implements zzbgt {
    private static final zzboq zza;
    private int zzb;
    private int zzf;
    private int zzg;
    private byte zzh = 2;

    static {
        zzboq zzboqVar = new zzboq();
        zza = zzboqVar;
        zzbff.zzan(zzboq.class, zzboqVar);
    }

    private zzboq() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0002\u0002ᔄ\u0000\u0003ᔄ\u0001", new Object[]{"zzb", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzboq();
        }
        zzbon zzbonVar = null;
        if (i2 == 4) {
            return new zzbop(zzbonVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
