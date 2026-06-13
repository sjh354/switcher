package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzait extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzait zzb;
    private int zzf;
    private zzbmd zzk;
    private zzait zzl;
    private zzana zzm;
    private byte zzn = 2;
    private String zzg = "";
    private zzbfp zzh = zzaj();
    private zzbfp zzi = zzaj();
    private zzbfp zzj = zzaj();

    static {
        zzait zzaitVar = new zzait();
        zzb = zzaitVar;
        zzbff.zzan(zzait.class, zzaitVar);
        zza = zzbff.zzac(zzbmd.zze(), zzaitVar, zzaitVar, null, 12208774, zzbip.MESSAGE, zzait.class);
    }

    private zzait() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzn);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0007\u0000\u0001\u0002Ǵ\u0007\u0000\u0003\u0004\u0002Л\u0005Л\u0006\u001b\bᐉ\u0001\nဈ\u0000\u000bᐉ\u0002Ǵဉ\u0003", new Object[]{"zzf", "zzh", zzaiz.class, "zzj", zzaiz.class, "zzi", zzajc.class, "zzk", "zzg", "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zzait();
        }
        zzair zzairVar = null;
        if (i2 == 4) {
            return new zzais(zzairVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzn = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
