package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzawq extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzbfm zzb = new zzbfm<Integer, zzawx>() { // from class: com.google.android.gms.internal.gtm.zzawq.1
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzawx zzb(Integer num) {
            throw null;
        }
    };
    private static final zzawq zzf;
    private int zzg;
    private zzbaw zzh;
    private zzbai zzi;
    private int zzj;
    private boolean zzm;
    private int zzp;
    private zzana zzq;
    private byte zzs = 2;
    private zzbfp zzk = zzaj();
    private zzbfp zzl = zzbff.zzaj();
    private zzbfl zzn = zzah();
    private zzbfp zzo = zzaj();
    private zzbfp zzr = zzaj();

    static {
        zzawq zzawqVar = new zzawq();
        zzf = zzawqVar;
        zzbff.zzan(zzawq.class, zzawqVar);
        zza = zzbff.zzac(zzbmd.zze(), zzawqVar, zzawqVar, null, 12773310, zzbip.MESSAGE, zzawq.class);
    }

    private zzawq() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzs);
        }
        if (i2 == 2) {
            return zzam(zzf, "\u0001\u000b\u0000\u0001\u0001Ǵ\u000b\u0000\u0005\u0003\u0001ဉ\u0000\u0002ဌ\u0002\u0003Л\u0004\u001a\u0005ဇ\u0003\u0007\u001e\b\u001b\tᐉ\u0001\nဌ\u0004\u000bЛǴဉ\u0005", new Object[]{"zzg", "zzh", "zzj", zzaxa.zzc(), "zzk", zzapo.class, "zzl", "zzm", "zzn", zzawx.zzc(), "zzo", zzaqx.class, "zzi", "zzp", zzawu.zzc(), "zzr", zzamq.class, "zzq"});
        }
        if (i2 == 3) {
            return new zzawq();
        }
        zzawp zzawpVar = null;
        if (i2 == 4) {
            return new zzawr(zzawpVar);
        }
        if (i2 == 5) {
            return zzf;
        }
        this.zzs = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
