package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzajl extends zzbff implements zzbgt {
    private static final zzajl zza;
    private int zzb;
    private byte zzi = 2;
    private String zzf = "";
    private String zzg = "";
    private int zzh = 1;

    static {
        zzajl zzajlVar = new zzajl();
        zza = zzajlVar;
        zzbff.zzan(zzajl.class, zzajlVar);
    }

    private zzajl() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔈ\u0000\u0002ᔈ\u0001\u0003ᔌ\u0002", new Object[]{"zzb", "zzf", "zzg", "zzh", zzajk.zzc()});
        }
        if (i2 == 3) {
            return new zzajl();
        }
        zzajg zzajgVar = null;
        if (i2 == 4) {
            return new zzajh(zzajgVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
