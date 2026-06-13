package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzazb extends zzbff implements zzbgt {
    public static final zzbfd zza;
    public static final zzbfd zzb;
    private static final zzazb zzf;
    private int zzg;
    private zzbbw zzh = zzbbw.zzb;
    private String zzi = "";
    private int zzj = 71644;
    private String zzk = "";

    static {
        zzazb zzazbVar = new zzazb();
        zzf = zzazbVar;
        zzbff.zzan(zzazb.class, zzazbVar);
        zza = zzbff.zzac(zzbcz.zze(), 0, null, null, 209473639, zzbip.INT32, Integer.class);
        zzb = zzbff.zzac(zzbcz.zze(), 0, null, null, 313857734, zzbip.INT32, Integer.class);
    }

    private zzazb() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzf, "\u0001\u0004\u0000\u0001\u0001\u0006\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ဈ\u0001\u0003ဈ\u0003\u0006င\u0002", new Object[]{"zzg", "zzh", "zzi", "zzk", "zzj"});
        }
        if (i2 == 3) {
            return new zzazb();
        }
        zzayz zzayzVar = null;
        if (i2 == 4) {
            return new zzaza(zzayzVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzf;
    }
}
