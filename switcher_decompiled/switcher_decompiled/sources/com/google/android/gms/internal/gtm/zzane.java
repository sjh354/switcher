package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzane extends zzbff implements zzbgt {
    private static final zzane zza;
    private int zzb;
    private int zzf;
    private int zzg;
    private byte zzh = 2;

    static {
        zzane zzaneVar = new zzane();
        zza = zzaneVar;
        zzbff.zzan(zzane.class, zzaneVar);
    }

    private zzane() {
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
            return new zzane();
        }
        zzanc zzancVar = null;
        if (i2 == 4) {
            return new zzand(zzancVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
