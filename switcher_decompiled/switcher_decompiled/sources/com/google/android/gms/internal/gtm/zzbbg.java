package com.google.android.gms.internal.gtm;

import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbbg {
    static int zza(byte[] bArr, int i, zzbbf zzbbfVar) throws zzbfs {
        int iZzj = zzj(bArr, i, zzbbfVar);
        int i2 = zzbbfVar.zza;
        if (i2 < 0) {
            throw zzbfs.zzf();
        }
        if (i2 > bArr.length - iZzj) {
            throw zzbfs.zzj();
        }
        if (i2 == 0) {
            zzbbfVar.zzc = zzbbw.zzb;
            return iZzj;
        }
        zzbbfVar.zzc = zzbbw.zzn(bArr, iZzj, i2);
        return iZzj + i2;
    }

    static int zzb(byte[] bArr, int i) {
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    static int zzc(zzbhf zzbhfVar, byte[] bArr, int i, int i2, int i3, zzbbf zzbbfVar) throws IOException {
        zzbgv zzbgvVar = (zzbgv) zzbhfVar;
        Object objZze = zzbgvVar.zze();
        int iZzc = zzbgvVar.zzc(objZze, bArr, i, i2, i3, zzbbfVar);
        zzbgvVar.zzf(objZze);
        zzbbfVar.zzc = objZze;
        return iZzc;
    }

    static int zzd(zzbhf zzbhfVar, byte[] bArr, int i, int i2, zzbbf zzbbfVar) throws IOException {
        int iZzk = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzk = zzk(i3, bArr, iZzk, zzbbfVar);
            i3 = zzbbfVar.zza;
        }
        int i4 = iZzk;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzbfs.zzj();
        }
        Object objZze = zzbhfVar.zze();
        int i5 = i3 + i4;
        zzbhfVar.zzi(objZze, bArr, i4, i5, zzbbfVar);
        zzbhfVar.zzf(objZze);
        zzbbfVar.zzc = objZze;
        return i5;
    }

    static int zze(zzbhf zzbhfVar, int i, byte[] bArr, int i2, int i3, zzbfp zzbfpVar, zzbbf zzbbfVar) throws IOException {
        int iZzd = zzd(zzbhfVar, bArr, i2, i3, zzbbfVar);
        zzbfpVar.add(zzbbfVar.zzc);
        while (iZzd < i3) {
            int iZzj = zzj(bArr, iZzd, zzbbfVar);
            if (i != zzbbfVar.zza) {
                break;
            }
            iZzd = zzd(zzbhfVar, bArr, iZzj, i3, zzbbfVar);
            zzbfpVar.add(zzbbfVar.zzc);
        }
        return iZzd;
    }

    static int zzf(byte[] bArr, int i, zzbfp zzbfpVar, zzbbf zzbbfVar) throws IOException {
        zzbfg zzbfgVar = (zzbfg) zzbfpVar;
        int iZzj = zzj(bArr, i, zzbbfVar);
        int i2 = zzbbfVar.zza + iZzj;
        while (iZzj < i2) {
            iZzj = zzj(bArr, iZzj, zzbbfVar);
            zzbfgVar.zzh(zzbbfVar.zza);
        }
        if (iZzj == i2) {
            return iZzj;
        }
        throw zzbfs.zzj();
    }

    static int zzg(byte[] bArr, int i, zzbbf zzbbfVar) throws zzbfs {
        int iZzj = zzj(bArr, i, zzbbfVar);
        int i2 = zzbbfVar.zza;
        if (i2 < 0) {
            throw zzbfs.zzf();
        }
        if (i2 == 0) {
            zzbbfVar.zzc = "";
            return iZzj;
        }
        zzbbfVar.zzc = new String(bArr, iZzj, i2, zzbfq.zzb);
        return iZzj + i2;
    }

    static int zzh(byte[] bArr, int i, zzbbf zzbbfVar) throws zzbfs {
        int iZzj = zzj(bArr, i, zzbbfVar);
        int i2 = zzbbfVar.zza;
        if (i2 < 0) {
            throw zzbfs.zzf();
        }
        if (i2 == 0) {
            zzbbfVar.zzc = "";
            return iZzj;
        }
        zzbbfVar.zzc = zzbio.zzd(bArr, iZzj, i2);
        return iZzj + i2;
    }

    static int zzi(int i, byte[] bArr, int i2, int i3, zzbia zzbiaVar, zzbbf zzbbfVar) throws zzbfs {
        if ((i >>> 3) == 0) {
            throw zzbfs.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzm = zzm(bArr, i2, zzbbfVar);
            zzbiaVar.zzh(i, Long.valueOf(zzbbfVar.zzb));
            return iZzm;
        }
        if (i4 == 1) {
            zzbiaVar.zzh(i, Long.valueOf(zzo(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzj = zzj(bArr, i2, zzbbfVar);
            int i5 = zzbbfVar.zza;
            if (i5 < 0) {
                throw zzbfs.zzf();
            }
            if (i5 > bArr.length - iZzj) {
                throw zzbfs.zzj();
            }
            if (i5 == 0) {
                zzbiaVar.zzh(i, zzbbw.zzb);
            } else {
                zzbiaVar.zzh(i, zzbbw.zzn(bArr, iZzj, i5));
            }
            return iZzj + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzbfs.zzc();
            }
            zzbiaVar.zzh(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzbia zzbiaVarZze = zzbia.zze();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZzj2 = zzj(bArr, i2, zzbbfVar);
            int i8 = zzbbfVar.zza;
            if (i8 == i6) {
                i7 = i8;
                i2 = iZzj2;
                break;
            }
            i7 = i8;
            i2 = zzi(i8, bArr, iZzj2, i3, zzbiaVarZze, zzbbfVar);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzbfs.zzg();
        }
        zzbiaVar.zzh(i, zzbiaVarZze);
        return i2;
    }

    static int zzj(byte[] bArr, int i, zzbbf zzbbfVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzbbfVar);
        }
        zzbbfVar.zza = b;
        return i2;
    }

    static int zzk(int i, byte[] bArr, int i2, zzbbf zzbbfVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzbbfVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzbbfVar.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & ByteCompanionObject.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzbbfVar.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & ByteCompanionObject.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzbbfVar.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzbbfVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzl(int i, byte[] bArr, int i2, int i3, zzbfp zzbfpVar, zzbbf zzbbfVar) {
        zzbfg zzbfgVar = (zzbfg) zzbfpVar;
        int iZzj = zzj(bArr, i2, zzbbfVar);
        zzbfgVar.zzh(zzbbfVar.zza);
        while (iZzj < i3) {
            int iZzj2 = zzj(bArr, iZzj, zzbbfVar);
            if (i != zzbbfVar.zza) {
                break;
            }
            iZzj = zzj(bArr, iZzj2, zzbbfVar);
            zzbfgVar.zzh(zzbbfVar.zza);
        }
        return iZzj;
    }

    static int zzm(byte[] bArr, int i, zzbbf zzbbfVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzbbfVar.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & ByteCompanionObject.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & ByteCompanionObject.MAX_VALUE)) << i4;
            b = b2;
            i3 = i5;
        }
        zzbbfVar.zzb = j2;
        return i3;
    }

    static long zzo(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static int zzn(int i, byte[] bArr, int i2, int i3, zzbbf zzbbfVar) throws zzbfs {
        if ((i >>> 3) == 0) {
            throw zzbfs.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzm(bArr, i2, zzbbfVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zzj(bArr, i2, zzbbfVar) + zzbbfVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzbfs.zzc();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zzj(bArr, i2, zzbbfVar);
            i6 = zzbbfVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zzn(i6, bArr, i2, i3, zzbbfVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzbfs.zzg();
        }
        return i2;
    }
}
