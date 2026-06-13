package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzatc extends zzbff implements zzbgt {
    private static final zzatc zza;
    private int zzb;
    private int zzf;
    private int zzg;
    private zzapo zzi;
    private zzamq zzj;
    private int zzk;
    private int zzl;
    private byte zzm = 2;
    private int zzh = 1;

    static {
        zzatc zzatcVar = new zzatc();
        zza = zzatcVar;
        zzbff.zzan(zzatc.class, zzatcVar);
    }

    private zzatc() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0007\u0000\u0001\u0001\b\u0007\u0000\u0000\u0002\u0001င\u0000\u0002င\u0001\u0003ဌ\u0002\u0004ᐉ\u0003\u0006ᐉ\u0004\u0007င\u0005\bဌ\u0006", new Object[]{"zzb", "zzf", "zzg", "zzh", zzatb.zzc(), "zzi", "zzj", "zzk", "zzl", zzafh.zzc()});
        }
        if (i2 == 3) {
            return new zzatc();
        }
        zzasx zzasxVar = null;
        if (i2 == 4) {
            return new zzasy(zzasxVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
