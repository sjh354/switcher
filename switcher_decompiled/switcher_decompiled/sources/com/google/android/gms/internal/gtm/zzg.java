package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzg extends zzbff implements zzbgt {
    private static final zzg zza;
    private int zzb;
    private zzam zzg;
    private byte zzi = 2;
    private zzbfp zzf = zzaj();
    private String zzh = "";

    static {
        zzg zzgVar = new zzg();
        zza = zzgVar;
        zzbff.zzan(zzg.class, zzgVar);
    }

    private zzg() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0002\u0001Л\u0002ᐉ\u0000\u0003ဈ\u0001", new Object[]{"zzb", "zzf", zzi.class, "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzg();
        }
        zzc zzcVar = null;
        if (i2 == 4) {
            return new zzf(zzcVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
