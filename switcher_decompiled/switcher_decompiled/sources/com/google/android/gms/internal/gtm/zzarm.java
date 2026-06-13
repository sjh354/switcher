package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzarm extends zzbff implements zzbgt {
    private static final zzarm zza;
    private int zzb;
    private int zzf;
    private float zzg;
    private float zzh;
    private String zzi = "";
    private zzana zzj;

    static {
        zzarm zzarmVar = new zzarm();
        zza = zzarmVar;
        zzbff.zzan(zzarm.class, zzarmVar);
    }

    private zzarm() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0005\u0000\u0001\u0001Ǵ\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ခ\u0001\u0004ခ\u0002\u0005ဈ\u0003Ǵဉ\u0004", new Object[]{"zzb", "zzf", zzarl.zzc(), "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzarm();
        }
        zzarh zzarhVar = null;
        if (i2 == 4) {
            return new zzari(zzarhVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
