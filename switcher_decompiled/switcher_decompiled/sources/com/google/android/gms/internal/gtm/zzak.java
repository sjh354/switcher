package com.google.android.gms.internal.gtm;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzak extends zzbff implements zzbgt {
    private static final zzak zza;
    private int zzb;
    private zzac zzg;
    private byte zzi = 2;
    private zzbfp zzf = zzaj();
    private String zzh = "";

    static {
        zzak zzakVar = new zzak();
        zza = zzakVar;
        zzbff.zzan(zzak.class, zzakVar);
    }

    private zzak() {
    }

    public static zzaj zzd() {
        return (zzaj) zza.zzZ();
    }

    public static zzak zzf() {
        return zza;
    }

    public static zzak zzg(byte[] bArr, zzbep zzbepVar) throws zzbfs {
        return (zzak) zzbff.zzaf(zza, bArr, zzbepVar);
    }

    static /* synthetic */ void zzk(zzak zzakVar, zzac zzacVar) {
        zzacVar.getClass();
        zzakVar.zzg = zzacVar;
        zzakVar.zzb |= 1;
    }

    static /* synthetic */ void zzl(zzak zzakVar, String str) {
        str.getClass();
        zzakVar.zzb |= 2;
        zzakVar.zzh = str;
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final zzac zzc() {
        zzac zzacVar = this.zzg;
        return zzacVar == null ? zzac.zzk() : zzacVar;
    }

    public final String zzh() {
        return this.zzh;
    }

    public final List zzi() {
        return this.zzf;
    }

    public final boolean zzm() {
        return (this.zzb & 1) != 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0002\u0001Л\u0002ᐉ\u0000\u0003ဈ\u0001", new Object[]{"zzb", "zzf", zzai.class, "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzak();
        }
        zzn zznVar = null;
        if (i2 == 4) {
            return new zzaj(zznVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
