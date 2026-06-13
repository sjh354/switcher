package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbcp extends zzbfb implements zzbgt {
    private static final zzbcp zza;
    private int zzf;
    private boolean zzg;
    private byte zzi = 2;
    private zzbfp zzh = zzbhc.zze();

    static {
        zzbcp zzbcpVar = new zzbcp();
        zza = zzbcpVar;
        zzbff.zzan(zzbcp.class, zzbcpVar);
    }

    private zzbcp() {
    }

    public static zzbcp zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return new zzbhd(zza, "\u0001\u0002\u0000\u0001\u0001ϧ\u0002\u0000\u0001\u0001\u0001ဇ\u0000ϧЛ", new Object[]{"zzf", "zzg", "zzh", zzbei.class});
        }
        if (i2 == 3) {
            return new zzbcp();
        }
        zzbcl zzbclVar = null;
        if (i2 == 4) {
            return new zzbco(zzbclVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
