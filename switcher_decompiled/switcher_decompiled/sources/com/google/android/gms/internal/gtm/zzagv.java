package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzagv extends zzbff implements zzbgt {
    private static final zzagv zza;
    private int zzb;
    private zzamq zzg;
    private byte zzh = 2;
    private zzbfp zzf = zzaj();

    static {
        zzagv zzagvVar = new zzagv();
        zza = zzagvVar;
        zzbff.zzan(zzagv.class, zzagvVar);
    }

    private zzagv() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0002\u0001Л\u0002ᐉ\u0000", new Object[]{"zzb", "zzf", zzagt.class, "zzg"});
        }
        if (i2 == 3) {
            return new zzagv();
        }
        zzagr zzagrVar = null;
        if (i2 == 4) {
            return new zzagu(zzagrVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
