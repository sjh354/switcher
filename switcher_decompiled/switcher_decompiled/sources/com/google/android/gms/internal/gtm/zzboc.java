package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzboc extends zzbff implements zzbgt {
    private static final zzboc zza;
    private zzbfp zzb = zzbff.zzaj();

    static {
        zzboc zzbocVar = new zzboc();
        zza = zzbocVar;
        zzbff.zzan(zzboc.class, zzbocVar);
    }

    private zzboc() {
    }

    public static zzboc zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzb"});
        }
        if (i2 == 3) {
            return new zzboc();
        }
        zzboa zzboaVar = null;
        if (i2 == 4) {
            return new zzbob(zzboaVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
