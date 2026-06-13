package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzamh extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzamh zzb;
    private int zzf;
    private boolean zzg;
    private int zzh;
    private long zzi;
    private boolean zzj;
    private int zzk;
    private zzaky zzl;
    private zzaky zzm;
    private zzaky zzn;
    private byte zzo = 2;

    static {
        zzamh zzamhVar = new zzamh();
        zzb = zzamhVar;
        zzbff.zzan(zzamh.class, zzamhVar);
        zza = zzbff.zzac(zzbmd.zze(), zzamhVar, zzamhVar, null, 1321489, zzbip.MESSAGE, zzamh.class);
    }

    private zzamh() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzo);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\b\u0000\u0001\u0001\u000b\b\u0000\u0000\u0003\u0001ဇ\u0003\u0002ဇ\u0000\u0003ဌ\u0001\u0005ဌ\u0004\u0006ᐉ\u0005\u0007ᐉ\u0006\tဂ\u0002\u000bᐉ\u0007", new Object[]{"zzf", "zzj", "zzg", "zzh", zzamg.zzc(), "zzk", zzamd.zzc(), "zzl", "zzm", "zzi", "zzn"});
        }
        if (i2 == 3) {
            return new zzamh();
        }
        zzalz zzalzVar = null;
        if (i2 == 4) {
            return new zzama(zzalzVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzo = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
