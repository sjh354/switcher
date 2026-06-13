package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzakd extends zzbff implements zzbgt {
    private static final zzakd zza;
    private int zzb;
    private int zzf = 1;
    private String zzg = "";

    static {
        zzakd zzakdVar = new zzakd();
        zza = zzakdVar;
        zzbff.zzan(zzakd.class, zzakdVar);
    }

    private zzakd() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001", new Object[]{"zzb", "zzf", zzajz.zzc(), "zzg"});
        }
        if (i2 == 3) {
            return new zzakd();
        }
        zzajw zzajwVar = null;
        if (i2 == 4) {
            return new zzakc(zzajwVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
