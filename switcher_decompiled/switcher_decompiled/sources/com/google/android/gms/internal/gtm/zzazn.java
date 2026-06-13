package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzazn extends zzbff implements zzbgt {
    private static final zzazn zza;
    private int zzb;
    private zzbac zzf;
    private int zzg;
    private String zzh = "";
    private boolean zzi;
    private boolean zzj;

    static {
        zzazn zzaznVar = new zzazn();
        zza = zzaznVar;
        zzbff.zzan(zzazn.class, zzaznVar);
    }

    private zzazn() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဈ\u0002\u0004ဇ\u0003\u0005ဇ\u0004", new Object[]{"zzb", "zzf", "zzg", zzaks.zzc(), "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzazn();
        }
        zzazl zzazlVar = null;
        if (i2 == 4) {
            return new zzazm(zzazlVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
