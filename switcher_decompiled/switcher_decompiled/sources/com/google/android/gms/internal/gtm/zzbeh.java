package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbeh extends zzbff implements zzbgt {
    private static final zzbeh zza;
    private int zzb;
    private boolean zzg;
    private byte zzh = 2;
    private String zzf = "";

    static {
        zzbeh zzbehVar = new zzbeh();
        zza = zzbehVar;
        zzbff.zzan(zzbeh.class, zzbehVar);
    }

    private zzbeh() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return new zzbhd(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔇ\u0001", new Object[]{"zzb", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbeh();
        }
        zzbcl zzbclVar = null;
        if (i2 == 4) {
            return new zzbeg(zzbclVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
