package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzvk extends zzbff implements zzbgt {
    private static final zzvk zza;
    private int zzb;
    private float zzf;
    private float zzg;

    static {
        zzvk zzvkVar = new zzvk();
        zza = zzvkVar;
        zzbff.zzan(zzvk.class, zzvkVar);
    }

    private zzvk() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001", new Object[]{"zzb", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzvk();
        }
        zzve zzveVar = null;
        if (i2 == 4) {
            return new zzvj(zzveVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
