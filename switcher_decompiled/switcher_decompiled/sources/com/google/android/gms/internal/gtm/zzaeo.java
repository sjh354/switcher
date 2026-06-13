package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaeo extends zzbff implements zzbgt {
    private static final zzaeo zza;
    private byte zzf = 2;
    private zzbfp zzb = zzaj();

    static {
        zzaeo zzaeoVar = new zzaeo();
        zza = zzaeoVar;
        zzbff.zzan(zzaeo.class, zzaeoVar);
    }

    private zzaeo() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzf);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zzb", zzasg.class});
        }
        if (i2 == 3) {
            return new zzaeo();
        }
        zzaem zzaemVar = null;
        if (i2 == 4) {
            return new zzaen(zzaemVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzf = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
