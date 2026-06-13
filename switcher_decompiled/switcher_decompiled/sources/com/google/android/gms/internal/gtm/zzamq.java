package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzamq extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzamq zzb;
    private int zzf;
    private long zzg;
    private long zzh;
    private zzbmd zzi;
    private byte zzj = 2;

    static {
        zzamq zzamqVar = new zzamq();
        zzb = zzamqVar;
        zzbff.zzan(zzamq.class, zzamqVar);
        zza = zzbff.zzac(zzbmd.zze(), zzamqVar, zzamqVar, null, 13258261, zzbip.MESSAGE, zzamq.class);
    }

    private zzamq() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔅ\u0000\u0002ᔅ\u0001\u0003ᐉ\u0002", new Object[]{"zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzamq();
        }
        zzamo zzamoVar = null;
        if (i2 == 4) {
            return new zzamp(zzamoVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
