package com.google.android.gms.internal.gtm;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzag extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzag zzb;
    private int zzf;
    private int zzj;
    private int zzl;
    private int zzm;
    private zzbfl zzg = zzah();
    private zzbfl zzh = zzah();
    private zzbfl zzi = zzah();
    private zzbfl zzk = zzah();

    static {
        zzag zzagVar = new zzag();
        zzb = zzagVar;
        zzbff.zzan(zzag.class, zzagVar);
        zza = zzbff.zzac(zzam.zzj(), zzagVar, zzagVar, null, 101, zzbip.MESSAGE, zzag.class);
    }

    private zzag() {
    }

    public final int zza() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0004\u0000\u0001\u0016\u0002\u0016\u0003\u0016\u0004င\u0000\u0005\u0016\u0006င\u0001\u0007င\u0002", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zzag();
        }
        zzn zznVar = null;
        if (i2 == 4) {
            return new zzaf(zznVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final int zzc() {
        return this.zzh.size();
    }

    public final int zzd() {
        return this.zzi.size();
    }

    public final List zzf() {
        return this.zzg;
    }

    public final List zzg() {
        return this.zzh;
    }

    public final List zzh() {
        return this.zzi;
    }

    public final List zzi() {
        return this.zzk;
    }
}
