package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbju extends zzbff implements zzbgt {
    private static final zzbfm zza = new zzbfm<Integer, zzbke>() { // from class: com.google.android.gms.internal.gtm.zzbju.1
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzbke zzb(Integer num) {
            throw null;
        }
    };
    private static final zzbju zzb;
    private zzbfl zzf = zzah();

    static {
        zzbju zzbjuVar = new zzbju();
        zzb = zzbjuVar;
        zzbff.zzan(zzbju.class, zzbjuVar);
    }

    private zzbju() {
    }

    public static zzbju zze() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzf", zzbke.zzc()});
        }
        if (i2 == 3) {
            return new zzbju();
        }
        zzbjr zzbjrVar = null;
        if (i2 == 4) {
            return new zzbjv(zzbjrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
