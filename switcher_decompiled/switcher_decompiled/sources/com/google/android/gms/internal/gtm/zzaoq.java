package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaoq extends zzbff implements zzbgt {
    private static final zzaoq zza;
    private int zzb;
    private zzamq zzf;
    private int zzg;
    private zzaok zzh;
    private zzxj zzi;
    private boolean zzl;
    private byte zzm = 2;
    private zzbfp zzj = zzaj();
    private String zzk = "";

    static {
        zzaoq zzaoqVar = new zzaoq();
        zza = zzaoqVar;
        zzbff.zzan(zzaoq.class, zzaoqVar);
    }

    private zzaoq() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0002\u0001ᐉ\u0000\u0002င\u0001\u0003ဉ\u0002\u0004Л\u0005ဈ\u0004\u0006ဉ\u0003\u0007ဇ\u0005", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzj", zzaoi.class, "zzk", "zzi", "zzl"});
        }
        if (i2 == 3) {
            return new zzaoq();
        }
        zzaod zzaodVar = null;
        if (i2 == 4) {
            return new zzaop(zzaodVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
