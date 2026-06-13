package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzban extends zzbfb implements zzbgt {
    private static final zzban zza;
    private int zzf;
    private double zzg;
    private float zzh;
    private long zzi;
    private long zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private boolean zzn;
    private int zzq;
    private int zzr;
    private long zzs;
    private int zzt;
    private long zzu;
    private byte zzv = 2;
    private String zzo = "";
    private zzbbw zzp = zzbbw.zzb;

    static {
        zzban zzbanVar = new zzban();
        zza = zzbanVar;
        zzbff.zzan(zzban.class, zzbanVar);
    }

    private zzban() {
    }

    public static zzban zzc() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzv);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u000f\u0000\u0001\u0001\u0012\u000f\u0000\u0000\u0000\u0001က\u0000\u0002ခ\u0001\u0003ဂ\u0002\u0004ဃ\u0003\u0005င\u0004\u0006စ\u0005\u0007ဆ\u0006\bဇ\u0007\tဈ\b\fည\t\rဋ\n\u000fဍ\u000b\u0010ဎ\f\u0011ဏ\r\u0012တ\u000e", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu"});
        }
        if (i2 == 3) {
            return new zzban();
        }
        zzbaj zzbajVar = null;
        if (i2 == 4) {
            return new zzbam(zzbajVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzv = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
