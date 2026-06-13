package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbea extends zzbfb implements zzbgt {
    private static final zzbea zza;
    private boolean zzA;
    private int zzB;
    private int zzf;
    private int zzg;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private int zzn;
    private int zzo;
    private int zzp;
    private boolean zzr;
    private boolean zzs;
    private boolean zzv;
    private byte zzD = 2;
    private double zzh = -1.0d;
    private int zzl = 256;
    private int zzm = 256;
    private String zzq = "";
    private String zzt = "";
    private String zzu = "";
    private long zzw = -1;
    private long zzx = -1;
    private int zzy = 1;
    private int zzz = 2;
    private zzbfp zzC = zzbhc.zze();

    static {
        zzbea zzbeaVar = new zzbea();
        zza = zzbeaVar;
        zzbff.zzan(zzbea.class, zzbeaVar);
    }

    private zzbea() {
    }

    public static zzbea zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzD);
        }
        if (i2 == 2) {
            return new zzbhd(zza, "\u0001\u0017\u0000\u0001\u0007ϧ\u0017\u0000\u0001\u0001\u0007ဌ\u0000\bက\u0001\tဇ\u0002\nဇ\u0003\u000bဏ\u0005\fဏ\u0006\rဌ\u0007\u000fဌ\b\u0011ဌ\t\u0013ဈ\n\u0014ဇ\u000b\u0015ဇ\f\u0016ဈ\r\u0017ဈ\u000e\u0018ဂ\u0010\u0019ဂ\u0011\u001aဇ\u0004\u001bဌ\u0013\u001cဌ\u0012\u001dဇ\u000f!ဇ\u0014\"ဌ\u0015ϧЛ", new Object[]{"zzf", "zzg", zzbdt.zzc(), "zzh", "zzi", "zzj", "zzl", "zzm", "zzn", zzbdw.zzc(), "zzo", zzbdk.zzc(), "zzp", zzbdk.zzc(), "zzq", "zzr", "zzs", "zzt", "zzu", "zzw", "zzx", "zzk", "zzz", zzbdq.zzc(), "zzy", zzbdz.zzc(), "zzv", "zzA", "zzB", zzbdn.zzc(), "zzC", zzbei.class});
        }
        if (i2 == 3) {
            return new zzbea();
        }
        zzbcl zzbclVar = null;
        if (i2 == 4) {
            return new zzbdh(zzbclVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzD = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
