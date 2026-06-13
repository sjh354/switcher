package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzro extends zzbff implements zzbgt {
    private static final zzro zza;
    private int zzb;
    private long zzf;
    private zzac zzg;
    private zzak zzh;
    private byte zzi = 2;

    static {
        zzro zzroVar = new zzro();
        zza = zzroVar;
        zzbff.zzan(zzro.class, zzroVar);
    }

    private zzro() {
    }

    public static zzrn zze() {
        return (zzrn) zza.zzZ();
    }

    public static zzro zzg(InputStream inputStream, zzbep zzbepVar) throws IOException {
        return (zzro) zzbff.zzae(zza, inputStream, zzbepVar);
    }

    static /* synthetic */ void zzh(zzro zzroVar, long j) {
        zzroVar.zzb |= 1;
        zzroVar.zzf = j;
    }

    static /* synthetic */ void zzi(zzro zzroVar, zzac zzacVar) {
        zzacVar.getClass();
        zzroVar.zzg = zzacVar;
        zzroVar.zzb |= 2;
    }

    static /* synthetic */ void zzj(zzro zzroVar, zzak zzakVar) {
        zzakVar.getClass();
        zzroVar.zzh = zzakVar;
        zzroVar.zzb |= 4;
    }

    public final long zza() {
        return this.zzf;
    }

    public final zzac zzc() {
        zzac zzacVar = this.zzg;
        return zzacVar == null ? zzac.zzk() : zzacVar;
    }

    public final zzak zzd() {
        zzak zzakVar = this.zzh;
        return zzakVar == null ? zzak.zzf() : zzakVar;
    }

    public final boolean zzk() {
        return (this.zzb & 2) != 0;
    }

    public final boolean zzl() {
        return (this.zzb & 4) != 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔂ\u0000\u0002ᔉ\u0001\u0003ᐉ\u0002", new Object[]{"zzb", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzro();
        }
        zzrm zzrmVar = null;
        if (i2 == 4) {
            return new zzrn(zzrmVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
