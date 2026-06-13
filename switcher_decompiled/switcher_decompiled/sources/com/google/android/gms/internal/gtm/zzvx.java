package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzvx extends zzbfb implements zzbgt {
    public static final zzbfd zza;
    private static final zzvx zzf;
    private int zzg;
    private zzvi zzh;
    private byte zzj = 2;
    private zzbfp zzi = zzaj();

    static {
        zzvx zzvxVar = new zzvx();
        zzf = zzvxVar;
        zzbff.zzan(zzvx.class, zzvxVar);
        zza = zzbff.zzac(zzbmd.zze(), zzvxVar, zzvxVar, null, 17018692, zzbip.MESSAGE, zzvx.class);
    }

    private zzvx() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i2 == 2) {
            return zzam(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0002\u0001ᐉ\u0000\u0002Л", new Object[]{"zzg", "zzh", "zzi", zzvv.class});
        }
        if (i2 == 3) {
            return new zzvx();
        }
        zzve zzveVar = null;
        if (i2 == 4) {
            return new zzvw(zzveVar);
        }
        if (i2 == 5) {
            return zzf;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
