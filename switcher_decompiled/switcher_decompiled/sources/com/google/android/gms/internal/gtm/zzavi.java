package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzavi extends zzbff implements zzbgt {
    private static final zzavi zza;
    private zzana zzA;
    private int zzB;
    private zzana zzC;
    private int zzD;
    private boolean zzE;
    private boolean zzH;
    private zzana zzJ;
    private zzana zzM;
    private zzaky zzN;
    private zzaky zzO;
    private zzana zzQ;
    private zzaqf zzU;
    private boolean zzV;
    private float zzY;
    private zzana zzZ;
    private float zzaa;
    private float zzab;
    private float zzac;
    private zzzc zzaf;
    private int zzb;
    private int zzf;
    private zzamq zzg;
    private zzana zzk;
    private zzamq zzl;
    private float zzp;
    private zzana zzq;
    private float zzv;
    private zzana zzw;
    private zzana zzy;
    private byte zzag = 2;
    private zzbfp zzh = zzaj();
    private zzbfp zzi = zzaj();
    private int zzj = 17;
    private zzbfp zzm = zzaj();
    private zzbfp zzn = zzaj();
    private boolean zzo = true;
    private boolean zzr = true;
    private zzbfp zzs = zzaj();
    private zzbfp zzt = zzaj();
    private zzbfp zzu = zzaj();
    private int zzx = 1;
    private int zzz = 1;
    private zzbfp zzF = zzaj();
    private zzbfp zzG = zzaj();
    private int zzI = 1;
    private zzbfk zzK = zzag();
    private int zzL = 3;
    private int zzP = 1;
    private int zzR = 1;
    private int zzS = 1;
    private int zzT = 1;
    private int zzW = 1;
    private zzbfp zzX = zzaj();
    private zzbfp zzad = zzaj();
    private zzbfp zzae = zzaj();

    static {
        zzavi zzaviVar = new zzavi();
        zza = zzaviVar;
        zzbff.zzan(zzavi.class, zzaviVar);
    }

    private zzavi() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzag);
        }
        if (i2 == 2) {
            return zzam(zza, "\u00014\u0000\u0002\u0001Ǿ4\u0000\r\u000f\u0001ᔉ\u0000\u0002Л\u0003ဌ\u0001\u0004ᐉ\u0003\u0005Л\u0006Л\bဇ\u0004\tခ\u0005\nခ\b\fဌ\f\rဌ\n\u000eဌ\u000e\u000fဌ\u0010\u0010ဇ\u0011\u0011Л\u0012Л\u0013ဇ\u0012\u0015ဌ\u0013\u0016\u0013\u0017ဌ\u0015\u0018ᐉ\u0017\u0019ᐉ\u0018\u001aဌ\u0019\u001bဌ\u001b\u001cဌ\u001c\u001dဌ\u001d\u001eဇ\u001f\u001fဌ  Л\"Л#ခ!$ဇ\u0007%ᐉ\u001e&ခ%'Л(Л)\u001b*\u001b+\u001b,ခ#-ခ$dᐉ&Ǵဉ\u0002ǵဉ\u0006Ƕဉ\tǷဉ\u000bǸဉ\rǹဉ\u000fǻဉ\u0014Ǽဉ\u0016ǽဉ\u001aǾဉ\"", new Object[]{"zzb", "zzf", "zzg", "zzh", zzamq.class, "zzj", zzaus.zzc(), "zzl", "zzm", zzasg.class, "zzn", zzapa.class, "zzo", "zzp", "zzv", "zzz", zzave.zzc(), "zzx", zzaup.zzc(), "zzB", zzavb.zzc(), "zzD", zzavh.zzc(), "zzE", "zzF", zzamq.class, "zzG", zzane.class, "zzH", "zzI", zzatz.zzc(), "zzK", "zzL", zzaum.zzc(), "zzN", "zzO", "zzP", zzauj.zzc(), "zzR", zzauc.zzc(), "zzS", zzauf.zzc(), "zzT", zzauv.zzc(), "zzV", "zzW", zzauy.zzc(), "zzi", zzatw.class, "zzX", zzatn.class, "zzY", "zzr", "zzU", "zzac", "zzad", zzavk.class, "zzae", zzamq.class, "zzs", zzwl.class, "zzt", zzwl.class, "zzu", zzwl.class, "zzaa", "zzab", "zzaf", "zzk", "zzq", "zzw", "zzy", "zzA", "zzC", "zzJ", "zzM", "zzQ", "zzZ"});
        }
        if (i2 == 3) {
            return new zzavi();
        }
        zzatm zzatmVar = null;
        if (i2 == 4) {
            return new zzaug(zzatmVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzag = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
