package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzajs extends zzbff implements zzbgt {
    private static final zzajs zza;
    private int zzb;
    private String zzf = "";
    private String zzg = "";

    static {
        zzajs zzajsVar = new zzajs();
        zza = zzajsVar;
        zzbff.zzan(zzajs.class, zzajsVar);
    }

    private zzajs() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0005\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0005ဈ\u0001", new Object[]{"zzb", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzajs();
        }
        zzajg zzajgVar = null;
        if (i2 == 4) {
            return new zzajr(zzajgVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
