package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbrh extends zzbff implements zzbgt {
    private static final zzbrh zza;
    private zzbfp zzb = zzbff.zzaj();

    static {
        zzbrh zzbrhVar = new zzbrh();
        zza = zzbrhVar;
        zzbff.zzan(zzbrh.class, zzbrhVar);
    }

    private zzbrh() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzb"});
        }
        if (i2 == 3) {
            return new zzbrh();
        }
        zzbqi zzbqiVar = null;
        if (i2 == 4) {
            return new zzbrg(zzbqiVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
