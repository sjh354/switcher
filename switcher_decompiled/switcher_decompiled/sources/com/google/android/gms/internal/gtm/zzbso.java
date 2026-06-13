package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbso extends zzbff implements zzbgt {
    private static final zzbso zza;
    private int zzb;
    private boolean zzf;
    private zzbfp zzg = zzbff.zzaj();
    private long zzh;
    private boolean zzi;

    static {
        zzbso zzbsoVar = new zzbso();
        zza = zzbsoVar;
        zzbff.zzan(zzbso.class, zzbsoVar);
    }

    private zzbso() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဇ\u0000\u0002\u001a\u0003ဃ\u0001\u0004ဇ\u0002", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzbso();
        }
        zzbsm zzbsmVar = null;
        if (i2 == 4) {
            return new zzbsn(zzbsmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
