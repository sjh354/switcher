package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaqf extends zzbff implements zzbgt {
    private static final zzaqf zza;
    private int zzb;
    private float zzh;
    private float zzi;
    private boolean zzj;
    private double zzk;
    private byte zzl = 2;
    private int zzf = 1;
    private zzbfp zzg = zzaj();

    static {
        zzaqf zzaqfVar = new zzaqf();
        zza = zzaqfVar;
        zzbff.zzan(zzaqf.class, zzaqfVar);
    }

    private zzaqf() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဌ\u0000\u0002Л\u0003ခ\u0001\u0004ခ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zzb", "zzf", zzaqe.zzc(), "zzg", zzasg.class, "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzaqf();
        }
        zzaqa zzaqaVar = null;
        if (i2 == 4) {
            return new zzaqb(zzaqaVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
