package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzkm {
    static final Charset zza = Charset.forName("US-ASCII");
    static final Charset zzb = Charset.forName("UTF-8");
    static final Charset zzc = Charset.forName("ISO-8859-1");
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzjh zzf;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        int i = zzjh.zza;
        zzjf zzjfVar = new zzjf(bArr, 0, 0, false, null);
        try {
            zzjfVar.zza(0);
            zzf = zzjfVar;
        } catch (zzko e) {
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
        for (int i4 = 0; i4 < i3; i4++) {
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
        return ((zzll) obj).zzbG().zzay((zzll) obj2).zzaG();
    }

    public static String zzh(byte[] bArr) {
        return new String(bArr, zzb);
    }

    public static boolean zzi(byte[] bArr) {
        return zznc.zze(bArr);
    }
}
