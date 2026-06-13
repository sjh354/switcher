package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaa extends zzbff implements zzbgt {
    private static final zzaa zza;
    private int zzb;
    private int zzf;
    private int zzg;
    private byte zzh = 2;

    static {
        zzaa zzaaVar = new zzaa();
        zza = zzaaVar;
        zzbff.zzan(zzaa.class, zzaaVar);
    }

    private zzaa() {
    }

    public final int zza() {
        return this.zzf;
    }

    public final int zzc() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔄ\u0000\u0002ᔄ\u0001", new Object[]{"zzb", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzaa();
        }
        zzn zznVar = null;
        if (i2 == 4) {
            return new zzz(zznVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
