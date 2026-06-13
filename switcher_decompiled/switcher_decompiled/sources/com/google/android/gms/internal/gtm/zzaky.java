package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaky extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzaky zzb;
    private int zzf;
    private double zzg;
    private byte zzi = 2;
    private int zzh = 800;

    static {
        zzaky zzakyVar = new zzaky();
        zzb = zzakyVar;
        zzbff.zzan(zzaky.class, zzakyVar);
        zza = zzbff.zzac(zzbmd.zze(), zzakyVar, zzakyVar, null, 15303159, zzbip.MESSAGE, zzaky.class);
    }

    private zzaky() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔀ\u0000\u0002ဌ\u0001", new Object[]{"zzf", "zzg", "zzh", zzakx.zzc()});
        }
        if (i2 == 3) {
            return new zzaky();
        }
        zzakt zzaktVar = null;
        if (i2 == 4) {
            return new zzaku(zzaktVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
