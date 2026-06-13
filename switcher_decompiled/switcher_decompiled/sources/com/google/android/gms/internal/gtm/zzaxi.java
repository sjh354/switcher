package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaxi extends zzbff implements zzbgt {
    private static final zzaxi zza;
    private byte zzg = 2;
    private zzbfp zzb = zzaj();
    private zzbfl zzf = zzah();

    static {
        zzaxi zzaxiVar = new zzaxi();
        zza = zzaxiVar;
        zzbff.zzan(zzaxi.class, zzaxiVar);
    }

    private zzaxi() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0002\u0000\u0000\u0007\b\u0002\u0000\u0002\u0001\u0007Л\b\u0016", new Object[]{"zzb", zzaxg.class, "zzf"});
        }
        if (i2 == 3) {
            return new zzaxi();
        }
        zzaxe zzaxeVar = null;
        if (i2 == 4) {
            return new zzaxh(zzaxeVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
