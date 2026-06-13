package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzxy extends zzbff implements zzbgt {
    private static final zzxy zza;
    private int zzb;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private int zzj;
    private byte zzk = 2;
    private zzbfp zzi = zzaj();

    static {
        zzxy zzxyVar = new zzxy();
        zza = zzxyVar;
        zzbff.zzan(zzxy.class, zzxyVar);
    }

    private zzxy() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001င\u0000\u0002င\u0001\u0003ဇ\u0002\u0004Л\u0005င\u0003", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", zzvx.class, "zzj"});
        }
        if (i2 == 3) {
            return new zzxy();
        }
        zzxw zzxwVar = null;
        if (i2 == 4) {
            return new zzxx(zzxwVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
