package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbix extends zzbff implements zzbgt {
    private static final zzbfm zza = new zzbfm<Integer, zzbjc>() { // from class: com.google.android.gms.internal.gtm.zzbix.1
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzbjc zzb(Integer num) {
            throw null;
        }
    };
    private static final zzbfm zzb = new zzbfm<Integer, zzbjf>() { // from class: com.google.android.gms.internal.gtm.zzbix.2
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzbjf zzb(Integer num) {
            throw null;
        }
    };
    private static final zzbix zzf;
    private zzbfp zzg = zzbff.zzaj();
    private zzbfl zzh = zzah();
    private zzbfl zzi = zzah();
    private zzbfl zzj = zzah();
    private zzbfp zzk = zzbff.zzaj();

    static {
        zzbix zzbixVar = new zzbix();
        zzf = zzbixVar;
        zzbff.zzan(zzbix.class, zzbixVar);
    }

    private zzbix() {
    }

    public static zzbix zze() {
        return zzf;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzf, "\u0001\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0005\u0000\u0001\u001a\u0002\u001e\u0003\u0016\u0004\u001a\u0005,", new Object[]{"zzg", "zzh", zzbjc.zzb(), "zzj", "zzk", "zzi", zzbjf.zzb()});
        }
        if (i2 == 3) {
            return new zzbix();
        }
        zzbiu zzbiuVar = null;
        if (i2 == 4) {
            return new zzbiy(zzbiuVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzf;
    }
}
