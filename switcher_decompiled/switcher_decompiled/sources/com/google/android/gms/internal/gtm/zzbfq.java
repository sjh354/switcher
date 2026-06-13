package com.google.android.gms.internal.gtm;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbfq {
    static final Charset zza = Charset.forName("US-ASCII");
    static final Charset zzb = Charset.forName("UTF-8");
    static final Charset zzc = Charset.forName("ISO-8859-1");
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzbcc zzf;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        int i = zzbcc.zzd;
        zzbby zzbbyVar = new zzbby(bArr, 0, 0, false, null);
        try {
            zzbbyVar.zzb(0);
            zzf = zzbbyVar;
        } catch (zzbfs e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzb(byte[] bArr) {
        int length = bArr.length;
        int iZzd = zzd(length, bArr, 0, length);
        if (iZzd == 0) {
            return 1;
        }
        return iZzd;
    }

    public static int zzc(long j) {
        return (int) (j ^ (j >>> 32));
    }

    static int zzd(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static Object zze(Object obj) {
        obj.getClass();
        return obj;
    }

    static Object zzf(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    static Object zzg(Object obj, Object obj2) {
        return ((zzbgs) obj).zzat().zzx((zzbgs) obj2).zzD();
    }

    public static String zzh(byte[] bArr) {
        return new String(bArr, zzb);
    }

    static boolean zzi(zzbgs zzbgsVar) {
        if (!(zzbgsVar instanceof zzbaz)) {
            return false;
        }
        throw null;
    }

    public static boolean zzj(byte[] bArr) {
        return zzbio.zze(bArr);
    }
}
