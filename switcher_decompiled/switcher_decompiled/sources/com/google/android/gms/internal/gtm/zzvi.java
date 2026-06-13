package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzvi extends zzbfb implements zzbgt {
    private static final zzvi zza;
    private int zzf;
    private byte zzi = 2;
    private String zzg = "";
    private String zzh = "";

    static {
        zzvi zzviVar = new zzvi();
        zza = zzviVar;
        zzbff.zzan(zzvi.class, zzviVar);
    }

    private zzvi() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzvi();
        }
        zzve zzveVar = null;
        if (i2 == 4) {
            return new zzvh(zzveVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
