package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzank extends zzbff implements zzbgt {
    private static final zzank zza;
    private int zzb;
    private int zzf = 17;
    private zzbfp zzg = zzaj();

    static {
        zzank zzankVar = new zzank();
        zza = zzankVar;
        zzbff.zzan(zzank.class, zzankVar);
    }

    private zzank() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzb", "zzf", zzanj.zzc(), "zzg", zzapd.class});
        }
        if (i2 == 3) {
            return new zzank();
        }
        zzanf zzanfVar = null;
        if (i2 == 4) {
            return new zzang(zzanfVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
