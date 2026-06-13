package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzazk extends zzbff implements zzbgt {
    private static final zzazk zza;
    private int zzb;
    private int zzf = 0;
    private Object zzg;
    private int zzh;

    static {
        zzazk zzazkVar = new zzazk();
        zza = zzazkVar;
        zzbff.zzan(zzazk.class, zzazkVar);
    }

    private zzazk() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0004\u0001\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ျ\u0000\u0003ံ\u0000\u0004ျ\u0000", new Object[]{"zzg", "zzf", "zzb", "zzh", zzazh.zzc()});
        }
        if (i2 == 3) {
            return new zzazk();
        }
        zzazi zzaziVar = null;
        if (i2 == 4) {
            return new zzazj(zzaziVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
