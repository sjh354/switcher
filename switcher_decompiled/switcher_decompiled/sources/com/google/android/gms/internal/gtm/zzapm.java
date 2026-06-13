package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzapm extends zzbff implements zzbgt {
    private static final zzapm zza;
    private int zzb;
    private float zzg;
    private boolean zzh;
    private float zzi;
    private float zzj;
    private byte zzk = 2;
    private String zzf = "";

    static {
        zzapm zzapmVar = new zzapm();
        zza = zzapmVar;
        zzbff.zzan(zzapm.class, zzapmVar);
    }

    private zzapm() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001ᔈ\u0000\u0002ခ\u0001\u0003ဇ\u0002\u0004ခ\u0003\u0005ခ\u0004", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzapm();
        }
        zzapk zzapkVar = null;
        if (i2 == 4) {
            return new zzapl(zzapkVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
