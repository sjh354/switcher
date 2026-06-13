package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzajv extends zzbff implements zzbgt {
    private static final zzajv zza;
    private int zzb;
    private zzamq zzg;
    private zzana zzh;
    private byte zzi = 2;
    private String zzf = "";

    static {
        zzajv zzajvVar = new zzajv();
        zza = zzajvVar;
        zzbff.zzan(zzajv.class, zzajvVar);
    }

    private zzajv() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0001Ǵ\u0003\u0000\u0000\u0001\u0001ဈ\u0000\u0002ᐉ\u0001Ǵဉ\u0002", new Object[]{"zzb", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzajv();
        }
        zzajt zzajtVar = null;
        if (i2 == 4) {
            return new zzaju(zzajtVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
