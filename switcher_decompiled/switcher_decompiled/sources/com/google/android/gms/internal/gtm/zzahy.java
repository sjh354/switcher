package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzahy extends zzbff implements zzbgt {
    private static final zzahy zza;
    private int zzb;
    private int zzf;
    private zzaie zzg;
    private int zzh;

    static {
        zzahy zzahyVar = new zzahy();
        zza = zzahyVar;
        zzbff.zzan(zzahy.class, zzahyVar);
    }

    private zzahy() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဌ\u0002", new Object[]{"zzb", "zzf", zzwu.zzc(), "zzg", "zzh", zzbki.zzb()});
        }
        if (i2 == 3) {
            return new zzahy();
        }
        zzahw zzahwVar = null;
        if (i2 == 4) {
            return new zzahx(zzahwVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
