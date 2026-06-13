package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzakp extends zzbff implements zzbgt {
    private static final zzakp zza;
    private int zzb;
    private int zzh;
    private zzaky zzi;
    private byte zzt = 2;
    private String zzf = "";
    private String zzg = "";
    private String zzj = "";
    private zzbfp zzk = zzaj();
    private int zzl = 4369;
    private String zzm = "";
    private String zzn = "";
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private zzbfp zzr = zzaj();
    private String zzs = "";

    static {
        zzakp zzakpVar = new zzakp();
        zza = zzakpVar;
        zzbff.zzan(zzakp.class, zzakpVar);
    }

    private zzakp() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzt);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u000e\u0000\u0001\u0001\u000f\u000e\u0000\u0002\u0003\u0001ဈ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004ᐉ\u0003\u0006Л\u0007ဌ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fဈ\n\rဈ\u0004\u000eЛ\u000fဈ\u000b", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", "zzk", zzarv.class, "zzl", zzaks.zzc(), "zzm", "zzn", "zzo", "zzp", "zzq", "zzj", "zzr", zzayv.class, "zzs"});
        }
        if (i2 == 3) {
            return new zzakp();
        }
        zzakn zzaknVar = null;
        if (i2 == 4) {
            return new zzako(zzaknVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzt = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
