package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaih extends zzbff implements zzbgt {
    private static final zzaih zza;
    private int zzb;
    private zzahd zzf;
    private zzaez zzg;
    private String zzh = "";

    static {
        zzaih zzaihVar = new zzaih();
        zza = zzaihVar;
        zzbff.zzan(zzaih.class, zzaihVar);
    }

    private zzaih() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0004\r\u0003\u0000\u0000\u0000\u0004ဉ\u0000\fဉ\u0001\rဈ\u0002", new Object[]{"zzb", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzaih();
        }
        zzaif zzaifVar = null;
        if (i2 == 4) {
            return new zzaig(zzaifVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
