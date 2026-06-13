package com.google.android.gms.internal.gtm;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzae extends zzbff implements zzbgt {
    private static final zzae zza;
    private zzbfl zzb = zzah();
    private zzbfl zzf = zzah();
    private zzbfl zzg = zzah();
    private zzbfl zzh = zzah();
    private zzbfl zzi = zzah();
    private zzbfl zzj = zzah();
    private zzbfl zzk = zzah();
    private zzbfl zzl = zzah();
    private zzbfl zzm = zzah();
    private zzbfl zzn = zzah();

    static {
        zzae zzaeVar = new zzae();
        zza = zzaeVar;
        zzbff.zzan(zzae.class, zzaeVar);
    }

    private zzae() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\n\u0000\u0000\u0001\n\n\u0000\n\u0000\u0001\u0016\u0002\u0016\u0003\u0016\u0004\u0016\u0005\u0016\u0006\u0016\u0007\u0016\b\u0016\t\u0016\n\u0016", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
        }
        if (i2 == 3) {
            return new zzae();
        }
        zzn zznVar = null;
        if (i2 == 4) {
            return new zzad(zznVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final List zzc() {
        return this.zzk;
    }

    public final List zzd() {
        return this.zzm;
    }

    public final List zze() {
        return this.zzg;
    }

    public final List zzf() {
        return this.zzi;
    }

    public final List zzg() {
        return this.zzf;
    }

    public final List zzh() {
        return this.zzb;
    }

    public final List zzi() {
        return this.zzl;
    }

    public final List zzj() {
        return this.zzn;
    }

    public final List zzk() {
        return this.zzh;
    }

    public final List zzl() {
        return this.zzj;
    }
}
