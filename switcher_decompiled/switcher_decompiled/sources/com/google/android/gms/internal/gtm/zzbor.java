package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbor extends zzbff implements zzbgt {
    private static final zzbor zza;
    private int zzb;
    private int zzg;
    private byte zzh = 2;
    private zzbfp zzf = zzaj();

    static {
        zzbor zzborVar = new zzbor();
        zza = zzborVar;
        zzbff.zzan(zzbor.class, zzborVar);
    }

    private zzbor() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0004\u0002\u0000\u0001\u0002\u0001б\u0004ᔄ\u0000", new Object[]{"zzb", "zzf", zzboq.class, "zzg"});
        }
        if (i2 == 3) {
            return new zzbor();
        }
        zzbon zzbonVar = null;
        if (i2 == 4) {
            return new zzboo(zzbonVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
