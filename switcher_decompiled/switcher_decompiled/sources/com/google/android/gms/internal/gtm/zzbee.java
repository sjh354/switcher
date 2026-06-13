package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbee extends zzbfb implements zzbgt {
    private static final zzbee zza;
    private int zzf;
    private boolean zzg;
    private boolean zzi;
    private boolean zzj;
    private byte zzl = 2;
    private double zzh = -1.0d;
    private zzbfp zzk = zzbhc.zze();

    static {
        zzbee zzbeeVar = new zzbee();
        zza = zzbeeVar;
        zzbff.zzan(zzbee.class, zzbeeVar);
    }

    private zzbee() {
    }

    public static zzbee zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i2 == 2) {
            return new zzbhd(zza, "\u0001\u0005\u0000\u0001\u0010ϧ\u0005\u0000\u0001\u0001\u0010က\u0001\u0011ဇ\u0002\u0014ဇ\u0000!ဇ\u0003ϧЛ", new Object[]{"zzf", "zzh", "zzi", "zzg", "zzj", "zzk", zzbei.class});
        }
        if (i2 == 3) {
            return new zzbee();
        }
        zzbcl zzbclVar = null;
        if (i2 == 4) {
            return new zzbed(zzbclVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
