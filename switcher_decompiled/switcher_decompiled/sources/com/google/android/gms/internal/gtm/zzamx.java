package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzamx extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzamx zzb;
    private int zzf;
    private byte zzj = 2;
    private zzbbw zzg = zzbbw.zzb;
    private zzbbw zzh = zzbbw.zzb;
    private zzbfp zzi = zzaj();

    static {
        zzamx zzamxVar = new zzamx();
        zzb = zzamxVar;
        zzbff.zzan(zzamx.class, zzamxVar);
        zza = zzbff.zzac(zzbmd.zze(), zzamxVar, zzamxVar, null, 1244700, zzbip.MESSAGE, zzamx.class);
    }

    private zzamx() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001ည\u0000\u0002ည\u0001\u0003Л", new Object[]{"zzf", "zzg", "zzh", "zzi", zzamn.class});
        }
        if (i2 == 3) {
            return new zzamx();
        }
        zzamv zzamvVar = null;
        if (i2 == 4) {
            return new zzamw(zzamvVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
