package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzuo extends zzbff implements zzbgt {
    private static final zzuo zza;
    private int zzb;
    private zzuq zzg;
    private zzuq zzh;
    private int zzj;
    private int zzk;
    private zzbnj zzl;
    private byte zzm = 2;
    private String zzf = "";
    private String zzi = "";

    static {
        zzuo zzuoVar = new zzuo();
        zza = zzuoVar;
        zzbff.zzan(zzuo.class, zzuoVar);
    }

    private zzuo() {
    }

    public static zzuo zzc() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0007\u0000\u0001\u0001\t\u0007\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဌ\u0004\u0005ဌ\u0005\u0006ဈ\u0003\tᐉ\u0006", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzj", zzuk.zzc(), "zzk", zzun.zzc(), "zzi", "zzl"});
        }
        if (i2 == 3) {
            return new zzuo();
        }
        zzug zzugVar = null;
        if (i2 == 4) {
            return new zzuh(zzugVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
