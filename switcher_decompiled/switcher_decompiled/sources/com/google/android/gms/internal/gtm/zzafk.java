package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzafk extends zzbff implements zzbgt {
    private static final zzafk zza;
    private byte zzf = 2;
    private zzbfp zzb = zzaj();

    static {
        zzafk zzafkVar = new zzafk();
        zza = zzafkVar;
        zzbff.zzan(zzafk.class, zzafkVar);
    }

    private zzafk() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzf);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zzb", zzamq.class});
        }
        if (i2 == 3) {
            return new zzafk();
        }
        zzafi zzafiVar = null;
        if (i2 == 4) {
            return new zzafj(zzafiVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzf = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
