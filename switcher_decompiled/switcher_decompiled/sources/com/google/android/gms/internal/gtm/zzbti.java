package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbti extends zzbfb implements zzbgt {
    private static final zzbti zza;
    private long zzA;
    private int zzB;
    private zzsu zzC;
    private zzta zzD;
    private boolean zzE;
    private boolean zzF;
    private int zzG;
    private zzbtk zzH;
    private zztw zzI;
    private int zzN;
    private zzbom zzO;
    private long zzP;
    private int zzf;
    private int zzg;
    private long zzh;
    private long zzj;
    private int zzk;
    private byte zzQ = 2;
    private String zzi = "";
    private zzbfp zzl = zzaj();
    private String zzm = "";
    private String zzn = "";
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";
    private String zzs = "";
    private String zzt = "";
    private String zzu = "";
    private String zzv = "";
    private String zzw = "";
    private String zzx = "";
    private String zzy = "";
    private String zzz = "";
    private String zzJ = "";
    private String zzK = "";
    private String zzL = "";
    private zzbfp zzM = zzbff.zzaj();

    static {
        zzbti zzbtiVar = new zzbti();
        zza = zzbtiVar;
        zzbff.zzan(zzbti.class, zzbtiVar);
    }

    private zzbti() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzQ);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001#\u0000\u0002\u0001&#\u0000\u0002\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0003\u0004ဈ\u0004\u0005ဈ\u0005\u0006ဈ\b\u0007ဈ\t\bဈ\u0006\tဈ\u0007\nဈ\n\u000bဈ\u000b\fဈ\f\rဈ\r\u000eဈ\u000e\u000fဈ\u000f\u0010ဈ\u0010\u0011ဈ\u0011\u0012ဂ\u0002\u0013င\u0013\u0014ဇ\u0016\u0016ဇ\u0017\u0017ဌ\u0018\u0018ဉ\u0019\u0019ဉ\u001a\u001aဈ\u001b\u001bဈ\u001c\u001cဈ\u001d\u001f\u001a ဉ\u0014!င\u001e\"\u001b#ဉ\u001f$ဃ %ဉ\u0015&ဂ\u0012", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzk", "zzm", "zzn", "zzq", "zzr", "zzo", "zzp", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzj", "zzB", "zzE", "zzF", "zzG", zzbwq.zzb(), "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzC", "zzN", "zzl", zzbth.class, "zzO", "zzP", "zzD", "zzA"});
        }
        if (i2 == 3) {
            return new zzbti();
        }
        zzbte zzbteVar = null;
        if (i2 == 4) {
            return new zzbtf(zzbteVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzQ = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
