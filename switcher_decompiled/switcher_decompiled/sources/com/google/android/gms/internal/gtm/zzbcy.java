package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbcy extends zzbff implements zzbgt {
    private static final zzbcy zza;
    private int zzb;
    private String zzf = "";
    private String zzg = "";

    static {
        zzbcy zzbcyVar = new zzbcy();
        zza = zzbcyVar;
        zzbff.zzan(zzbcy.class, zzbcyVar);
    }

    private zzbcy() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzbhd(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzb", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbcy();
        }
        zzbcl zzbclVar = null;
        if (i2 == 4) {
            return new zzbcx(zzbclVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
