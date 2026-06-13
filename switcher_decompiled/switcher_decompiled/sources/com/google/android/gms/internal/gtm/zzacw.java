package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzacw extends zzbff implements zzbgt {
    private static final zzacw zza;
    private int zzb;
    private Object zzg;
    private zzaqx zzj;
    private zzacr zzk;
    private int zzl;
    private int zzf = 0;
    private byte zzm = 2;
    private zzbfp zzh = zzaj();
    private zzbfp zzi = zzaj();

    static {
        zzacw zzacwVar = new zzacw();
        zza = zzacwVar;
        zzbff.zzan(zzacw.class, zzacwVar);
    }

    private zzacw() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0006\u0001\u0001\u0001\u0006\u0006\u0000\u0002\u0001\u0001\u001b\u0002\u001b\u0003ဉ\u0000\u0004ᐉ\u0001\u0005ဌ\u0002\u0006ြ\u0000", new Object[]{"zzg", "zzf", "zzb", "zzh", zzaee.class, "zzi", zzady.class, "zzj", "zzk", "zzl", zzacv.zzc(), zzadp.class});
        }
        if (i2 == 3) {
            return new zzacw();
        }
        zzacm zzacmVar = null;
        if (i2 == 4) {
            return new zzacs(zzacmVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
