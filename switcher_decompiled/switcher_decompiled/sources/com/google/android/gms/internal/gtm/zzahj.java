package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzahj extends zzbff implements zzbgt {
    private static final zzahj zza;

    static {
        zzahj zzahjVar = new zzahj();
        zza = zzahjVar;
        zzbff.zzan(zzahj.class, zzahjVar);
    }

    private zzahj() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        zzahh zzahhVar = null;
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new zzahj();
        }
        if (i2 == 4) {
            return new zzahi(zzahhVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
