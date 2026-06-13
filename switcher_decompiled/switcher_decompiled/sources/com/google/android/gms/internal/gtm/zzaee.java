package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaee extends zzbff implements zzbgt {
    private static final zzaee zza;
    private int zzb;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzaee zzaeeVar = new zzaee();
        zza = zzaeeVar;
        zzbff.zzan(zzaee.class, zzaeeVar);
    }

    private zzaee() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzaee();
        }
        zzacm zzacmVar = null;
        if (i2 == 4) {
            return new zzaed(zzacmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
