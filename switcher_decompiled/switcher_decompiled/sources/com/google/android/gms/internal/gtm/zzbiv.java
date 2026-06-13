package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbiv extends zzbff implements zzbgt {
    private static final zzbfm zza = new zzbfm<Integer, zzbjc>() { // from class: com.google.android.gms.internal.gtm.zzbiv.1
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzbjc zzb(Integer num) {
            throw null;
        }
    };
    private static final zzbfm zzb = new zzbfm<Integer, zzbjf>() { // from class: com.google.android.gms.internal.gtm.zzbiv.2
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzbjf zzb(Integer num) {
            throw null;
        }
    };
    private static final zzbiv zzf;
    private zzbfp zzg = zzbff.zzaj();
    private zzbfl zzh = zzah();
    private zzbfl zzi = zzah();

    static {
        zzbiv zzbivVar = new zzbiv();
        zzf = zzbivVar;
        zzbff.zzan(zzbiv.class, zzbivVar);
    }

    private zzbiv() {
    }

    public static zzbiv zze() {
        return zzf;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzf, "\u0001\u0003\u0000\u0000\u0001\u0005\u0003\u0000\u0003\u0000\u0001\u001a\u0002\u001e\u0005,", new Object[]{"zzg", "zzh", zzbjc.zzb(), "zzi", zzbjf.zzb()});
        }
        if (i2 == 3) {
            return new zzbiv();
        }
        zzbiu zzbiuVar = null;
        if (i2 == 4) {
            return new zzbiw(zzbiuVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzf;
    }
}
