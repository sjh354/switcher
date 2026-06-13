package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbnj extends zzbff implements zzbgt {
    private static final zzbnj zza;
    private int zzb;
    private zzboc zzk;
    private byte zzl = 2;
    private zzbfp zzf = zzaj();
    private zzbfp zzg = zzaj();
    private zzbfp zzh = zzaj();
    private String zzi = "";
    private zzbfp zzj = zzaj();

    static {
        zzbnj zzbnjVar = new zzbnj();
        zza = zzbnjVar;
        zzbff.zzan(zzbnj.class, zzbnjVar);
    }

    private zzbnj() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0006\u0000\u0001\u0002\u0007\u0006\u0000\u0004\u0001\u0002Л\u0003\u001b\u0004\u001b\u0005ဈ\u0000\u0006\u001b\u0007ဉ\u0001", new Object[]{"zzb", "zzf", zzbqb.class, "zzg", zzuf.class, "zzh", zzbny.class, "zzi", "zzj", zzbnv.class, "zzk"});
        }
        if (i2 == 3) {
            return new zzbnj();
        }
        zzbnh zzbnhVar = null;
        if (i2 == 4) {
            return new zzbni(zzbnhVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
