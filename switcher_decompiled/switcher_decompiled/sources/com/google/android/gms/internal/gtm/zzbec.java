package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbec extends zzbfb implements zzbgt {
    private static final zzbec zza;
    private byte zzg = 2;
    private zzbfp zzf = zzbhc.zze();

    static {
        zzbec zzbecVar = new zzbec();
        zza = zzbecVar;
        zzbff.zzan(zzbec.class, zzbecVar);
    }

    private zzbec() {
    }

    public static zzbec zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return new zzbhd(zza, "\u0001\u0001\u0000\u0000ϧϧ\u0001\u0000\u0001\u0001ϧЛ", new Object[]{"zzf", zzbei.class});
        }
        if (i2 == 3) {
            return new zzbec();
        }
        zzbcl zzbclVar = null;
        if (i2 == 4) {
            return new zzbeb(zzbclVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
