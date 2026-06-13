package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzxv extends zzbff implements zzbgt {
    private static final zzxv zza;
    private int zzb;
    private zzaqi zzf;
    private byte zzg = 2;

    static {
        zzxv zzxvVar = new zzxv();
        zza = zzxvVar;
        zzbff.zzan(zzxv.class, zzxvVar);
    }

    private zzxv() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001ᐉ\u0000", new Object[]{"zzb", "zzf"});
        }
        if (i2 == 3) {
            return new zzxv();
        }
        zzxt zzxtVar = null;
        if (i2 == 4) {
            return new zzxu(zzxtVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
