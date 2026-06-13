package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaea extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzaea zzb;
    private int zzf;
    private zzaec zzi;
    private byte zzj = 2;
    private zzbfp zzg = zzaj();
    private zzbfp zzh = zzaj();

    static {
        zzaea zzaeaVar = new zzaea();
        zzb = zzaeaVar;
        zzbff.zzan(zzaea.class, zzaeaVar);
        zza = zzbff.zzac(zzbmd.zze(), zzaeaVar, zzaeaVar, null, 49520153, zzbip.MESSAGE, zzaea.class);
    }

    private zzaea() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0002\u0001Л\u0002Л\u0003ဉ\u0000", new Object[]{"zzf", "zzg", zzayy.class, "zzh", zzaef.class, "zzi"});
        }
        if (i2 == 3) {
            return new zzaea();
        }
        zzacm zzacmVar = null;
        if (i2 == 4) {
            return new zzadz(zzacmVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
