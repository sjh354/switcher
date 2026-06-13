package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbui extends zzbff implements zzbgt {
    private static final zzbui zza;
    private int zzb;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";
    private int zzm;
    private int zzn;

    static {
        zzbui zzbuiVar = new zzbui();
        zza = zzbuiVar;
        zzbff.zzan(zzbui.class, zzbuiVar);
    }

    private zzbui() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bင\u0007\tင\b", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
        }
        if (i2 == 3) {
            return new zzbui();
        }
        zzbte zzbteVar = null;
        if (i2 == 4) {
            return new zzbuh(zzbteVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
