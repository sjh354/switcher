package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbmd extends zzbfb implements zzbgt {
    private static final zzbmd zza;
    private byte zzf = 2;

    static {
        zzbmd zzbmdVar = new zzbmd();
        zza = zzbmdVar;
        zzbff.zzan(zzbmd.class, zzbmdVar);
    }

    private zzbmd() {
    }

    public static zzbmd zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzf);
        }
        zzbmb zzbmbVar = null;
        if (i2 == 2) {
            return zzam(zza, "\u0003\u0000", null);
        }
        if (i2 == 3) {
            return new zzbmd();
        }
        if (i2 == 4) {
            return new zzbmc(zzbmbVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzf = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
