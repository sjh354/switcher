package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zze extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zze zzb;
    private int zzf;
    private zzm zzg;
    private zzg zzh;
    private byte zzi = 2;

    static {
        zze zzeVar = new zze();
        zzb = zzeVar;
        zzbff.zzan(zze.class, zzeVar);
        zza = zzbff.zzac(zzam.zzj(), zzeVar, zzeVar, null, 47497405, zzbip.MESSAGE, zze.class);
    }

    private zze() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0002\u0001ᐉ\u0000\u0003ᐉ\u0001", new Object[]{"zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zze();
        }
        zzc zzcVar = null;
        if (i2 == 4) {
            return new zzd(zzcVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
