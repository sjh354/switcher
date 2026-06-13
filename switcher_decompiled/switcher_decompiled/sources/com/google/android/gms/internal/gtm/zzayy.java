package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzayy extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzayy zzb;
    private byte zzg = 2;
    private zzbfp zzf = zzaj();

    static {
        zzayy zzayyVar = new zzayy();
        zzb = zzayyVar;
        zzbff.zzan(zzayy.class, zzayyVar);
        zza = zzbff.zzac(zzbmd.zze(), zzayyVar, zzayyVar, null, 14251185, zzbip.MESSAGE, zzayy.class);
    }

    private zzayy() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zzf", zzayv.class});
        }
        if (i2 == 3) {
            return new zzayy();
        }
        zzayw zzaywVar = null;
        if (i2 == 4) {
            return new zzayx(zzaywVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
