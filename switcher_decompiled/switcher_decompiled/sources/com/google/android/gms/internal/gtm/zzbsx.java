package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbsx extends zzbff implements zzbgt {
    private static final zzbsx zza;

    static {
        zzbsx zzbsxVar = new zzbsx();
        zza = zzbsxVar;
        zzbff.zzan(zzbsx.class, zzbsxVar);
    }

    private zzbsx() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        zzbsv zzbsvVar = null;
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new zzbsx();
        }
        if (i2 == 4) {
            return new zzbsw(zzbsvVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
