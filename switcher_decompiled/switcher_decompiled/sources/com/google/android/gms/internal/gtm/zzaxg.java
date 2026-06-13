package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaxg extends zzbff implements zzbgt {
    private static final zzaxg zza;
    private int zzb;
    private zzaqi zzf;
    private float zzg;
    private byte zzh = 2;

    static {
        zzaxg zzaxgVar = new zzaxg();
        zza = zzaxgVar;
        zzbff.zzan(zzaxg.class, zzaxgVar);
    }

    private zzaxg() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔉ\u0000\u0002ᔁ\u0001", new Object[]{"zzb", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzaxg();
        }
        zzaxe zzaxeVar = null;
        if (i2 == 4) {
            return new zzaxf(zzaxeVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
