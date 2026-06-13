package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaez extends zzbff implements zzbgt {
    private static final zzaez zza;
    private zzbfp zzb = zzaj();

    static {
        zzaez zzaezVar = new zzaez();
        zza = zzaezVar;
        zzbff.zzan(zzaez.class, zzaezVar);
    }

    private zzaez() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zzaex.class});
        }
        if (i2 == 3) {
            return new zzaez();
        }
        zzaev zzaevVar = null;
        if (i2 == 4) {
            return new zzaey(zzaevVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
