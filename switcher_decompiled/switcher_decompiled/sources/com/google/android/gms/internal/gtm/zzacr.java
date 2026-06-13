package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzacr extends zzbff implements zzbgt {
    private static final zzacr zza;
    private int zzb;
    private Object zzg;
    private int zzh;
    private int zzf = 0;
    private byte zzi = 2;

    static {
        zzacr zzacrVar = new zzacr();
        zza = zzacrVar;
        zzbff.zzan(zzacr.class, zzacrVar);
    }

    private zzacr() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0001\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ဌ\u0000\u0002ᐼ\u0000", new Object[]{"zzg", "zzf", "zzb", "zzh", zzacq.zzc(), zzayv.class});
        }
        if (i2 == 3) {
            return new zzacr();
        }
        zzacm zzacmVar = null;
        if (i2 == 4) {
            return new zzacn(zzacmVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
