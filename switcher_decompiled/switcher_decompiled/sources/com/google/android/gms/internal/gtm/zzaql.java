package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaql extends zzbff implements zzbgt {
    private static final zzaql zza;
    private int zzb;
    private long zzf;
    private zzamq zzg;
    private double zzh;
    private float zzi;
    private byte zzj = 2;

    static {
        zzaql zzaqlVar = new zzaql();
        zza = zzaqlVar;
        zzbff.zzan(zzaql.class, zzaqlVar);
    }

    private zzaql() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ဂ\u0000\u0002ᐉ\u0001\u0003က\u0002\u0004ခ\u0003", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzaql();
        }
        zzaqj zzaqjVar = null;
        if (i2 == 4) {
            return new zzaqk(zzaqjVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
