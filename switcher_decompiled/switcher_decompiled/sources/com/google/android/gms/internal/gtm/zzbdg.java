package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbdg extends zzbfb implements zzbgt {
    private static final zzbdg zza;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private byte zzm = 2;
    private String zzk = "";
    private zzbfp zzl = zzbhc.zze();

    static {
        zzbdg zzbdgVar = new zzbdg();
        zza = zzbdgVar;
        zzbff.zzan(zzbdg.class, zzbdgVar);
    }

    private zzbdg() {
    }

    public static zzbdg zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i2 == 2) {
            return new zzbhd(zza, "\u0001\u0006\u0000\u0001\u0001ϧ\u0006\u0000\u0001\u0001\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0007ဇ\u0003\nဈ\u0004ϧЛ", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzbei.class});
        }
        if (i2 == 3) {
            return new zzbdg();
        }
        zzbcl zzbclVar = null;
        if (i2 == 4) {
            return new zzbdf(zzbclVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
