package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzamn extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzamn zzb;
    private int zzB;
    private boolean zzC;
    private zzamq zzE;
    private double zzF;
    private zzarg zzG;
    private zzaih zzH;
    private zzbmd zzI;
    private zzakm zzJ;
    private zzakm zzK;
    private zzamh zzO;
    private zzaat zzP;
    private zzazq zzR;
    private zzawl zzS;
    private zzaoc zzT;
    private zzajv zzU;
    private zzatf zzV;
    private zzavi zzW;
    private zzant zzX;
    private zzaer zzY;
    private zzakp zzZ;
    private zzazt zzaB;
    private zzxv zzaC;
    private zzamq zzaD;
    private zzamq zzaE;
    private zzafe zzaG;
    private zzzs zzaH;
    private zzaeo zzaI;
    private zzyz zzaK;
    private zzagn zzaL;
    private zzwf zzaM;
    private zzaql zzaa;
    private zzayp zzab;
    private zzagv zzac;
    private zzays zzad;
    private zzakj zzae;
    private zzakb zzaf;
    private zzaan zzag;
    private zzavn zzah;
    private zzale zzai;
    private zzatl zzaj;
    private zzalq zzak;
    private zzaly zzal;
    private zzasw zzam;
    private zzapj zzan;
    private zzaxi zzao;
    private zzalk zzap;
    private zzanz zzaq;
    private zzalh zzar;
    private zzavt zzas;
    private zzavz zzat;
    private zzawi zzau;
    private zzapg zzav;
    private zzahv zzaw;
    private zzabb zzax;
    private zzyw zzaz;
    private int zzf;
    private int zzg;
    private zzamq zzh;
    private zzary zzi;
    private zzary zzj;
    private float zzk;
    private zzabp zzr;
    private zzaqo zzs;
    private zzaqi zzv;
    private byte zzaN = 2;
    private zzbfp zzl = zzaj();
    private zzbfp zzm = zzaj();
    private zzbfp zzn = zzaj();
    private zzbfp zzo = zzaj();
    private zzbfp zzp = zzaj();
    private zzbfp zzq = zzaj();
    private zzbfp zzt = zzaj();
    private zzbfp zzu = zzaj();
    private zzbfp zzw = zzaj();
    private zzbfp zzx = zzaj();
    private zzbfp zzy = zzaj();
    private zzbfp zzz = zzaj();
    private zzbfp zzA = zzaj();
    private zzbfp zzD = zzaj();
    private zzbfp zzL = zzaj();
    private zzbfp zzM = zzaj();
    private zzbfp zzN = zzaj();
    private zzbfp zzQ = zzaj();
    private zzbfp zzay = zzaj();
    private zzbfp zzaA = zzaj();
    private zzbfp zzaF = zzaj();
    private zzbfp zzaJ = zzaj();

    static {
        zzamn zzamnVar = new zzamn();
        zzb = zzamnVar;
        zzbff.zzan(zzamn.class, zzamnVar);
        zza = zzbff.zzac(zzbmd.zze(), zzamnVar, zzamnVar, null, 1205891, zzbip.MESSAGE, zzamn.class);
    }

    private zzamn() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzaN);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001T\u0000\u0002\u0001ĬT\u0000\u00168\u0001ᔉ\u0000\u0002ᐉ\u0001\u0003ခ\u0003\u0004Л\u0005Л\u0006Л\u0007Л\bЛ\tЛ\nᐉ\u0006\fЛ\rЛ\u000eЛ\u000fဌ\u0007\u0010ဇ\b\u0011Л\u0013ᐉ\t\u0014က\n\u0018ဉ\u000b\u0019ᐉ\r\u001aဉ\u000e\u001bဉ\u000f\u001c\u001b\u001eဉ\u0016\u001fᐉ\u0017 ᐉ\u0018!ᐉ\u001a\"ᐉ\u001b*ᐉ\u001c+ᐉ\u001f,ᐉ -ᐉ\".ဉ#0ဉ$1ဉ%3ᐉ&4ᐉ'5ᐉ(7ᐉ)8ᐉ*;ᐉ\u0002<ᐉ+=ဉ,>ဉ-?ဉ.@ဉ/BЛCᐉ\u0010Dᐉ0EЛFဉ\u0012Gဉ\fIЛJဉ\u0013Kဉ\u0014Lᐉ\u0015OЛPᐉ\u0019Rᐉ2Sᐉ\u0005T\u001bU\u001bVЛWᐉ\u001dXЛY\u001bZဉ\u0004[ဉ4\\ᐉ5]ᐉ6^ᐉ7_Л`ᐉ8aဉ9bဉ1cᐉ:dЛeᐉ;fᐉ<gᐉ\u0011hဉ=iᐉ\u001ejᐉ!Ĭᐉ3", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzk", "zzl", zzapo.class, "zzm", zzait.class, "zzn", zzaqi.class, "zzo", zzaqr.class, "zzp", zzaqo.class, "zzt", zzamq.class, "zzv", "zzw", zzawo.class, "zzy", zzase.class, "zzu", zzamq.class, "zzB", zzamm.zzc(), "zzC", "zzD", zzaij.class, "zzE", "zzF", "zzG", "zzI", "zzJ", "zzK", "zzL", zzank.class, "zzV", "zzW", "zzX", "zzZ", "zzaa", "zzab", "zzae", "zzaf", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzj", "zzaq", "zzar", "zzas", "zzat", "zzau", "zzM", zzajq.class, "zzO", "zzav", "zzQ", zzayv.class, "zzR", "zzH", "zzay", zzaze.class, "zzS", "zzT", "zzU", "zzN", zzvv.class, "zzY", "zzax", "zzs", "zzaA", zzara.class, "zzA", zzagk.class, "zzx", zzyb.class, "zzac", "zzz", zzamq.class, "zzq", zzagq.class, "zzr", "zzaB", "zzaC", "zzaD", "zzaE", "zzaF", zzamq.class, "zzaG", "zzaH", "zzaw", "zzaI", "zzaJ", zzamq.class, "zzaK", "zzaL", "zzP", "zzaM", "zzad", "zzag", "zzaz"});
        }
        if (i2 == 3) {
            return new zzamn();
        }
        zzami zzamiVar = null;
        if (i2 == 4) {
            return new zzamj(zzamiVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzaN = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
