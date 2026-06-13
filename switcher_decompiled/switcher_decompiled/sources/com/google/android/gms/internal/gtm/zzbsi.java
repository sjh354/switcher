package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbsi extends zzbfb implements zzbgt {
    public static final zzbfd zza;
    private static final zzbsi zzf;
    private int zzg;
    private int zzk;
    private long zzn;
    private long zzo;
    private long zzp;
    private byte zzv = 2;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzl = "en";
    private long zzm = -1;
    private zzbfp zzq = zzaj();
    private String zzr = "";
    private zzbfp zzs = zzaj();
    private zzbfo zzt = zzai();
    private zzbfp zzu = zzaj();

    static {
        zzbsi zzbsiVar = new zzbsi();
        zzf = zzbsiVar;
        zzbff.zzan(zzbsi.class, zzbsiVar);
        zza = zzbff.zzac(zzbmd.zze(), zzbsiVar, zzbsiVar, null, 43918061, zzbip.MESSAGE, zzbsi.class);
    }

    private zzbsi() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzv);
        }
        if (i2 == 2) {
            return zzam(zzf, "\u0001\u000e\u0000\u0001\u0001\u0011\u000e\u0000\u0004\u0002\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0005ဌ\u0003\u0006ဈ\u0004\u0007ဂ\u0005\bဂ\u0006\tဂ\u0007\nဂ\b\u000bЛ\fဈ\t\rЛ\u000f\u0015\u0011\u001b", new Object[]{"zzg", "zzh", "zzi", "zzj", "zzk", zzbru.zzb(), "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", zzbrv.class, "zzr", "zzs", zzbrv.class, "zzt", "zzu", zzblc.class});
        }
        if (i2 == 3) {
            return new zzbsi();
        }
        zzbrq zzbrqVar = null;
        if (i2 == 4) {
            return new zzbrr(zzbrqVar);
        }
        if (i2 == 5) {
            return zzf;
        }
        this.zzv = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
