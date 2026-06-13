package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzamu extends zzbff implements zzbgt {
    public static final zzbfd zza;
    private static final zzamu zzb;
    private byte zzg = 2;
    private zzbfp zzf = zzaj();

    static {
        zzamu zzamuVar = new zzamu();
        zzb = zzamuVar;
        zzbff.zzan(zzamu.class, zzamuVar);
        zza = zzbff.zzac(zzbmd.zze(), zzamuVar, zzamuVar, null, 16709385, zzbip.MESSAGE, zzamu.class);
    }

    private zzamu() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0001\u0000\u0000\u0003\u0003\u0001\u0000\u0001\u0001\u0003Л", new Object[]{"zzf", zzamq.class});
        }
        if (i2 == 3) {
            return new zzamu();
        }
        zzams zzamsVar = null;
        if (i2 == 4) {
            return new zzamt(zzamsVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
