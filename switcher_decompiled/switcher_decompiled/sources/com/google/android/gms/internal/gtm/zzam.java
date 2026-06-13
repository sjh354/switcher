package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzam extends zzbfb implements zzbgt {
    private static final zzbfm zza = new zzbfm<Integer, zzaq>() { // from class: com.google.android.gms.internal.gtm.zzam.1
        @Override // com.google.android.gms.internal.gtm.zzbfm
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public zzaq zzb(Integer num) {
            zzaq zzaqVarZzb = zzaq.zzb(num.intValue());
            return zzaqVarZzb == null ? zzaq.ESCAPE_HTML : zzaqVarZzb;
        }
    };
    private static final zzam zzf;
    private int zzg;
    private long zzo;
    private boolean zzp;
    private boolean zzs;
    private byte zzt = 2;
    private int zzh = 1;
    private String zzi = "";
    private zzbfp zzj = zzaj();
    private zzbfp zzk = zzaj();
    private zzbfp zzl = zzaj();
    private String zzm = "";
    private String zzn = "";
    private zzbfp zzq = zzaj();
    private zzbfl zzr = zzah();

    static {
        zzam zzamVar = new zzam();
        zzf = zzamVar;
        zzbff.zzan(zzam.class, zzamVar);
    }

    private zzam() {
    }

    static /* synthetic */ void zzA(zzam zzamVar, Iterable iterable) {
        zzamVar.zzar();
        zzbay.zzS(iterable, zzamVar.zzl);
    }

    static /* synthetic */ void zzC(zzam zzamVar, String str) {
        str.getClass();
        zzamVar.zzg |= 4;
        zzamVar.zzm = str;
    }

    static /* synthetic */ void zzD(zzam zzamVar, String str) {
        str.getClass();
        zzamVar.zzg |= 8;
        zzamVar.zzn = str;
    }

    static /* synthetic */ void zzE(zzam zzamVar, String str) {
        str.getClass();
        zzamVar.zzg |= 2;
        zzamVar.zzi = str;
    }

    static /* synthetic */ void zzF(zzam zzamVar, long j) {
        zzamVar.zzg |= 16;
        zzamVar.zzo = j;
    }

    static /* synthetic */ void zzG(zzam zzamVar, boolean z) {
        zzamVar.zzg |= 32;
        zzamVar.zzp = z;
    }

    static /* synthetic */ void zzH(zzam zzamVar, zzam zzamVar2) {
        zzamVar2.getClass();
        zzbfp zzbfpVar = zzamVar.zzq;
        if (!zzbfpVar.zzc()) {
            zzamVar.zzq = zzbff.zzak(zzbfpVar);
        }
        zzamVar.zzq.add(zzamVar2);
    }

    static /* synthetic */ void zzJ(zzam zzamVar, Iterable iterable) {
        zzbfl zzbflVar = zzamVar.zzr;
        if (!zzbflVar.zzc()) {
            int size = zzbflVar.size();
            zzamVar.zzr = zzbflVar.zzd(size == 0 ? 10 : size + size);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzamVar.zzr.zzh(((zzaq) it.next()).zza());
        }
    }

    static /* synthetic */ void zzL(zzam zzamVar, boolean z) {
        zzamVar.zzg |= 64;
        zzamVar.zzs = z;
    }

    static /* synthetic */ void zzM(zzam zzamVar, zzam zzamVar2) {
        zzamVar2.getClass();
        zzamVar.zzap();
        zzamVar.zzj.add(zzamVar2);
    }

    static /* synthetic */ void zzN(zzam zzamVar, Iterable iterable) {
        zzamVar.zzap();
        zzbay.zzS(iterable, zzamVar.zzj);
    }

    private final void zzap() {
        zzbfp zzbfpVar = this.zzj;
        if (zzbfpVar.zzc()) {
            return;
        }
        this.zzj = zzbff.zzak(zzbfpVar);
    }

    private final void zzaq() {
        zzbfp zzbfpVar = this.zzk;
        if (zzbfpVar.zzc()) {
            return;
        }
        this.zzk = zzbff.zzak(zzbfpVar);
    }

    private final void zzar() {
        zzbfp zzbfpVar = this.zzl;
        if (zzbfpVar.zzc()) {
            return;
        }
        this.zzl = zzbff.zzak(zzbfpVar);
    }

    public static zzan zzg() {
        return (zzan) zzf.zzZ();
    }

    public static zzam zzj() {
        return zzf;
    }

    static /* synthetic */ void zzu(zzam zzamVar, zzat zzatVar) {
        zzamVar.zzh = zzatVar.zza();
        zzamVar.zzg |= 1;
    }

    static /* synthetic */ void zzw(zzam zzamVar, zzam zzamVar2) {
        zzamVar2.getClass();
        zzamVar.zzaq();
        zzamVar.zzk.add(zzamVar2);
    }

    static /* synthetic */ void zzx(zzam zzamVar, Iterable iterable) {
        zzamVar.zzaq();
        zzbay.zzS(iterable, zzamVar.zzk);
    }

    static /* synthetic */ void zzz(zzam zzamVar, zzam zzamVar2) {
        zzamVar2.getClass();
        zzamVar.zzar();
        zzamVar.zzl.add(zzamVar2);
    }

    public final boolean zzO() {
        return this.zzp;
    }

    public final boolean zzP() {
        return this.zzs;
    }

    public final int zza() {
        return this.zzj.size();
    }

    public final int zzc() {
        return this.zzk.size();
    }

    public final int zzd() {
        return this.zzl.size();
    }

    public final int zze() {
        return this.zzq.size();
    }

    public final long zzf() {
        return this.zzo;
    }

    public final zzat zzh() {
        zzat zzatVarZzb = zzat.zzb(this.zzh);
        return zzatVarZzb == null ? zzat.STRING : zzatVarZzb;
    }

    public final zzam zzk(int i) {
        return (zzam) this.zzj.get(i);
    }

    public final zzam zzl(int i) {
        return (zzam) this.zzk.get(i);
    }

    public final zzam zzm(int i) {
        return (zzam) this.zzl.get(i);
    }

    public final zzam zzn(int i) {
        return (zzam) this.zzq.get(i);
    }

    public final String zzo() {
        return this.zzn;
    }

    public final String zzp() {
        return this.zzm;
    }

    public final String zzq() {
        return this.zzi;
    }

    public final List zzr() {
        return new zzbfn(this.zzr, zza);
    }

    public final List zzs() {
        return this.zzj;
    }

    public final List zzt() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzt);
        }
        if (i2 == 2) {
            return zzam(zzf, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0005\u0005\u0001ᔌ\u0000\u0002ဈ\u0001\u0003Л\u0004Л\u0005Л\u0006ဈ\u0002\u0007ဈ\u0003\bဂ\u0004\tဇ\u0006\n\u001e\u000bЛ\fဇ\u0005", new Object[]{"zzg", "zzh", zzat.zzc(), "zzi", "zzj", zzam.class, "zzk", zzam.class, "zzl", zzam.class, "zzm", "zzn", "zzo", "zzs", "zzr", zzaq.zzc(), "zzq", zzam.class, "zzp"});
        }
        if (i2 == 3) {
            return new zzam();
        }
        zzal zzalVar = null;
        if (i2 == 4) {
            return new zzan(zzalVar);
        }
        if (i2 == 5) {
            return zzf;
        }
        this.zzt = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
