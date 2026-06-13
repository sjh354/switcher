package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzbcj extends zzbbm {
    private static final Logger zza = Logger.getLogger(zzbcj.class.getName());
    private static final boolean zzb = zzbij.zzx();
    zzbck zze;

    private zzbcj() {
    }

    /* synthetic */ zzbcj(zzbci zzbciVar) {
    }

    @Deprecated
    static int zzA(int i, zzbgs zzbgsVar, zzbhf zzbhfVar) {
        int iZzJ = zzJ(i << 3);
        int i2 = iZzJ + iZzJ;
        zzbay zzbayVar = (zzbay) zzbgsVar;
        int iZzQ = zzbayVar.zzQ();
        if (iZzQ == -1) {
            iZzQ = zzbhfVar.zza(zzbayVar);
            zzbayVar.zzT(iZzQ);
        }
        return i2 + iZzQ;
    }

    @Deprecated
    public static int zzB(zzbgs zzbgsVar) {
        return zzbgsVar.zzY();
    }

    public static int zzC(int i) {
        if (i >= 0) {
            return zzJ(i);
        }
        return 10;
    }

    public static int zzD(zzbfy zzbfyVar) {
        int iZza = zzbfyVar.zza();
        return zzJ(iZza) + iZza;
    }

    public static int zzE(zzbgs zzbgsVar) {
        int iZzY = zzbgsVar.zzY();
        return zzJ(iZzY) + iZzY;
    }

    static int zzF(zzbgs zzbgsVar, zzbhf zzbhfVar) {
        zzbay zzbayVar = (zzbay) zzbgsVar;
        int iZzQ = zzbayVar.zzQ();
        if (iZzQ == -1) {
            iZzQ = zzbhfVar.zza(zzbayVar);
            zzbayVar.zzT(iZzQ);
        }
        return zzJ(iZzQ) + iZzQ;
    }

    static int zzG(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int zzH(String str) {
        int length;
        try {
            length = zzbio.zzc(str);
        } catch (zzbin unused) {
            length = str.getBytes(zzbfq.zzb).length;
        }
        return zzJ(length) + length;
    }

    public static int zzI(int i) {
        return zzJ(i << 3);
    }

    public static int zzJ(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzK(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static zzbcj zzL(byte[] bArr) {
        return new zzbcf(bArr, 0, bArr.length);
    }

    public static zzbcj zzM(OutputStream outputStream, int i) {
        return new zzbch(outputStream, i);
    }

    public static int zzy(byte[] bArr) {
        int length = bArr.length;
        return zzJ(length) + length;
    }

    public static int zzz(zzbbw zzbbwVar) {
        int iZzd = zzbbwVar.zzd();
        return zzJ(iZzd) + iZzd;
    }

    final void zzN(String str, zzbin zzbinVar) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzbinVar);
        byte[] bytes = str.getBytes(zzbfq.zzb);
        try {
            int length = bytes.length;
            zzu(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzbcg(e);
        }
    }

    public abstract void zzR() throws IOException;

    public abstract void zzS(byte b) throws IOException;

    public abstract void zzT(int i, boolean z) throws IOException;

    public abstract void zzU(int i, zzbbw zzbbwVar) throws IOException;

    @Override // com.google.android.gms.internal.gtm.zzbbm
    public abstract void zza(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzi(int i) throws IOException;

    public abstract void zzj(int i, long j) throws IOException;

    public abstract void zzk(long j) throws IOException;

    public abstract void zzl(int i, int i2) throws IOException;

    public abstract void zzm(int i) throws IOException;

    abstract void zzn(int i, zzbgs zzbgsVar, zzbhf zzbhfVar) throws IOException;

    public abstract void zzo(int i, zzbgs zzbgsVar) throws IOException;

    public abstract void zzp(int i, zzbbw zzbbwVar) throws IOException;

    public abstract void zzq(int i, String str) throws IOException;

    public abstract void zzs(int i, int i2) throws IOException;

    public abstract void zzt(int i, int i2) throws IOException;

    public abstract void zzu(int i) throws IOException;

    public abstract void zzv(int i, long j) throws IOException;

    public abstract void zzw(long j) throws IOException;
}
