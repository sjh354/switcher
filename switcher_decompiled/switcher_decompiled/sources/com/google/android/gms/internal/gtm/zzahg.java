package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzahg extends zzbff implements zzbgt {
    private static final zzahg zza;

    static {
        zzahg zzahgVar = new zzahg();
        zza = zzahgVar;
        zzbff.zzan(zzahg.class, zzahgVar);
    }

    private zzahg() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        zzahe zzaheVar = null;
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new zzahg();
        }
        if (i2 == 4) {
            return new zzahf(zzaheVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
