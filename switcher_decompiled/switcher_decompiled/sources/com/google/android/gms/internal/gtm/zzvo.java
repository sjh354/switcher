package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzvo extends zzbff implements zzbgt {
    private static final zzvo zza;
    private int zzb;
    private float zzf;
    private byte zzh = 2;
    private zzbfp zzg = zzaj();

    static {
        zzvo zzvoVar = new zzvo();
        zza = zzvoVar;
        zzbff.zzan(zzvo.class, zzvoVar);
    }

    private zzvo() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0001\u0001ခ\u0000\u0002Л", new Object[]{"zzb", "zzf", "zzg", zzvn.class});
        }
        if (i2 == 3) {
            return new zzvo();
        }
        zzve zzveVar = null;
        if (i2 == 4) {
            return new zzvl(zzveVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
