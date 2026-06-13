package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbns extends zzbff implements zzbgt {
    private static final zzbns zza;
    private int zzb;
    private zzbnj zzg;
    private int zzh;
    private byte zzi = 2;
    private int zzf = 1;

    static {
        zzbns zzbnsVar = new zzbns();
        zza = zzbnsVar;
        zzbff.zzan(zzbns.class, zzbnsVar);
    }

    private zzbns() {
    }

    public static zzbns zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ဌ\u0000\u0002ᐉ\u0001\u0003ဌ\u0002", new Object[]{"zzb", "zzf", zzbnr.zzb(), "zzg", "zzh", zzbno.zzb()});
        }
        if (i2 == 3) {
            return new zzbns();
        }
        zzbnk zzbnkVar = null;
        if (i2 == 4) {
            return new zzbnl(zzbnkVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
