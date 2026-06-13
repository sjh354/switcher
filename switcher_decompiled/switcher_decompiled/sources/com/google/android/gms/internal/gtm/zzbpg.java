package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbpg extends zzbff implements zzbgt {
    private static final zzbpg zza;
    private int zzb;
    private boolean zzf;
    private boolean zzg;
    private zzbqb zzh;
    private zzbqb zzi;
    private zzbqb zzj;
    private zzbqb zzk;
    private byte zzl = 2;

    static {
        zzbpg zzbpgVar = new zzbpg();
        zza = zzbpgVar;
        zzbff.zzan(zzbpg.class, zzbpgVar);
    }

    private zzbpg() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0004\u0001ဇ\u0000\u0002ဇ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005ᐉ\u0004\u0006ᐉ\u0005", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzbpg();
        }
        zzbpe zzbpeVar = null;
        if (i2 == 4) {
            return new zzbpf(zzbpeVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
