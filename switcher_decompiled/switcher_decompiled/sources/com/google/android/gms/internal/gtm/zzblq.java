package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzblq extends zzbff implements zzbgt {
    private static final zzblq zza;
    private int zzb;
    private Object zzg;
    private int zzf = 0;
    private String zzh = "";

    static {
        zzblq zzblqVar = new zzblq();
        zza = zzblqVar;
        zzbff.zzan(zzblq.class, zzblqVar);
    }

    private zzblq() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\r\u0001\u0001\u0001\r\r\u0000\u0000\u0000\u0001ျ\u0000\u0002ျ\u0000\u0003်\u0000\u0004ဵ\u0000\u0005ံ\u0000\u0006ဳ\u0000\u0007ြ\u0000\bဵ\u0000\tံ\u0000\nြ\u0000\u000bဈ\f\fြ\u0000\rျ\u0000", new Object[]{"zzg", "zzf", "zzb", zzbat.class, zzblp.class, "zzh", zzbky.class});
        }
        if (i2 == 3) {
            return new zzblq();
        }
        zzbku zzbkuVar = null;
        if (i2 == 4) {
            return new zzbln(zzbkuVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
