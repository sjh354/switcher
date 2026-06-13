package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzabb extends zzbff implements zzbgt {
    private static final zzabb zza;
    private int zzb;
    private boolean zzf;
    private zzaaq zzh;
    private byte zzk = 2;
    private zzbfp zzg = zzaj();
    private zzbfp zzi = zzaj();
    private zzbfp zzj = zzaj();

    static {
        zzabb zzabbVar = new zzabb();
        zza = zzabbVar;
        zzbff.zzan(zzabb.class, zzabbVar);
    }

    private zzabb() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0003\u0001Л\u0002ᐉ\u0001\u0003\u001b\u0004ဇ\u0000\u0005Л", new Object[]{"zzb", "zzg", zzamq.class, "zzh", "zzj", zzabc.class, "zzf", "zzi", zzaav.class});
        }
        if (i2 == 3) {
            return new zzabb();
        }
        zzaau zzaauVar = null;
        if (i2 == 4) {
            return new zzaba(zzaauVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
