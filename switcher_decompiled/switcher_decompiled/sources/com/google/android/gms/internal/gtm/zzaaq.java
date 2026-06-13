package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaaq extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzaaq zzb;
    private int zzf;
    private zzwr zzg;
    private byte zzi = 2;
    private zzbfp zzh = zzaj();

    static {
        zzaaq zzaaqVar = new zzaaq();
        zzb = zzaaqVar;
        zzbff.zzan(zzaaq.class, zzaaqVar);
        zza = zzbff.zzac(zzbmd.zze(), zzaaqVar, zzaaqVar, null, 98510069, zzbip.MESSAGE, zzaaq.class);
    }

    private zzaaq() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0002\u0001ᐉ\u0000\u0002Л", new Object[]{"zzf", "zzg", "zzh", zzye.class});
        }
        if (i2 == 3) {
            return new zzaaq();
        }
        zzaao zzaaoVar = null;
        if (i2 == 4) {
            return new zzaap(zzaaoVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
