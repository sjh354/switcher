package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzvn extends zzbff implements zzbgt {
    private static final zzvn zza;
    private int zzb;
    private zzvi zzg;
    private byte zzi = 2;
    private int zzf = 1;
    private String zzh = "";

    static {
        zzvn zzvnVar = new zzvn();
        zza = zzvnVar;
        zzbff.zzan(zzvn.class, zzvnVar);
    }

    private zzvn() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ဈ\u0002\u0002င\u0000\u0003ᐉ\u0001", new Object[]{"zzb", "zzh", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzvn();
        }
        zzve zzveVar = null;
        if (i2 == 4) {
            return new zzvm(zzveVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
