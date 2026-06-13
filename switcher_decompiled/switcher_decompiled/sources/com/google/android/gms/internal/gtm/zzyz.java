package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzyz extends zzbff implements zzbgt {
    private static final zzyz zza;
    private byte zzh = 2;
    private zzbfp zzb = zzaj();
    private zzbfp zzf = zzaj();
    private zzbfp zzg = zzaj();

    static {
        zzyz zzyzVar = new zzyz();
        zza = zzyzVar;
        zzbff.zzan(zzyz.class, zzyzVar);
    }

    private zzyz() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0003\u0003\u0001Л\u0002Л\u0003Л", new Object[]{"zzb", zzamq.class, "zzf", zzamq.class, "zzg", zzamq.class});
        }
        if (i2 == 3) {
            return new zzyz();
        }
        zzyx zzyxVar = null;
        if (i2 == 4) {
            return new zzyy(zzyxVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
