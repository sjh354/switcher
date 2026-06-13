package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaie extends zzbff implements zzbgt {
    private static final zzaie zza;
    private int zzb;
    private float zzf;
    private int zzg;

    static {
        zzaie zzaieVar = new zzaie();
        zza = zzaieVar;
        zzbff.zzan(zzaie.class, zzaieVar);
    }

    private zzaie() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ခ\u0000\u0002ဌ\u0001", new Object[]{"zzb", "zzf", "zzg", zzaid.zzc()});
        }
        if (i2 == 3) {
            return new zzaie();
        }
        zzahz zzahzVar = null;
        if (i2 == 4) {
            return new zzaia(zzahzVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
