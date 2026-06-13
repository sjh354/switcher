package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzvv extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzvv zzb;
    private int zzf;
    private zzvi zzg;
    private long zzi;
    private byte zzk = 2;
    private zzbfp zzh = zzaj();
    private int zzj = 1;

    static {
        zzvv zzvvVar = new zzvv();
        zzb = zzvvVar;
        zzbff.zzan(zzvv.class, zzvvVar);
        zza = zzbff.zzac(zzbmd.zze(), zzvvVar, zzvvVar, null, 115225276, zzbip.MESSAGE, zzvv.class);
    }

    private zzvv() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0002\u0001ᐉ\u0000\u0002Л\u0003ဂ\u0001\u0004ဌ\u0002", new Object[]{"zzf", "zzg", "zzh", zzwc.class, "zzi", "zzj", zzvu.zzc()});
        }
        if (i2 == 3) {
            return new zzvv();
        }
        zzve zzveVar = null;
        if (i2 == 4) {
            return new zzvr(zzveVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
