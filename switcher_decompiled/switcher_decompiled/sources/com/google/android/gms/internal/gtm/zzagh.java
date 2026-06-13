package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzagh extends zzbff implements zzbgt {
    private static final zzagh zza;
    private int zzb;
    private zzayj zzg;
    private zzayj zzh;
    private boolean zzi;
    private byte zzj = 2;
    private zzbfp zzf = zzaj();

    static {
        zzagh zzaghVar = new zzagh();
        zza = zzaghVar;
        zzbff.zzan(zzagh.class, zzaghVar);
    }

    private zzagh() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0001\u0001Л\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဇ\u0002", new Object[]{"zzb", "zzf", zzxy.class, "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzagh();
        }
        zzagf zzagfVar = null;
        if (i2 == 4) {
            return new zzagg(zzagfVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
