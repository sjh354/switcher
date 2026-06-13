package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaqi extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzaqi zzb;
    private int zzf;
    private int zzg;
    private int zzh;
    private zzana zzi;
    private zzbmd zzj;
    private byte zzk = 2;

    static {
        zzaqi zzaqiVar = new zzaqi();
        zzb = zzaqiVar;
        zzbff.zzan(zzaqi.class, zzaqiVar);
        zza = zzbff.zzac(zzbmd.zze(), zzaqiVar, zzaqiVar, null, 14827556, zzbip.MESSAGE, zzaqi.class);
    }

    private zzaqi() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0004\u0000\u0001\u0001Ǵ\u0004\u0000\u0000\u0003\u0001ᔆ\u0000\u0002ᔆ\u0001\u000fᐉ\u0003Ǵဉ\u0002", new Object[]{"zzf", "zzg", "zzh", "zzj", "zzi"});
        }
        if (i2 == 3) {
            return new zzaqi();
        }
        zzaqg zzaqgVar = null;
        if (i2 == 4) {
            return new zzaqh(zzaqgVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
