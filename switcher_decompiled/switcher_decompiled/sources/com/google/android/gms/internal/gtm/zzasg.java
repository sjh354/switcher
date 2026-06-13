package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzasg extends zzbff implements zzbgt {
    private static final zzbfm zza = new zzbfm<Integer, zzast>() { // from class: com.google.android.gms.internal.gtm.zzasg.1
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzast zzb(Integer num) {
            throw null;
        }
    };
    private static final zzbfm zzb = new zzbfm<Integer, zzwo>() { // from class: com.google.android.gms.internal.gtm.zzasg.2
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzwo zzb(Integer num) {
            throw null;
        }
    };
    private static final zzasg zzf;
    private int zzg;
    private int zzk;
    private zzamq zzl;
    private zzayj zzm;
    private int zzn;
    private zzamq zzo;
    private zzahk zzp;
    private zzbmd zzr;
    private zzana zzs;
    private byte zzt = 2;
    private zzbfp zzh = zzaj();
    private int zzi = 17;
    private zzbfl zzj = zzah();
    private zzbfl zzq = zzah();

    static {
        zzasg zzasgVar = new zzasg();
        zzf = zzasgVar;
        zzbff.zzan(zzasg.class, zzasgVar);
    }

    private zzasg() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzt);
        }
        if (i2 == 2) {
            return zzam(zzf, "\u0001\f\u0000\u0001\u0001Ǵ\f\u0000\u0003\u0004\u0001Л\u0002ဌ\u0000\u0003\u001e\u0004ဌ\u0001\u0005ဉ\u0003\u0006ᐉ\u0007\u0007ᐉ\u0002\bဌ\u0004\tᐉ\u0005\nဉ\u0006\u000b\u001eǴဉ\b", new Object[]{"zzg", "zzh", zzamq.class, "zzi", zzasq.zzc(), "zzj", zzast.zzc(), "zzk", zzasn.zzc(), "zzm", "zzr", "zzl", "zzn", zzask.zzc(), "zzo", "zzp", "zzq", zzwo.zzc(), "zzs"});
        }
        if (i2 == 3) {
            return new zzasg();
        }
        zzasf zzasfVar = null;
        if (i2 == 4) {
            return new zzash(zzasfVar);
        }
        if (i2 == 5) {
            return zzf;
        }
        this.zzt = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
