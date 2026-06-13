package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzays extends zzbff implements zzbgt {
    private static final zzays zza;
    private byte zzf = 2;
    private zzbfp zzb = zzaj();

    static {
        zzays zzaysVar = new zzays();
        zza = zzaysVar;
        zzbff.zzan(zzays.class, zzaysVar);
    }

    private zzays() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzf);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0000\b\b\u0001\u0000\u0001\u0001\bЛ", new Object[]{"zzb", zzamq.class});
        }
        if (i2 == 3) {
            return new zzays();
        }
        zzayq zzayqVar = null;
        if (i2 == 4) {
            return new zzayr(zzayqVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzf = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
