package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbjx extends zzbff implements zzbgt {
    private static final zzbjx zza;
    private int zzb;
    private boolean zzf;
    private boolean zzg;

    static {
        zzbjx zzbjxVar = new zzbjx();
        zza = zzbjxVar;
        zzbff.zzan(zzbjx.class, zzbjxVar);
    }

    private zzbjx() {
    }

    public static zzbjx zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"zzb", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbjx();
        }
        zzbjr zzbjrVar = null;
        if (i2 == 4) {
            return new zzbjw(zzbjrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
