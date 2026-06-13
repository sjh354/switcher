package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbmk extends zzbff implements zzbgt {
    private static final zzbfm zza = new zzbfm<Integer, zzbmj>() { // from class: com.google.android.gms.internal.gtm.zzbmk.1
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzbmj zzb(Integer num) {
            throw null;
        }
    };
    private static final zzbmk zzb;
    private zzbfl zzf = zzah();

    static {
        zzbmk zzbmkVar = new zzbmk();
        zzb = zzbmkVar;
        zzbff.zzan(zzbmk.class, zzbmkVar);
    }

    private zzbmk() {
    }

    public static zzbmk zze() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzf", zzbmj.zzb()});
        }
        if (i2 == 3) {
            return new zzbmk();
        }
        AnonymousClass1 anonymousClass1 = null;
        if (i2 == 4) {
            return new zzbml(anonymousClass1);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
