package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzvq extends zzbfb implements zzbgt {
    private static final zzvq zza;
    private byte zzg = 2;
    private zzbfp zzf = zzaj();

    static {
        zzvq zzvqVar = new zzvq();
        zza = zzvqVar;
        zzbff.zzan(zzvq.class, zzvqVar);
    }

    private zzvq() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zzf", zzvv.class});
        }
        if (i2 == 3) {
            return new zzvq();
        }
        zzve zzveVar = null;
        if (i2 == 4) {
            return new zzvp(zzveVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
