package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaci extends zzbff implements zzbgt {
    private static final zzaci zza;
    private int zzb;
    private zzabz zzf;
    private zzach zzg;
    private zzach zzh;
    private zzach zzi;
    private zzach zzj;
    private zzach zzk;

    static {
        zzaci zzaciVar = new zzaci();
        zza = zzaciVar;
        zzbff.zzan(zzaci.class, zzaciVar);
    }

    private zzaci() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzaci();
        }
        zzabt zzabtVar = null;
        if (i2 == 4) {
            return new zzabx(zzabtVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
