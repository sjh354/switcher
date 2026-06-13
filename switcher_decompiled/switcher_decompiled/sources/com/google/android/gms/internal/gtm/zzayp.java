package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzayp extends zzbff implements zzbgt {
    private static final zzayp zza;
    private int zzb;
    private int zzg;
    private int zzh;
    private int zzi;
    private byte zzk = 2;
    private zzbfp zzf = zzaj();
    private zzbfp zzj = zzaj();

    static {
        zzayp zzaypVar = new zzayp();
        zza = zzaypVar;
        zzbff.zzan(zzayp.class, zzaypVar);
    }

    private zzayp() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0005\u0000\u0001\u0001\u0007\u0005\u0000\u0002\u0002\u0001Л\u0003ဌ\u0000\u0004ဆ\u0001\u0005ဆ\u0002\u0007Л", new Object[]{"zzb", "zzf", zzamq.class, "zzg", zzayo.zzc(), "zzh", "zzi", "zzj", zzamq.class});
        }
        if (i2 == 3) {
            return new zzayp();
        }
        zzayk zzaykVar = null;
        if (i2 == 4) {
            return new zzayl(zzaykVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
