package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzavk extends zzbff implements zzbgt {
    private static final zzavk zza;
    private int zzb;
    private zzaqo zzf;
    private zzamq zzg;
    private zzxj zzh;
    private byte zzj = 2;
    private String zzi = "";

    static {
        zzavk zzavkVar = new zzavk();
        zza = zzavkVar;
        zzbff.zzan(zzavk.class, zzavkVar);
    }

    private zzavk() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0004\u0000\u0001\u0001\u0010\u0004\u0000\u0000\u0002\u0001ᐉ\u0000\u0002ᐉ\u0001\u0003ဉ\u0002\u0010ဈ\u0003", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzavk();
        }
        zzatm zzatmVar = null;
        if (i2 == 4) {
            return new zzavj(zzatmVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
