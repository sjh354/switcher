package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbtb extends zzbff implements zzbgt {
    private static final zzbtb zza;
    private int zzb;
    private zzbfp zzf = zzbff.zzaj();
    private long zzg;

    static {
        zzbtb zzbtbVar = new zzbtb();
        zza = zzbtbVar;
        zzbff.zzan(zzbtb.class, zzbtbVar);
    }

    private zzbtb() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001a\u0002ဂ\u0000", new Object[]{"zzb", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbtb();
        }
        zzbsv zzbsvVar = null;
        if (i2 == 4) {
            return new zzbta(zzbsvVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
