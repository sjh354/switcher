package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaxo extends zzbff implements zzbgt {
    private static final zzaxo zza;
    private int zzb;
    private zzbfp zzf = zzaj();
    private int zzg;

    static {
        zzaxo zzaxoVar = new zzaxo();
        zza = zzaxoVar;
        zzbff.zzan(zzaxo.class, zzaxoVar);
    }

    private zzaxo() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဌ\u0000", new Object[]{"zzb", "zzf", zzayh.class, "zzg", zzaxn.zzc()});
        }
        if (i2 == 3) {
            return new zzaxo();
        }
        zzaxj zzaxjVar = null;
        if (i2 == 4) {
            return new zzaxk(zzaxjVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
