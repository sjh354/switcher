package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaoc extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzaoc zzb;
    private int zzf;
    private String zzg = "";

    static {
        zzaoc zzaocVar = new zzaoc();
        zzb = zzaocVar;
        zzbff.zzan(zzaoc.class, zzaocVar);
        zza = zzbff.zzac(zzbmd.zze(), zzaocVar, zzaocVar, null, 157211294, zzbip.MESSAGE, zzaoc.class);
    }

    private zzaoc() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzaoc();
        }
        zzaoa zzaoaVar = null;
        if (i2 == 4) {
            return new zzaob(zzaoaVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
