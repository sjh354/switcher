package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaoi extends zzbff implements zzbgt {
    private static final zzaoi zza;
    private int zzb;
    private zzamq zzf;
    private int zzg;
    private double zzh;
    private double zzi;
    private double zzj;
    private double zzk;
    private byte zzm = 2;
    private String zzl = "";

    static {
        zzaoi zzaoiVar = new zzaoi();
        zza = zzaoiVar;
        zzbff.zzan(zzaoi.class, zzaoiVar);
    }

    private zzaoi() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0001\u0001ᐉ\u0000\u0002ဌ\u0001\u0003က\u0002\u0004က\u0003\u0005က\u0004\u0006က\u0005\u0007ဈ\u0006", new Object[]{"zzb", "zzf", "zzg", zzaog.zzc(), "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i2 == 3) {
            return new zzaoi();
        }
        zzaod zzaodVar = null;
        if (i2 == 4) {
            return new zzaoh(zzaodVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
