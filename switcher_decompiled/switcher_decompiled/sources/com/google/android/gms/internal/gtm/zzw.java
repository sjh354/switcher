package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzw extends zzbff implements zzbgt {
    private static final zzw zza;
    private int zzb;
    private long zzg;
    private boolean zzi;
    private long zzj;
    private String zzf = "";
    private long zzh = 2147483647L;

    static {
        zzw zzwVar = new zzw();
        zza = zzwVar;
        zzbff.zzan(zzw.class, zzwVar);
    }

    private zzw() {
    }

    public final long zza() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဇ\u0003\u0005ဂ\u0004", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzw();
        }
        zzn zznVar = null;
        if (i2 == 4) {
            return new zzv(zznVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final long zzc() {
        return this.zzh;
    }

    public final long zzd() {
        return this.zzg;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return this.zzi;
    }

    public final boolean zzh() {
        return (this.zzb & 1) != 0;
    }
}
