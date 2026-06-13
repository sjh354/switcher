package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaze extends zzbff implements zzbgt {
    private static final zzaze zza;
    private int zzb;
    private zzbmd zzf;
    private long zzh;
    private long zzi;
    private byte zzk = 2;
    private String zzg = "";
    private String zzj = "";

    static {
        zzaze zzazeVar = new zzaze();
        zza = zzazeVar;
        zzbff.zzan(zzaze.class, zzazeVar);
    }

    private zzaze() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001ᐉ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဈ\u0004", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzaze();
        }
        zzazc zzazcVar = null;
        if (i2 == 4) {
            return new zzazd(zzazcVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
