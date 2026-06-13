package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbva extends zzbff implements zzbgt {
    private static final zzbva zza;
    private int zzb;
    private int zzq;
    private boolean zzs;
    private int zzt;
    private int zzu;
    private boolean zzv;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";
    private String zzn = "";
    private String zzo = "";
    private String zzp = "";
    private String zzr = "";

    static {
        zzbva zzbvaVar = new zzbva();
        zza = zzbvaVar;
        zzbff.zzan(zzbva.class, zzbvaVar);
    }

    private zzbva() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0011\u0000\u0001\u0001\u0012\u0011\u0000\u0000\u0000\u0001ဈ\u0001\u0002ဈ\u0002\u0003ဈ\u0006\u0004ဈ\u0007\u0005ဈ\b\u0006ဈ\t\u0007ဈ\n\bဌ\u000b\tဈ\u0000\u000bဈ\f\fဇ\r\rဌ\u000e\u000eဌ\u000f\u000fဇ\u0010\u0010ဈ\u0003\u0011ဈ\u0005\u0012ဈ\u0004", new Object[]{"zzb", "zzg", "zzh", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", zzbuv.zzb(), "zzf", "zzr", "zzs", "zzt", zztq.zzc(), "zzu", zzbuz.zzb(), "zzv", "zzi", "zzk", "zzj"});
        }
        if (i2 == 3) {
            return new zzbva();
        }
        zzbte zzbteVar = null;
        if (i2 == 4) {
            return new zzbuw(zzbteVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
