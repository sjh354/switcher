package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzatw extends zzbff implements zzbgt {
    private static final zzatw zza;
    private int zzb;
    private zzamq zzf;
    private int zzh;
    private zzana zzi;
    private byte zzj = 2;
    private int zzg = 2;

    static {
        zzatw zzatwVar = new zzatw();
        zza = zzatwVar;
        zzbff.zzan(zzatw.class, zzatwVar);
    }

    private zzatw() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0004\u0000\u0001\u0001Ǵ\u0004\u0000\u0000\u0001\u0001ᔉ\u0000\u0002ဌ\u0001\u0003ဌ\u0002Ǵဉ\u0003", new Object[]{"zzb", "zzf", "zzg", zzatv.zzc(), "zzh", zzafh.zzc(), "zzi"});
        }
        if (i2 == 3) {
            return new zzatw();
        }
        zzatm zzatmVar = null;
        if (i2 == 4) {
            return new zzats(zzatmVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
