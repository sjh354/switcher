package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzary extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzary zzb;
    private int zzf;
    private zzaqi zzg;
    private zzaqi zzh;
    private byte zzi = 2;

    static {
        zzary zzaryVar = new zzary();
        zzb = zzaryVar;
        zzbff.zzan(zzary.class, zzaryVar);
        zza = zzbff.zzac(zzbmd.zze(), zzaryVar, zzaryVar, null, 26764887, zzbip.MESSAGE, zzary.class);
    }

    private zzary() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔉ\u0000\u0002ᔉ\u0001", new Object[]{"zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzary();
        }
        zzarw zzarwVar = null;
        if (i2 == 4) {
            return new zzarx(zzarwVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
