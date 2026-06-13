package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbsk extends zzbfb implements zzbgt {
    public static final zzbfd zza;
    private static final zzbsk zzf;
    private byte zzh = 2;
    private zzbfp zzg = zzaj();

    static {
        zzbsk zzbskVar = new zzbsk();
        zzf = zzbskVar;
        zzbff.zzan(zzbsk.class, zzbskVar);
        zza = zzbff.zzac(zzbmd.zze(), zzbskVar, zzbskVar, null, 45632928, zzbip.MESSAGE, zzbsk.class);
    }

    private zzbsk() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzam(zzf, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zzg", zzbsi.class});
        }
        if (i2 == 3) {
            return new zzbsk();
        }
        zzbrq zzbrqVar = null;
        if (i2 == 4) {
            return new zzbsj(zzbrqVar);
        }
        if (i2 == 5) {
            return zzf;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
