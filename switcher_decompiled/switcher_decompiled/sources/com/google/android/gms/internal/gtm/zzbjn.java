package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbjn extends zzbff implements zzbgt {
    private static final zzbjn zza;
    private int zzb;
    private int zzf;
    private String zzg = "*";

    static {
        zzbjn zzbjnVar = new zzbjn();
        zza = zzbjnVar;
        zzbff.zzan(zzbjn.class, zzbjnVar);
    }

    private zzbjn() {
    }

    public static zzbjn zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001", new Object[]{"zzb", "zzf", zzbjq.zzb(), "zzg"});
        }
        if (i2 == 3) {
            return new zzbjn();
        }
        zzbjl zzbjlVar = null;
        if (i2 == 4) {
            return new zzbjm(zzbjlVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
