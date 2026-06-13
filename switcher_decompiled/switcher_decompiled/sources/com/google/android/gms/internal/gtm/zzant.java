package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzant extends zzbff implements zzbgt {
    private static final zzant zza;
    private int zzb;
    private zzamq zzh;
    private zzamq zzi;
    private byte zzj = 2;
    private zzbfp zzf = zzaj();
    private zzbfp zzg = zzaj();

    static {
        zzant zzantVar = new zzant();
        zza = zzantVar;
        zzbff.zzan(zzant.class, zzantVar);
    }

    private zzant() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0004\u0001Л\u0002Л\u0003ᐉ\u0000\u0004ᐉ\u0001", new Object[]{"zzb", "zzf", zzamq.class, "zzg", zzamq.class, "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzant();
        }
        zzanr zzanrVar = null;
        if (i2 == 4) {
            return new zzans(zzanrVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
