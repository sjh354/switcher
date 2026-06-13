package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzazq extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzazq zzb;
    private zzbfp zzf = zzaj();

    static {
        zzazq zzazqVar = new zzazq();
        zzb = zzazqVar;
        zzbff.zzan(zzazq.class, zzazqVar);
        zza = zzbff.zzac(zzbmd.zze(), zzazqVar, zzazqVar, null, 20497290, zzbip.MESSAGE, zzazq.class);
    }

    private zzazq() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzf", zzazn.class});
        }
        if (i2 == 3) {
            return new zzazq();
        }
        zzazo zzazoVar = null;
        if (i2 == 4) {
            return new zzazp(zzazoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
