package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbtk extends zzbff implements zzbgt {
    private static final zzbtk zza;
    private int zzb;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        zzbtk zzbtkVar = new zzbtk();
        zza = zzbtkVar;
        zzbff.zzan(zzbtk.class, zzbtkVar);
    }

    private zzbtk() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzbtk();
        }
        zzbte zzbteVar = null;
        if (i2 == 4) {
            return new zzbtj(zzbteVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
