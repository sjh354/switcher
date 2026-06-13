package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzm extends zzbff implements zzbgt {
    private static final zzm zza;
    private byte zzg = 2;
    private zzbfp zzb = zzaj();
    private zzbfp zzf = zzaj();

    static {
        zzm zzmVar = new zzm();
        zza = zzmVar;
        zzbff.zzan(zzm.class, zzmVar);
    }

    private zzm() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0002\u0001Л\u0002Л", new Object[]{"zzb", zzk.class, "zzf", zzg.class});
        }
        if (i2 == 3) {
            return new zzm();
        }
        zzc zzcVar = null;
        if (i2 == 4) {
            return new zzl(zzcVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
