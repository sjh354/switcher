package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzahd extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzahd zzb;
    private int zzf;
    private zzahb zzg;

    static {
        zzahd zzahdVar = new zzahd();
        zzb = zzahdVar;
        zzbff.zzan(zzahd.class, zzahdVar);
        zza = zzbff.zzac(zzbmd.zze(), zzahdVar, zzahdVar, null, 24882046, zzbip.MESSAGE, zzahd.class);
    }

    private zzahd() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzahd();
        }
        zzagw zzagwVar = null;
        if (i2 == 4) {
            return new zzahc(zzagwVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
