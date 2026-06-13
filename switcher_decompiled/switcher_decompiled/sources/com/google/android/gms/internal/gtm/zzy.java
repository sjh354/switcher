package com.google.android.gms.internal.gtm;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzy extends zzbff implements zzbgt {
    private static final zzy zza;
    private byte zzh = 2;
    private zzbfp zzb = zzaj();
    private zzbfp zzf = zzaj();
    private zzbfp zzg = zzaj();

    static {
        zzy zzyVar = new zzy();
        zza = zzyVar;
        zzbff.zzan(zzy.class, zzyVar);
    }

    private zzy() {
    }

    public static zzy zzc() {
        return zza;
    }

    public final List zzd() {
        return this.zzg;
    }

    public final List zze() {
        return this.zzf;
    }

    public final List zzf() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0003\u0002\u0001Л\u0002Л\u0003\u001b", new Object[]{"zzb", zzam.class, "zzf", zzam.class, "zzg", zzw.class});
        }
        if (i2 == 3) {
            return new zzy();
        }
        zzn zznVar = null;
        if (i2 == 4) {
            return new zzx(zznVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
