package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzk extends zzbff implements zzbgt {
    private static final zzk zza;
    private int zzb;
    private zzam zzl;
    private byte zzm = 2;
    private zzbfp zzf = zzaj();
    private zzbfp zzg = zzaj();
    private zzbfp zzh = zzaj();
    private zzbfp zzi = zzaj();
    private zzbfp zzj = zzaj();
    private zzbfp zzk = zzaj();

    static {
        zzk zzkVar = new zzk();
        zza = zzkVar;
        zzbff.zzan(zzk.class, zzkVar);
    }

    private zzk() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0006\u0007\u0001Л\u0002Л\u0003Л\u0004Л\u0005Л\u0006Л\u0007ᐉ\u0000", new Object[]{"zzb", "zzf", zzg.class, "zzg", zzg.class, "zzh", zzg.class, "zzi", zzg.class, "zzj", zzg.class, "zzk", zzg.class, "zzl"});
        }
        if (i2 == 3) {
            return new zzk();
        }
        zzc zzcVar = null;
        if (i2 == 4) {
            return new zzj(zzcVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
