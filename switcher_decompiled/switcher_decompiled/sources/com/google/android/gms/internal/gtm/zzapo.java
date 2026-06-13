package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzapo extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzbfm zzb = new zzbfm<Integer, zzaps>() { // from class: com.google.android.gms.internal.gtm.zzapo.1
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzaps zzb(Integer num) {
            throw null;
        }
    };
    private static final zzapo zzf;
    private int zzg;
    private zzana zzm;
    private zzbmd zzn;
    private byte zzo = 2;
    private String zzh = "";
    private String zzi = "";
    private zzbfl zzj = zzah();
    private String zzk = "";
    private String zzl = "";

    static {
        zzapo zzapoVar = new zzapo();
        zzf = zzapoVar;
        zzbff.zzan(zzapo.class, zzapoVar);
        zza = zzbff.zzac(zzbmd.zze(), zzapoVar, zzapoVar, null, 308676116, zzbip.MESSAGE, zzapo.class);
    }

    private zzapo() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzo);
        }
        if (i2 == 2) {
            return zzam(zzf, "\u0001\u0007\u0000\u0001\u0001Ǵ\u0007\u0000\u0001\u0002\u0001ᔈ\u0000\u0002ဈ\u0001\u0003\u001e\u0005ဈ\u0002\u0006ဈ\u0003\u000fᐉ\u0005Ǵဉ\u0004", new Object[]{"zzg", "zzh", "zzi", "zzj", zzaps.zzc(), "zzk", "zzl", "zzn", "zzm"});
        }
        if (i2 == 3) {
            return new zzapo();
        }
        zzapn zzapnVar = null;
        if (i2 == 4) {
            return new zzapp(zzapnVar);
        }
        if (i2 == 5) {
            return zzf;
        }
        this.zzo = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
