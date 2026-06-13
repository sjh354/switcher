package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzai extends zzbff implements zzbgt {
    private static final zzai zza;
    private int zzb;
    private zzam zzg;
    private zzy zzh;
    private byte zzi = 2;
    private String zzf = "";

    static {
        zzai zzaiVar = new zzai();
        zza = zzaiVar;
        zzbff.zzan(zzai.class, zzaiVar);
    }

    private zzai() {
    }

    public final zzy zza() {
        zzy zzyVar = this.zzh;
        return zzyVar == null ? zzy.zzc() : zzyVar;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return (this.zzb & 4) != 0;
    }

    public final boolean zzf() {
        return (this.zzb & 1) != 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0002\u0001ဈ\u0000\u0002ᐉ\u0001\u0003ᐉ\u0002", new Object[]{"zzb", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzai();
        }
        zzn zznVar = null;
        if (i2 == 4) {
            return new zzah(zznVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
