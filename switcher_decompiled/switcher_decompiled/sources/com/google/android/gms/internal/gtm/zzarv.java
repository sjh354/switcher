package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzarv extends zzbff implements zzbgt {
    private static final zzarv zza;
    private int zzb;
    private int zzi;
    private byte zzj = 2;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    static {
        zzarv zzarvVar = new zzarv();
        zza = zzarvVar;
        zzbff.zzan(zzarv.class, zzarvVar);
    }

    private zzarv() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0003\u0001ᔈ\u0000\u0002ᔈ\u0001\u0003ᔈ\u0002\u0004ဌ\u0003", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", zzaru.zzc()});
        }
        if (i2 == 3) {
            return new zzarv();
        }
        zzarq zzarqVar = null;
        if (i2 == 4) {
            return new zzarr(zzarqVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
