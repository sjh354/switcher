package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzapg extends zzbff implements zzbgt {
    private static final zzapg zza;
    private int zzb;
    private float zzf;
    private byte zzh = 2;
    private zzbfp zzg = zzaj();

    static {
        zzapg zzapgVar = new zzapg();
        zza = zzapgVar;
        zzbff.zzan(zzapg.class, zzapgVar);
    }

    private zzapg() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0001\u0001ခ\u0000\u0002Л", new Object[]{"zzb", "zzf", "zzg", zzamq.class});
        }
        if (i2 == 3) {
            return new zzapg();
        }
        zzape zzapeVar = null;
        if (i2 == 4) {
            return new zzapf(zzapeVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
