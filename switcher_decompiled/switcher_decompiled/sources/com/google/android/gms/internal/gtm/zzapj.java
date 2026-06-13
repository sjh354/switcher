package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzapj extends zzbff implements zzbgt {
    private static final zzapj zza;
    private int zzb;
    private byte zzh = 2;
    private zzbfp zzf = zzaj();
    private String zzg = "";

    static {
        zzapj zzapjVar = new zzapj();
        zza = zzapjVar;
        zzbff.zzan(zzapj.class, zzapjVar);
    }

    private zzapj() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0001\u0001Л\u0002ဈ\u0000", new Object[]{"zzb", "zzf", zzapm.class, "zzg"});
        }
        if (i2 == 3) {
            return new zzapj();
        }
        zzaph zzaphVar = null;
        if (i2 == 4) {
            return new zzapi(zzaphVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
