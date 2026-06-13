package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzblp extends zzbff implements zzbgt {
    private static final zzblp zza;
    private int zzb;
    private String zzf = "";
    private zzbbw zzg = zzbbw.zzb;

    static {
        zzblp zzblpVar = new zzblp();
        zza = zzblpVar;
        zzbff.zzan(zzblp.class, zzblpVar);
    }

    private zzblp() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001", new Object[]{"zzb", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzblp();
        }
        zzbku zzbkuVar = null;
        if (i2 == 4) {
            return new zzblo(zzbkuVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
