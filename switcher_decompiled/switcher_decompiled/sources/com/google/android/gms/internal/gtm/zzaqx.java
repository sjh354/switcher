package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaqx extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzaqx zzb;
    private int zzf;
    private double zzg;
    private double zzh;
    private String zzi = "";
    private int zzj;

    static {
        zzaqx zzaqxVar = new zzaqx();
        zzb = zzaqxVar;
        zzbff.zzan(zzaqx.class, zzaqxVar);
        zza = zzbff.zzac(zzbmd.zze(), zzaqxVar, zzaqxVar, null, 15000834, zzbip.MESSAGE, zzaqx.class);
    }

    private zzaqx() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001က\u0000\u0002က\u0001\u0003ဈ\u0002\u0004ဌ\u0003", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", zzaqw.zzc()});
        }
        if (i2 == 3) {
            return new zzaqx();
        }
        zzaqs zzaqsVar = null;
        if (i2 == 4) {
            return new zzaqt(zzaqsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
