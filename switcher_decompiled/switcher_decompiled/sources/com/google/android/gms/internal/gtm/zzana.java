package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzana extends zzbff implements zzbgt {
    private static final zzana zza;
    private int zzb;
    private zzann zzf;

    static {
        zzana zzanaVar = new zzana();
        zza = zzanaVar;
        zzbff.zzan(zzana.class, zzanaVar);
    }

    private zzana() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0001\u000f\u000f\u0001\u0000\u0000\u0000\u000fဉ\u0000", new Object[]{"zzb", "zzf"});
        }
        if (i2 == 3) {
            return new zzana();
        }
        zzamy zzamyVar = null;
        if (i2 == 4) {
            return new zzamz(zzamyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
