package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbai extends zzbff implements zzbgt {
    private static final zzbai zza;
    private int zzb;
    private int zzf;
    private long zzg;
    private boolean zzi;
    private int zzl;
    private byte zzn = 2;
    private String zzh = "";
    private int zzj = 1;
    private String zzk = "";
    private String zzm = "";

    static {
        zzbai zzbaiVar = new zzbai();
        zza = zzbaiVar;
        zzbff.zzan(zzbai.class, zzbaiVar);
    }

    private zzbai() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzn);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0002\u0001ᔄ\u0000\u0002ᔃ\u0001\u0003ဈ\u0002\u0004ဇ\u0003\u0005ဈ\u0005\u0006ဌ\u0006\u0007ဈ\u0007\bင\u0004", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", "zzk", "zzl", zzbah.zzc(), "zzm", "zzj"});
        }
        if (i2 == 3) {
            return new zzbai();
        }
        zzbad zzbadVar = null;
        if (i2 == 4) {
            return new zzbae(zzbadVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzn = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
