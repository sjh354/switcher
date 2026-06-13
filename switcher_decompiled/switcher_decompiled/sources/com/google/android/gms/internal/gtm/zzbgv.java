package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbgv<T> implements zzbhf<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzbij.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzbgs zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzbgg zzn;
    private final zzbhz zzo;
    private final zzbeq zzp;
    private final zzbgy zzq;
    private final zzbgn zzr;

    private zzbgv(int[] iArr, Object[] objArr, int i, int i2, zzbgs zzbgsVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzbgy zzbgyVar, zzbgg zzbggVar, zzbhz zzbhzVar, zzbeq zzbeqVar, zzbgn zzbgnVar, byte[] bArr) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzbgsVar instanceof zzbff;
        this.zzj = z;
        boolean z3 = false;
        if (zzbeqVar != null && zzbeqVar.zzi(zzbgsVar)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzk = iArr2;
        this.zzl = i3;
        this.zzm = i4;
        this.zzq = zzbgyVar;
        this.zzn = zzbggVar;
        this.zzo = zzbhzVar;
        this.zzp = zzbeqVar;
        this.zzg = zzbgsVar;
        this.zzr = zzbgnVar;
    }

    private final int zzA(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzB(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzC(int i) {
        return this.zzc[i + 1];
    }

    private static long zzD(Object obj, long j) {
        return ((Long) zzbij.zzf(obj, j)).longValue();
    }

    private final zzbfj zzE(int i) {
        int i2 = i / 3;
        return (zzbfj) this.zzd[i2 + i2 + 1];
    }

    private final zzbhf zzF(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzbhf zzbhfVar = (zzbhf) this.zzd[i3];
        if (zzbhfVar != null) {
            return zzbhfVar;
        }
        zzbhf zzbhfVarZzb = zzbhb.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzbhfVarZzb;
        return zzbhfVarZzb;
    }

    private final Object zzG(Object obj, int i, Object obj2, zzbhz zzbhzVar) {
        int i2 = this.zzc[i];
        Object objZzf = zzbij.zzf(obj, zzC(i) & 1048575);
        if (objZzf == null || zzE(i) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzH(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private static Field zzI(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private final void zzJ(Object obj, Object obj2, int i) {
        long jZzC = zzC(i) & 1048575;
        if (zzQ(obj2, i)) {
            Object objZzf = zzbij.zzf(obj, jZzC);
            Object objZzf2 = zzbij.zzf(obj2, jZzC);
            if (objZzf != null && objZzf2 != null) {
                zzbij.zzs(obj, jZzC, zzbfq.zzg(objZzf, objZzf2));
                zzM(obj, i);
            } else if (objZzf2 != null) {
                zzbij.zzs(obj, jZzC, objZzf2);
                zzM(obj, i);
            }
        }
    }

    private final void zzK(Object obj, Object obj2, int i) {
        int iZzC = zzC(i);
        int i2 = this.zzc[i];
        long j = iZzC & 1048575;
        if (zzT(obj2, i2, i)) {
            Object objZzf = zzT(obj, i2, i) ? zzbij.zzf(obj, j) : null;
            Object objZzf2 = zzbij.zzf(obj2, j);
            if (objZzf != null && objZzf2 != null) {
                zzbij.zzs(obj, j, zzbfq.zzg(objZzf, objZzf2));
                zzN(obj, i2, i);
            } else if (objZzf2 != null) {
                zzbij.zzs(obj, j, objZzf2);
                zzN(obj, i2, i);
            }
        }
    }

    private final void zzL(Object obj, int i, zzbhe zzbheVar) throws IOException {
        if (zzP(i)) {
            zzbij.zzs(obj, i & 1048575, zzbheVar.zzx());
        } else if (this.zzi) {
            zzbij.zzs(obj, i & 1048575, zzbheVar.zzv());
        } else {
            zzbij.zzs(obj, i & 1048575, zzbheVar.zzq());
        }
    }

    private final void zzM(Object obj, int i) {
        int iZzz = zzz(i);
        long j = 1048575 & iZzz;
        if (j == 1048575) {
            return;
        }
        zzbij.zzq(obj, j, (1 << (iZzz >>> 20)) | zzbij.zzc(obj, j));
    }

    private final void zzN(Object obj, int i, int i2) {
        zzbij.zzq(obj, zzz(i2) & 1048575, i);
    }

    private final boolean zzO(Object obj, Object obj2, int i) {
        return zzQ(obj, i) == zzQ(obj2, i);
    }

    private static boolean zzP(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean zzQ(Object obj, int i) {
        int iZzz = zzz(i);
        long j = iZzz & 1048575;
        if (j != 1048575) {
            return (zzbij.zzc(obj, j) & (1 << (iZzz >>> 20))) != 0;
        }
        int iZzC = zzC(i);
        long j2 = iZzC & 1048575;
        switch (zzB(iZzC)) {
            case 0:
                return Double.doubleToRawLongBits(zzbij.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzbij.zzb(obj, j2)) != 0;
            case 2:
                return zzbij.zzd(obj, j2) != 0;
            case 3:
                return zzbij.zzd(obj, j2) != 0;
            case 4:
                return zzbij.zzc(obj, j2) != 0;
            case 5:
                return zzbij.zzd(obj, j2) != 0;
            case 6:
                return zzbij.zzc(obj, j2) != 0;
            case 7:
                return zzbij.zzw(obj, j2);
            case 8:
                Object objZzf = zzbij.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzbbw) {
                    return !zzbbw.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzbij.zzf(obj, j2) != null;
            case 10:
                return !zzbbw.zzb.equals(zzbij.zzf(obj, j2));
            case 11:
                return zzbij.zzc(obj, j2) != 0;
            case 12:
                return zzbij.zzc(obj, j2) != 0;
            case 13:
                return zzbij.zzc(obj, j2) != 0;
            case 14:
                return zzbij.zzd(obj, j2) != 0;
            case 15:
                return zzbij.zzc(obj, j2) != 0;
            case 16:
                return zzbij.zzd(obj, j2) != 0;
            case 17:
                return zzbij.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzR(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzQ(obj, i) : (i3 & i4) != 0;
    }

    private static boolean zzS(Object obj, int i, zzbhf zzbhfVar) {
        return zzbhfVar.zzk(zzbij.zzf(obj, i & 1048575));
    }

    private final boolean zzT(Object obj, int i, int i2) {
        return zzbij.zzc(obj, (long) (zzz(i2) & 1048575)) == i;
    }

    private static boolean zzU(Object obj, long j) {
        return ((Boolean) zzbij.zzf(obj, j)).booleanValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzV(java.lang.Object r17, com.google.android.gms.internal.gtm.zzbck r18) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzbgv.zzV(java.lang.Object, com.google.android.gms.internal.gtm.zzbck):void");
    }

    private final void zzW(zzbck zzbckVar, int i, Object obj, int i2) throws IOException {
        if (obj == null) {
            return;
        }
        throw null;
    }

    private static final void zzX(int i, Object obj, zzbck zzbckVar) throws IOException {
        if (obj instanceof String) {
            zzbckVar.zzG(i, (String) obj);
        } else {
            zzbckVar.zzd(i, (zzbbw) obj);
        }
    }

    static zzbia zzd(Object obj) {
        zzbff zzbffVar = (zzbff) obj;
        zzbia zzbiaVar = zzbffVar.zzd;
        if (zzbiaVar != zzbia.zzc()) {
            return zzbiaVar;
        }
        zzbia zzbiaVarZze = zzbia.zze();
        zzbffVar.zzd = zzbiaVarZze;
        return zzbiaVarZze;
    }

    static zzbgv zzl(Class cls, zzbgp zzbgpVar, zzbgy zzbgyVar, zzbgg zzbggVar, zzbhz zzbhzVar, zzbeq zzbeqVar, zzbgn zzbgnVar) {
        if (zzbgpVar instanceof zzbhd) {
            return zzm((zzbhd) zzbgpVar, zzbgyVar, zzbggVar, zzbhzVar, zzbeqVar, zzbgnVar);
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0379  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static com.google.android.gms.internal.gtm.zzbgv zzm(com.google.android.gms.internal.gtm.zzbhd r34, com.google.android.gms.internal.gtm.zzbgy r35, com.google.android.gms.internal.gtm.zzbgg r36, com.google.android.gms.internal.gtm.zzbhz r37, com.google.android.gms.internal.gtm.zzbeq r38, com.google.android.gms.internal.gtm.zzbgn r39) {
        /*
            Method dump skipped, instruction units count: 1016
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzbgv.zzm(com.google.android.gms.internal.gtm.zzbhd, com.google.android.gms.internal.gtm.zzbgy, com.google.android.gms.internal.gtm.zzbgg, com.google.android.gms.internal.gtm.zzbhz, com.google.android.gms.internal.gtm.zzbeq, com.google.android.gms.internal.gtm.zzbgn):com.google.android.gms.internal.gtm.zzbgv");
    }

    private static double zzo(Object obj, long j) {
        return ((Double) zzbij.zzf(obj, j)).doubleValue();
    }

    private static float zzp(Object obj, long j) {
        return ((Float) zzbij.zzf(obj, j)).floatValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int zzq(Object obj) {
        int i;
        int iZzJ;
        int iZzJ2;
        int iZzJ3;
        int iZzK;
        int iZzJ4;
        int iZzC;
        int iZzJ5;
        int iZzJ6;
        int iZzd;
        int iZzJ7;
        int i2;
        int iZzu;
        boolean z;
        int iZzd2;
        int iZzi;
        int iZzI;
        int iZzJ8;
        int iZzJ9;
        int iZzJ10;
        int iZzJ11;
        int iZzJ12;
        int iZzK2;
        int iZzJ13;
        int iZzd3;
        int iZzJ14;
        int i3;
        Unsafe unsafe = zzb;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int iZzJ15 = 0;
        int i7 = 0;
        while (i6 < this.zzc.length) {
            int iZzC2 = zzC(i6);
            int[] iArr = this.zzc;
            int i8 = iArr[i6];
            int iZzB = zzB(iZzC2);
            if (iZzB <= 17) {
                int i9 = iArr[i6 + 2];
                int i10 = i9 & i4;
                i = 1 << (i9 >>> 20);
                if (i10 != i5) {
                    i7 = unsafe.getInt(obj, i10);
                    i5 = i10;
                }
            } else {
                i = 0;
            }
            long j = iZzC2 & i4;
            switch (iZzB) {
                case 0:
                    if ((i7 & i) != 0) {
                        iZzJ = zzbcj.zzJ(i8 << 3);
                        iZzJ5 = iZzJ + 8;
                        iZzJ15 += iZzJ5;
                    }
                    break;
                case 1:
                    if ((i7 & i) != 0) {
                        iZzJ2 = zzbcj.zzJ(i8 << 3);
                        iZzJ5 = iZzJ2 + 4;
                        iZzJ15 += iZzJ5;
                    }
                    break;
                case 2:
                    if ((i7 & i) != 0) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzJ3 = zzbcj.zzJ(i8 << 3);
                        iZzK = zzbcj.zzK(j2);
                        iZzJ15 += iZzJ3 + iZzK;
                    }
                    break;
                case 3:
                    if ((i7 & i) != 0) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzJ3 = zzbcj.zzJ(i8 << 3);
                        iZzK = zzbcj.zzK(j3);
                        iZzJ15 += iZzJ3 + iZzK;
                    }
                    break;
                case 4:
                    if ((i7 & i) != 0) {
                        int i11 = unsafe.getInt(obj, j);
                        iZzJ4 = zzbcj.zzJ(i8 << 3);
                        iZzC = zzbcj.zzC(i11);
                        i2 = iZzJ4 + iZzC;
                        iZzJ15 += i2;
                    }
                    break;
                case 5:
                    if ((i7 & i) != 0) {
                        iZzJ = zzbcj.zzJ(i8 << 3);
                        iZzJ5 = iZzJ + 8;
                        iZzJ15 += iZzJ5;
                    }
                    break;
                case 6:
                    if ((i7 & i) != 0) {
                        iZzJ2 = zzbcj.zzJ(i8 << 3);
                        iZzJ5 = iZzJ2 + 4;
                        iZzJ15 += iZzJ5;
                    }
                    break;
                case 7:
                    if ((i7 & i) != 0) {
                        iZzJ5 = zzbcj.zzJ(i8 << 3) + 1;
                        iZzJ15 += iZzJ5;
                    }
                    break;
                case 8:
                    if ((i7 & i) != 0) {
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzbbw) {
                            iZzJ6 = zzbcj.zzJ(i8 << 3);
                            iZzd = ((zzbbw) object).zzd();
                            iZzJ7 = zzbcj.zzJ(iZzd);
                            i2 = iZzJ6 + iZzJ7 + iZzd;
                            iZzJ15 += i2;
                        } else {
                            iZzJ4 = zzbcj.zzJ(i8 << 3);
                            iZzC = zzbcj.zzH((String) object);
                            i2 = iZzJ4 + iZzC;
                            iZzJ15 += i2;
                        }
                    }
                    break;
                case 9:
                    if ((i7 & i) != 0) {
                        iZzJ5 = zzbhh.zzo(i8, unsafe.getObject(obj, j), zzF(i6));
                        iZzJ15 += iZzJ5;
                    }
                    break;
                case 10:
                    if ((i7 & i) != 0) {
                        zzbbw zzbbwVar = (zzbbw) unsafe.getObject(obj, j);
                        iZzJ6 = zzbcj.zzJ(i8 << 3);
                        iZzd = zzbbwVar.zzd();
                        iZzJ7 = zzbcj.zzJ(iZzd);
                        i2 = iZzJ6 + iZzJ7 + iZzd;
                        iZzJ15 += i2;
                    }
                    break;
                case 11:
                    if ((i7 & i) != 0) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzJ4 = zzbcj.zzJ(i8 << 3);
                        iZzC = zzbcj.zzJ(i12);
                        i2 = iZzJ4 + iZzC;
                        iZzJ15 += i2;
                    }
                    break;
                case 12:
                    if ((i7 & i) != 0) {
                        int i13 = unsafe.getInt(obj, j);
                        iZzJ4 = zzbcj.zzJ(i8 << 3);
                        iZzC = zzbcj.zzC(i13);
                        i2 = iZzJ4 + iZzC;
                        iZzJ15 += i2;
                    }
                    break;
                case 13:
                    if ((i7 & i) != 0) {
                        iZzJ2 = zzbcj.zzJ(i8 << 3);
                        iZzJ5 = iZzJ2 + 4;
                        iZzJ15 += iZzJ5;
                    }
                    break;
                case 14:
                    if ((i7 & i) != 0) {
                        iZzJ = zzbcj.zzJ(i8 << 3);
                        iZzJ5 = iZzJ + 8;
                        iZzJ15 += iZzJ5;
                    }
                    break;
                case 15:
                    if ((i7 & i) != 0) {
                        int i14 = unsafe.getInt(obj, j);
                        iZzJ4 = zzbcj.zzJ(i8 << 3);
                        iZzC = zzbcj.zzJ((i14 >> 31) ^ (i14 + i14));
                        i2 = iZzJ4 + iZzC;
                        iZzJ15 += i2;
                    }
                    break;
                case 16:
                    if ((i & i7) != 0) {
                        long j4 = unsafe.getLong(obj, j);
                        iZzJ15 += zzbcj.zzJ(i8 << 3) + zzbcj.zzK((j4 >> 63) ^ (j4 + j4));
                    }
                    break;
                case 17:
                    if ((i7 & i) != 0) {
                        iZzJ5 = zzbcj.zzA(i8, (zzbgs) unsafe.getObject(obj, j), zzF(i6));
                        iZzJ15 += iZzJ5;
                    }
                    break;
                case 18:
                    iZzJ5 = zzbhh.zzh(i8, (List) unsafe.getObject(obj, j), false);
                    iZzJ15 += iZzJ5;
                    break;
                case 19:
                    iZzJ5 = zzbhh.zzf(i8, (List) unsafe.getObject(obj, j), false);
                    iZzJ15 += iZzJ5;
                    break;
                case 20:
                    iZzJ5 = zzbhh.zzm(i8, (List) unsafe.getObject(obj, j), false);
                    iZzJ15 += iZzJ5;
                    break;
                case 21:
                    iZzJ5 = zzbhh.zzx(i8, (List) unsafe.getObject(obj, j), false);
                    iZzJ15 += iZzJ5;
                    break;
                case 22:
                    iZzJ5 = zzbhh.zzk(i8, (List) unsafe.getObject(obj, j), false);
                    iZzJ15 += iZzJ5;
                    break;
                case 23:
                    iZzJ5 = zzbhh.zzh(i8, (List) unsafe.getObject(obj, j), false);
                    iZzJ15 += iZzJ5;
                    break;
                case 24:
                    iZzJ5 = zzbhh.zzf(i8, (List) unsafe.getObject(obj, j), false);
                    iZzJ15 += iZzJ5;
                    break;
                case 25:
                    iZzJ5 = zzbhh.zza(i8, (List) unsafe.getObject(obj, j), false);
                    iZzJ15 += iZzJ5;
                    break;
                case 26:
                    iZzu = zzbhh.zzu(i8, (List) unsafe.getObject(obj, j));
                    iZzJ15 += iZzu;
                    break;
                case 27:
                    iZzu = zzbhh.zzp(i8, (List) unsafe.getObject(obj, j), zzF(i6));
                    iZzJ15 += iZzu;
                    break;
                case 28:
                    iZzu = zzbhh.zzc(i8, (List) unsafe.getObject(obj, j));
                    iZzJ15 += iZzu;
                    break;
                case 29:
                    iZzu = zzbhh.zzv(i8, (List) unsafe.getObject(obj, j), false);
                    iZzJ15 += iZzu;
                    break;
                case 30:
                    z = false;
                    iZzd2 = zzbhh.zzd(i8, (List) unsafe.getObject(obj, j), false);
                    iZzJ15 += iZzd2;
                    break;
                case 31:
                    z = false;
                    iZzd2 = zzbhh.zzf(i8, (List) unsafe.getObject(obj, j), false);
                    iZzJ15 += iZzd2;
                    break;
                case 32:
                    z = false;
                    iZzd2 = zzbhh.zzh(i8, (List) unsafe.getObject(obj, j), false);
                    iZzJ15 += iZzd2;
                    break;
                case 33:
                    z = false;
                    iZzd2 = zzbhh.zzq(i8, (List) unsafe.getObject(obj, j), false);
                    iZzJ15 += iZzd2;
                    break;
                case 34:
                    z = false;
                    iZzd2 = zzbhh.zzs(i8, (List) unsafe.getObject(obj, j), false);
                    iZzJ15 += iZzd2;
                    break;
                case 35:
                    iZzi = zzbhh.zzi((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzI = zzbcj.zzI(i8);
                        iZzJ8 = zzbcj.zzJ(iZzi);
                        iZzJ9 = iZzI + iZzJ8;
                        i3 = iZzJ9 + iZzi;
                        iZzJ15 += i3;
                    }
                    break;
                case 36:
                    iZzi = zzbhh.zzg((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzI = zzbcj.zzI(i8);
                        iZzJ8 = zzbcj.zzJ(iZzi);
                        iZzJ9 = iZzI + iZzJ8;
                        i3 = iZzJ9 + iZzi;
                        iZzJ15 += i3;
                    }
                    break;
                case 37:
                    iZzi = zzbhh.zzn((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzI = zzbcj.zzI(i8);
                        iZzJ8 = zzbcj.zzJ(iZzi);
                        iZzJ9 = iZzI + iZzJ8;
                        i3 = iZzJ9 + iZzi;
                        iZzJ15 += i3;
                    }
                    break;
                case 38:
                    iZzi = zzbhh.zzy((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzI = zzbcj.zzI(i8);
                        iZzJ8 = zzbcj.zzJ(iZzi);
                        iZzJ9 = iZzI + iZzJ8;
                        i3 = iZzJ9 + iZzi;
                        iZzJ15 += i3;
                    }
                    break;
                case 39:
                    iZzi = zzbhh.zzl((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzI = zzbcj.zzI(i8);
                        iZzJ8 = zzbcj.zzJ(iZzi);
                        iZzJ9 = iZzI + iZzJ8;
                        i3 = iZzJ9 + iZzi;
                        iZzJ15 += i3;
                    }
                    break;
                case 40:
                    iZzi = zzbhh.zzi((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzI = zzbcj.zzI(i8);
                        iZzJ8 = zzbcj.zzJ(iZzi);
                        iZzJ9 = iZzI + iZzJ8;
                        i3 = iZzJ9 + iZzi;
                        iZzJ15 += i3;
                    }
                    break;
                case 41:
                    iZzi = zzbhh.zzg((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzI = zzbcj.zzI(i8);
                        iZzJ8 = zzbcj.zzJ(iZzi);
                        iZzJ9 = iZzI + iZzJ8;
                        i3 = iZzJ9 + iZzi;
                        iZzJ15 += i3;
                    }
                    break;
                case 42:
                    iZzi = zzbhh.zzb((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzI = zzbcj.zzI(i8);
                        iZzJ8 = zzbcj.zzJ(iZzi);
                        iZzJ9 = iZzI + iZzJ8;
                        i3 = iZzJ9 + iZzi;
                        iZzJ15 += i3;
                    }
                    break;
                case 43:
                    iZzi = zzbhh.zzw((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzI = zzbcj.zzI(i8);
                        iZzJ8 = zzbcj.zzJ(iZzi);
                        iZzJ9 = iZzI + iZzJ8;
                        i3 = iZzJ9 + iZzi;
                        iZzJ15 += i3;
                    }
                    break;
                case 44:
                    iZzi = zzbhh.zze((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzI = zzbcj.zzI(i8);
                        iZzJ8 = zzbcj.zzJ(iZzi);
                        iZzJ9 = iZzI + iZzJ8;
                        i3 = iZzJ9 + iZzi;
                        iZzJ15 += i3;
                    }
                    break;
                case 45:
                    iZzi = zzbhh.zzg((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzI = zzbcj.zzI(i8);
                        iZzJ8 = zzbcj.zzJ(iZzi);
                        iZzJ9 = iZzI + iZzJ8;
                        i3 = iZzJ9 + iZzi;
                        iZzJ15 += i3;
                    }
                    break;
                case 46:
                    iZzi = zzbhh.zzi((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzI = zzbcj.zzI(i8);
                        iZzJ8 = zzbcj.zzJ(iZzi);
                        iZzJ9 = iZzI + iZzJ8;
                        i3 = iZzJ9 + iZzi;
                        iZzJ15 += i3;
                    }
                    break;
                case 47:
                    iZzi = zzbhh.zzr((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzI = zzbcj.zzI(i8);
                        iZzJ8 = zzbcj.zzJ(iZzi);
                        iZzJ9 = iZzI + iZzJ8;
                        i3 = iZzJ9 + iZzi;
                        iZzJ15 += i3;
                    }
                    break;
                case 48:
                    iZzi = zzbhh.zzt((List) unsafe.getObject(obj, j));
                    if (iZzi > 0) {
                        iZzI = zzbcj.zzI(i8);
                        iZzJ8 = zzbcj.zzJ(iZzi);
                        iZzJ9 = iZzI + iZzJ8;
                        i3 = iZzJ9 + iZzi;
                        iZzJ15 += i3;
                    }
                    break;
                case 49:
                    iZzu = zzbhh.zzj(i8, (List) unsafe.getObject(obj, j), zzF(i6));
                    iZzJ15 += iZzu;
                    break;
                case 50:
                    zzbgn.zza(i8, unsafe.getObject(obj, j), zzH(i6));
                    break;
                case 51:
                    if (zzT(obj, i8, i6)) {
                        iZzJ10 = zzbcj.zzJ(i8 << 3);
                        iZzu = iZzJ10 + 8;
                        iZzJ15 += iZzu;
                    }
                    break;
                case 52:
                    if (zzT(obj, i8, i6)) {
                        iZzJ11 = zzbcj.zzJ(i8 << 3);
                        iZzu = iZzJ11 + 4;
                        iZzJ15 += iZzu;
                    }
                    break;
                case 53:
                    if (zzT(obj, i8, i6)) {
                        long jZzD = zzD(obj, j);
                        iZzJ12 = zzbcj.zzJ(i8 << 3);
                        iZzK2 = zzbcj.zzK(jZzD);
                        iZzJ15 += iZzJ12 + iZzK2;
                    }
                    break;
                case 54:
                    if (zzT(obj, i8, i6)) {
                        long jZzD2 = zzD(obj, j);
                        iZzJ12 = zzbcj.zzJ(i8 << 3);
                        iZzK2 = zzbcj.zzK(jZzD2);
                        iZzJ15 += iZzJ12 + iZzK2;
                    }
                    break;
                case 55:
                    if (zzT(obj, i8, i6)) {
                        int iZzs = zzs(obj, j);
                        iZzJ9 = zzbcj.zzJ(i8 << 3);
                        iZzi = zzbcj.zzC(iZzs);
                        i3 = iZzJ9 + iZzi;
                        iZzJ15 += i3;
                    }
                    break;
                case 56:
                    if (zzT(obj, i8, i6)) {
                        iZzJ10 = zzbcj.zzJ(i8 << 3);
                        iZzu = iZzJ10 + 8;
                        iZzJ15 += iZzu;
                    }
                    break;
                case 57:
                    if (zzT(obj, i8, i6)) {
                        iZzJ11 = zzbcj.zzJ(i8 << 3);
                        iZzu = iZzJ11 + 4;
                        iZzJ15 += iZzu;
                    }
                    break;
                case 58:
                    if (zzT(obj, i8, i6)) {
                        iZzu = zzbcj.zzJ(i8 << 3) + 1;
                        iZzJ15 += iZzu;
                    }
                    break;
                case 59:
                    if (zzT(obj, i8, i6)) {
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzbbw) {
                            iZzJ13 = zzbcj.zzJ(i8 << 3);
                            iZzd3 = ((zzbbw) object2).zzd();
                            iZzJ14 = zzbcj.zzJ(iZzd3);
                            i3 = iZzJ13 + iZzJ14 + iZzd3;
                            iZzJ15 += i3;
                        } else {
                            iZzJ9 = zzbcj.zzJ(i8 << 3);
                            iZzi = zzbcj.zzH((String) object2);
                            i3 = iZzJ9 + iZzi;
                            iZzJ15 += i3;
                        }
                    }
                    break;
                case 60:
                    if (zzT(obj, i8, i6)) {
                        iZzu = zzbhh.zzo(i8, unsafe.getObject(obj, j), zzF(i6));
                        iZzJ15 += iZzu;
                    }
                    break;
                case 61:
                    if (zzT(obj, i8, i6)) {
                        zzbbw zzbbwVar2 = (zzbbw) unsafe.getObject(obj, j);
                        iZzJ13 = zzbcj.zzJ(i8 << 3);
                        iZzd3 = zzbbwVar2.zzd();
                        iZzJ14 = zzbcj.zzJ(iZzd3);
                        i3 = iZzJ13 + iZzJ14 + iZzd3;
                        iZzJ15 += i3;
                    }
                    break;
                case 62:
                    if (zzT(obj, i8, i6)) {
                        int iZzs2 = zzs(obj, j);
                        iZzJ9 = zzbcj.zzJ(i8 << 3);
                        iZzi = zzbcj.zzJ(iZzs2);
                        i3 = iZzJ9 + iZzi;
                        iZzJ15 += i3;
                    }
                    break;
                case 63:
                    if (zzT(obj, i8, i6)) {
                        int iZzs3 = zzs(obj, j);
                        iZzJ9 = zzbcj.zzJ(i8 << 3);
                        iZzi = zzbcj.zzC(iZzs3);
                        i3 = iZzJ9 + iZzi;
                        iZzJ15 += i3;
                    }
                    break;
                case 64:
                    if (zzT(obj, i8, i6)) {
                        iZzJ11 = zzbcj.zzJ(i8 << 3);
                        iZzu = iZzJ11 + 4;
                        iZzJ15 += iZzu;
                    }
                    break;
                case 65:
                    if (zzT(obj, i8, i6)) {
                        iZzJ10 = zzbcj.zzJ(i8 << 3);
                        iZzu = iZzJ10 + 8;
                        iZzJ15 += iZzu;
                    }
                    break;
                case 66:
                    if (zzT(obj, i8, i6)) {
                        int iZzs4 = zzs(obj, j);
                        iZzJ9 = zzbcj.zzJ(i8 << 3);
                        iZzi = zzbcj.zzJ((iZzs4 >> 31) ^ (iZzs4 + iZzs4));
                        i3 = iZzJ9 + iZzi;
                        iZzJ15 += i3;
                    }
                    break;
                case 67:
                    if (zzT(obj, i8, i6)) {
                        long jZzD3 = zzD(obj, j);
                        iZzJ15 += zzbcj.zzJ(i8 << 3) + zzbcj.zzK((jZzD3 >> 63) ^ (jZzD3 + jZzD3));
                    }
                    break;
                case 68:
                    if (zzT(obj, i8, i6)) {
                        iZzu = zzbcj.zzA(i8, (zzbgs) unsafe.getObject(obj, j), zzF(i6));
                        iZzJ15 += iZzu;
                    }
                    break;
            }
            i6 += 3;
            i4 = 1048575;
        }
        int iZzb = 0;
        zzbhz zzbhzVar = this.zzo;
        int iZza = iZzJ15 + zzbhzVar.zza(zzbhzVar.zzd(obj));
        if (!this.zzh) {
            return iZza;
        }
        zzbeu zzbeuVarZzb = this.zzp.zzb(obj);
        for (int i15 = 0; i15 < zzbeuVarZzb.zza.zzb(); i15++) {
            Map.Entry entryZzg = zzbeuVarZzb.zza.zzg(i15);
            iZzb += zzbeu.zzb((zzbet) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry : zzbeuVarZzb.zza.zzc()) {
            iZzb += zzbeu.zzb((zzbet) entry.getKey(), entry.getValue());
        }
        return iZza + iZzb;
    }

    private final int zzr(Object obj) {
        int iZzJ;
        int iZzJ2;
        int iZzJ3;
        int iZzK;
        int iZzJ4;
        int iZzC;
        int iZzJ5;
        int iZzJ6;
        int iZzd;
        int iZzJ7;
        int iZzo;
        int iZzI;
        int iZzJ8;
        int i;
        Unsafe unsafe = zzb;
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzc.length; i3 += 3) {
            int iZzC2 = zzC(i3);
            int iZzB = zzB(iZzC2);
            int i4 = this.zzc[i3];
            long j = iZzC2 & 1048575;
            if (iZzB >= zzbev.DOUBLE_LIST_PACKED.zza() && iZzB <= zzbev.SINT64_LIST_PACKED.zza()) {
                int i5 = this.zzc[i3 + 2];
            }
            switch (iZzB) {
                case 0:
                    if (zzQ(obj, i3)) {
                        iZzJ = zzbcj.zzJ(i4 << 3);
                        iZzo = iZzJ + 8;
                        i2 += iZzo;
                    }
                    break;
                case 1:
                    if (zzQ(obj, i3)) {
                        iZzJ2 = zzbcj.zzJ(i4 << 3);
                        iZzo = iZzJ2 + 4;
                        i2 += iZzo;
                    }
                    break;
                case 2:
                    if (zzQ(obj, i3)) {
                        long jZzd = zzbij.zzd(obj, j);
                        iZzJ3 = zzbcj.zzJ(i4 << 3);
                        iZzK = zzbcj.zzK(jZzd);
                        i2 += iZzJ3 + iZzK;
                    }
                    break;
                case 3:
                    if (zzQ(obj, i3)) {
                        long jZzd2 = zzbij.zzd(obj, j);
                        iZzJ3 = zzbcj.zzJ(i4 << 3);
                        iZzK = zzbcj.zzK(jZzd2);
                        i2 += iZzJ3 + iZzK;
                    }
                    break;
                case 4:
                    if (zzQ(obj, i3)) {
                        int iZzc = zzbij.zzc(obj, j);
                        iZzJ4 = zzbcj.zzJ(i4 << 3);
                        iZzC = zzbcj.zzC(iZzc);
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 5:
                    if (zzQ(obj, i3)) {
                        iZzJ = zzbcj.zzJ(i4 << 3);
                        iZzo = iZzJ + 8;
                        i2 += iZzo;
                    }
                    break;
                case 6:
                    if (zzQ(obj, i3)) {
                        iZzJ2 = zzbcj.zzJ(i4 << 3);
                        iZzo = iZzJ2 + 4;
                        i2 += iZzo;
                    }
                    break;
                case 7:
                    if (zzQ(obj, i3)) {
                        iZzJ5 = zzbcj.zzJ(i4 << 3);
                        iZzo = iZzJ5 + 1;
                        i2 += iZzo;
                    }
                    break;
                case 8:
                    if (zzQ(obj, i3)) {
                        Object objZzf = zzbij.zzf(obj, j);
                        if (objZzf instanceof zzbbw) {
                            iZzJ6 = zzbcj.zzJ(i4 << 3);
                            iZzd = ((zzbbw) objZzf).zzd();
                            iZzJ7 = zzbcj.zzJ(iZzd);
                            i = iZzJ6 + iZzJ7 + iZzd;
                            i2 += i;
                        } else {
                            iZzJ4 = zzbcj.zzJ(i4 << 3);
                            iZzC = zzbcj.zzH((String) objZzf);
                            i = iZzJ4 + iZzC;
                            i2 += i;
                        }
                    }
                    break;
                case 9:
                    if (zzQ(obj, i3)) {
                        iZzo = zzbhh.zzo(i4, zzbij.zzf(obj, j), zzF(i3));
                        i2 += iZzo;
                    }
                    break;
                case 10:
                    if (zzQ(obj, i3)) {
                        zzbbw zzbbwVar = (zzbbw) zzbij.zzf(obj, j);
                        iZzJ6 = zzbcj.zzJ(i4 << 3);
                        iZzd = zzbbwVar.zzd();
                        iZzJ7 = zzbcj.zzJ(iZzd);
                        i = iZzJ6 + iZzJ7 + iZzd;
                        i2 += i;
                    }
                    break;
                case 11:
                    if (zzQ(obj, i3)) {
                        int iZzc2 = zzbij.zzc(obj, j);
                        iZzJ4 = zzbcj.zzJ(i4 << 3);
                        iZzC = zzbcj.zzJ(iZzc2);
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 12:
                    if (zzQ(obj, i3)) {
                        int iZzc3 = zzbij.zzc(obj, j);
                        iZzJ4 = zzbcj.zzJ(i4 << 3);
                        iZzC = zzbcj.zzC(iZzc3);
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 13:
                    if (zzQ(obj, i3)) {
                        iZzJ2 = zzbcj.zzJ(i4 << 3);
                        iZzo = iZzJ2 + 4;
                        i2 += iZzo;
                    }
                    break;
                case 14:
                    if (zzQ(obj, i3)) {
                        iZzJ = zzbcj.zzJ(i4 << 3);
                        iZzo = iZzJ + 8;
                        i2 += iZzo;
                    }
                    break;
                case 15:
                    if (zzQ(obj, i3)) {
                        int iZzc4 = zzbij.zzc(obj, j);
                        iZzJ4 = zzbcj.zzJ(i4 << 3);
                        iZzC = zzbcj.zzJ((iZzc4 >> 31) ^ (iZzc4 + iZzc4));
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 16:
                    if (zzQ(obj, i3)) {
                        long jZzd3 = zzbij.zzd(obj, j);
                        iZzJ4 = zzbcj.zzJ(i4 << 3);
                        iZzC = zzbcj.zzK((jZzd3 >> 63) ^ (jZzd3 + jZzd3));
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 17:
                    if (zzQ(obj, i3)) {
                        iZzo = zzbcj.zzA(i4, (zzbgs) zzbij.zzf(obj, j), zzF(i3));
                        i2 += iZzo;
                    }
                    break;
                case 18:
                    iZzo = zzbhh.zzh(i4, (List) zzbij.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 19:
                    iZzo = zzbhh.zzf(i4, (List) zzbij.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 20:
                    iZzo = zzbhh.zzm(i4, (List) zzbij.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 21:
                    iZzo = zzbhh.zzx(i4, (List) zzbij.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 22:
                    iZzo = zzbhh.zzk(i4, (List) zzbij.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 23:
                    iZzo = zzbhh.zzh(i4, (List) zzbij.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 24:
                    iZzo = zzbhh.zzf(i4, (List) zzbij.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 25:
                    iZzo = zzbhh.zza(i4, (List) zzbij.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 26:
                    iZzo = zzbhh.zzu(i4, (List) zzbij.zzf(obj, j));
                    i2 += iZzo;
                    break;
                case 27:
                    iZzo = zzbhh.zzp(i4, (List) zzbij.zzf(obj, j), zzF(i3));
                    i2 += iZzo;
                    break;
                case 28:
                    iZzo = zzbhh.zzc(i4, (List) zzbij.zzf(obj, j));
                    i2 += iZzo;
                    break;
                case 29:
                    iZzo = zzbhh.zzv(i4, (List) zzbij.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 30:
                    iZzo = zzbhh.zzd(i4, (List) zzbij.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 31:
                    iZzo = zzbhh.zzf(i4, (List) zzbij.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 32:
                    iZzo = zzbhh.zzh(i4, (List) zzbij.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 33:
                    iZzo = zzbhh.zzq(i4, (List) zzbij.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 34:
                    iZzo = zzbhh.zzs(i4, (List) zzbij.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 35:
                    iZzC = zzbhh.zzi((List) unsafe.getObject(obj, j));
                    if (iZzC > 0) {
                        iZzI = zzbcj.zzI(i4);
                        iZzJ8 = zzbcj.zzJ(iZzC);
                        iZzJ4 = iZzI + iZzJ8;
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 36:
                    iZzC = zzbhh.zzg((List) unsafe.getObject(obj, j));
                    if (iZzC > 0) {
                        iZzI = zzbcj.zzI(i4);
                        iZzJ8 = zzbcj.zzJ(iZzC);
                        iZzJ4 = iZzI + iZzJ8;
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 37:
                    iZzC = zzbhh.zzn((List) unsafe.getObject(obj, j));
                    if (iZzC > 0) {
                        iZzI = zzbcj.zzI(i4);
                        iZzJ8 = zzbcj.zzJ(iZzC);
                        iZzJ4 = iZzI + iZzJ8;
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 38:
                    iZzC = zzbhh.zzy((List) unsafe.getObject(obj, j));
                    if (iZzC > 0) {
                        iZzI = zzbcj.zzI(i4);
                        iZzJ8 = zzbcj.zzJ(iZzC);
                        iZzJ4 = iZzI + iZzJ8;
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 39:
                    iZzC = zzbhh.zzl((List) unsafe.getObject(obj, j));
                    if (iZzC > 0) {
                        iZzI = zzbcj.zzI(i4);
                        iZzJ8 = zzbcj.zzJ(iZzC);
                        iZzJ4 = iZzI + iZzJ8;
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 40:
                    iZzC = zzbhh.zzi((List) unsafe.getObject(obj, j));
                    if (iZzC > 0) {
                        iZzI = zzbcj.zzI(i4);
                        iZzJ8 = zzbcj.zzJ(iZzC);
                        iZzJ4 = iZzI + iZzJ8;
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 41:
                    iZzC = zzbhh.zzg((List) unsafe.getObject(obj, j));
                    if (iZzC > 0) {
                        iZzI = zzbcj.zzI(i4);
                        iZzJ8 = zzbcj.zzJ(iZzC);
                        iZzJ4 = iZzI + iZzJ8;
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 42:
                    iZzC = zzbhh.zzb((List) unsafe.getObject(obj, j));
                    if (iZzC > 0) {
                        iZzI = zzbcj.zzI(i4);
                        iZzJ8 = zzbcj.zzJ(iZzC);
                        iZzJ4 = iZzI + iZzJ8;
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 43:
                    iZzC = zzbhh.zzw((List) unsafe.getObject(obj, j));
                    if (iZzC > 0) {
                        iZzI = zzbcj.zzI(i4);
                        iZzJ8 = zzbcj.zzJ(iZzC);
                        iZzJ4 = iZzI + iZzJ8;
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 44:
                    iZzC = zzbhh.zze((List) unsafe.getObject(obj, j));
                    if (iZzC > 0) {
                        iZzI = zzbcj.zzI(i4);
                        iZzJ8 = zzbcj.zzJ(iZzC);
                        iZzJ4 = iZzI + iZzJ8;
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 45:
                    iZzC = zzbhh.zzg((List) unsafe.getObject(obj, j));
                    if (iZzC > 0) {
                        iZzI = zzbcj.zzI(i4);
                        iZzJ8 = zzbcj.zzJ(iZzC);
                        iZzJ4 = iZzI + iZzJ8;
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 46:
                    iZzC = zzbhh.zzi((List) unsafe.getObject(obj, j));
                    if (iZzC > 0) {
                        iZzI = zzbcj.zzI(i4);
                        iZzJ8 = zzbcj.zzJ(iZzC);
                        iZzJ4 = iZzI + iZzJ8;
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 47:
                    iZzC = zzbhh.zzr((List) unsafe.getObject(obj, j));
                    if (iZzC > 0) {
                        iZzI = zzbcj.zzI(i4);
                        iZzJ8 = zzbcj.zzJ(iZzC);
                        iZzJ4 = iZzI + iZzJ8;
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 48:
                    iZzC = zzbhh.zzt((List) unsafe.getObject(obj, j));
                    if (iZzC > 0) {
                        iZzI = zzbcj.zzI(i4);
                        iZzJ8 = zzbcj.zzJ(iZzC);
                        iZzJ4 = iZzI + iZzJ8;
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 49:
                    iZzo = zzbhh.zzj(i4, (List) zzbij.zzf(obj, j), zzF(i3));
                    i2 += iZzo;
                    break;
                case 50:
                    zzbgn.zza(i4, zzbij.zzf(obj, j), zzH(i3));
                    break;
                case 51:
                    if (zzT(obj, i4, i3)) {
                        iZzJ = zzbcj.zzJ(i4 << 3);
                        iZzo = iZzJ + 8;
                        i2 += iZzo;
                    }
                    break;
                case 52:
                    if (zzT(obj, i4, i3)) {
                        iZzJ2 = zzbcj.zzJ(i4 << 3);
                        iZzo = iZzJ2 + 4;
                        i2 += iZzo;
                    }
                    break;
                case 53:
                    if (zzT(obj, i4, i3)) {
                        long jZzD = zzD(obj, j);
                        iZzJ3 = zzbcj.zzJ(i4 << 3);
                        iZzK = zzbcj.zzK(jZzD);
                        i2 += iZzJ3 + iZzK;
                    }
                    break;
                case 54:
                    if (zzT(obj, i4, i3)) {
                        long jZzD2 = zzD(obj, j);
                        iZzJ3 = zzbcj.zzJ(i4 << 3);
                        iZzK = zzbcj.zzK(jZzD2);
                        i2 += iZzJ3 + iZzK;
                    }
                    break;
                case 55:
                    if (zzT(obj, i4, i3)) {
                        int iZzs = zzs(obj, j);
                        iZzJ4 = zzbcj.zzJ(i4 << 3);
                        iZzC = zzbcj.zzC(iZzs);
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 56:
                    if (zzT(obj, i4, i3)) {
                        iZzJ = zzbcj.zzJ(i4 << 3);
                        iZzo = iZzJ + 8;
                        i2 += iZzo;
                    }
                    break;
                case 57:
                    if (zzT(obj, i4, i3)) {
                        iZzJ2 = zzbcj.zzJ(i4 << 3);
                        iZzo = iZzJ2 + 4;
                        i2 += iZzo;
                    }
                    break;
                case 58:
                    if (zzT(obj, i4, i3)) {
                        iZzJ5 = zzbcj.zzJ(i4 << 3);
                        iZzo = iZzJ5 + 1;
                        i2 += iZzo;
                    }
                    break;
                case 59:
                    if (zzT(obj, i4, i3)) {
                        Object objZzf2 = zzbij.zzf(obj, j);
                        if (objZzf2 instanceof zzbbw) {
                            iZzJ6 = zzbcj.zzJ(i4 << 3);
                            iZzd = ((zzbbw) objZzf2).zzd();
                            iZzJ7 = zzbcj.zzJ(iZzd);
                            i = iZzJ6 + iZzJ7 + iZzd;
                            i2 += i;
                        } else {
                            iZzJ4 = zzbcj.zzJ(i4 << 3);
                            iZzC = zzbcj.zzH((String) objZzf2);
                            i = iZzJ4 + iZzC;
                            i2 += i;
                        }
                    }
                    break;
                case 60:
                    if (zzT(obj, i4, i3)) {
                        iZzo = zzbhh.zzo(i4, zzbij.zzf(obj, j), zzF(i3));
                        i2 += iZzo;
                    }
                    break;
                case 61:
                    if (zzT(obj, i4, i3)) {
                        zzbbw zzbbwVar2 = (zzbbw) zzbij.zzf(obj, j);
                        iZzJ6 = zzbcj.zzJ(i4 << 3);
                        iZzd = zzbbwVar2.zzd();
                        iZzJ7 = zzbcj.zzJ(iZzd);
                        i = iZzJ6 + iZzJ7 + iZzd;
                        i2 += i;
                    }
                    break;
                case 62:
                    if (zzT(obj, i4, i3)) {
                        int iZzs2 = zzs(obj, j);
                        iZzJ4 = zzbcj.zzJ(i4 << 3);
                        iZzC = zzbcj.zzJ(iZzs2);
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 63:
                    if (zzT(obj, i4, i3)) {
                        int iZzs3 = zzs(obj, j);
                        iZzJ4 = zzbcj.zzJ(i4 << 3);
                        iZzC = zzbcj.zzC(iZzs3);
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 64:
                    if (zzT(obj, i4, i3)) {
                        iZzJ2 = zzbcj.zzJ(i4 << 3);
                        iZzo = iZzJ2 + 4;
                        i2 += iZzo;
                    }
                    break;
                case 65:
                    if (zzT(obj, i4, i3)) {
                        iZzJ = zzbcj.zzJ(i4 << 3);
                        iZzo = iZzJ + 8;
                        i2 += iZzo;
                    }
                    break;
                case 66:
                    if (zzT(obj, i4, i3)) {
                        int iZzs4 = zzs(obj, j);
                        iZzJ4 = zzbcj.zzJ(i4 << 3);
                        iZzC = zzbcj.zzJ((iZzs4 >> 31) ^ (iZzs4 + iZzs4));
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 67:
                    if (zzT(obj, i4, i3)) {
                        long jZzD3 = zzD(obj, j);
                        iZzJ4 = zzbcj.zzJ(i4 << 3);
                        iZzC = zzbcj.zzK((jZzD3 >> 63) ^ (jZzD3 + jZzD3));
                        i = iZzJ4 + iZzC;
                        i2 += i;
                    }
                    break;
                case 68:
                    if (zzT(obj, i4, i3)) {
                        iZzo = zzbcj.zzA(i4, (zzbgs) zzbij.zzf(obj, j), zzF(i3));
                        i2 += iZzo;
                    }
                    break;
            }
        }
        zzbhz zzbhzVar = this.zzo;
        return i2 + zzbhzVar.zza(zzbhzVar.zzd(obj));
    }

    private static int zzs(Object obj, long j) {
        return ((Integer) zzbij.zzf(obj, j)).intValue();
    }

    private final int zzt(Object obj, byte[] bArr, int i, int i2, int i3, long j, zzbbf zzbbfVar) throws IOException {
        Unsafe unsafe = zzb;
        Object objZzH = zzH(i3);
        Object object = unsafe.getObject(obj, j);
        if (zzbgn.zzb(object)) {
            zzbgm zzbgmVarZzb = zzbgm.zza().zzb();
            zzbgn.zzc(zzbgmVarZzb, object);
            unsafe.putObject(obj, j, zzbgmVarZzb);
        }
        throw null;
    }

    private final int zzu(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzbbf zzbbfVar) throws IOException {
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(zzbbg.zzo(bArr, i))));
                unsafe.putInt(obj, j2, i4);
                return i + 8;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(zzbbg.zzb(bArr, i))));
                unsafe.putInt(obj, j2, i4);
                return i + 4;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iZzm = zzbbg.zzm(bArr, i, zzbbfVar);
                unsafe.putObject(obj, j, Long.valueOf(zzbbfVar.zzb));
                unsafe.putInt(obj, j2, i4);
                return iZzm;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iZzj = zzbbg.zzj(bArr, i, zzbbfVar);
                unsafe.putObject(obj, j, Integer.valueOf(zzbbfVar.zza));
                unsafe.putInt(obj, j2, i4);
                return iZzj;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Long.valueOf(zzbbg.zzo(bArr, i)));
                unsafe.putInt(obj, j2, i4);
                return i + 8;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Integer.valueOf(zzbbg.zzb(bArr, i)));
                unsafe.putInt(obj, j2, i4);
                return i + 4;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int iZzm2 = zzbbg.zzm(bArr, i, zzbbfVar);
                unsafe.putObject(obj, j, Boolean.valueOf(zzbbfVar.zzb != 0));
                unsafe.putInt(obj, j2, i4);
                return iZzm2;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iZzj2 = zzbbg.zzj(bArr, i, zzbbfVar);
                int i9 = zzbbfVar.zza;
                if (i9 == 0) {
                    unsafe.putObject(obj, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !zzbio.zzf(bArr, iZzj2, iZzj2 + i9)) {
                        throw zzbfs.zzd();
                    }
                    unsafe.putObject(obj, j, new String(bArr, iZzj2, i9, zzbfq.zzb));
                    iZzj2 += i9;
                }
                unsafe.putInt(obj, j2, i4);
                return iZzj2;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iZzd = zzbbg.zzd(zzF(i8), bArr, i, i2, zzbbfVar);
                Object object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object == null) {
                    unsafe.putObject(obj, j, zzbbfVar.zzc);
                } else {
                    unsafe.putObject(obj, j, zzbfq.zzg(object, zzbbfVar.zzc));
                }
                unsafe.putInt(obj, j2, i4);
                return iZzd;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iZza = zzbbg.zza(bArr, i, zzbbfVar);
                unsafe.putObject(obj, j, zzbbfVar.zzc);
                unsafe.putInt(obj, j2, i4);
                return iZza;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iZzj3 = zzbbg.zzj(bArr, i, zzbbfVar);
                int i10 = zzbbfVar.zza;
                zzbfj zzbfjVarZzE = zzE(i8);
                if (zzbfjVarZzE == null || zzbfjVarZzE.zza(i10)) {
                    unsafe.putObject(obj, j, Integer.valueOf(i10));
                    unsafe.putInt(obj, j2, i4);
                } else {
                    zzd(obj).zzh(i3, Long.valueOf(i10));
                }
                return iZzj3;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                int iZzj4 = zzbbg.zzj(bArr, i, zzbbfVar);
                unsafe.putObject(obj, j, Integer.valueOf(zzbcc.zzs(zzbbfVar.zza)));
                unsafe.putInt(obj, j2, i4);
                return iZzj4;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int iZzm3 = zzbbg.zzm(bArr, i, zzbbfVar);
                unsafe.putObject(obj, j, Long.valueOf(zzbcc.zzt(zzbbfVar.zzb)));
                unsafe.putInt(obj, j2, i4);
                return iZzm3;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                int iZzc = zzbbg.zzc(zzF(i8), bArr, i, i2, (i3 & (-8)) | 4, zzbbfVar);
                Object object2 = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object2 == null) {
                    unsafe.putObject(obj, j, zzbbfVar.zzc);
                } else {
                    unsafe.putObject(obj, j, zzbfq.zzg(object2, zzbbfVar.zzc));
                }
                unsafe.putInt(obj, j2, i4);
                return iZzc;
            default:
                return i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x02d9, code lost:
    
        if (r0 != r5) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02db, code lost:
    
        r15 = r31;
        r14 = r32;
        r12 = r33;
        r13 = r35;
        r11 = r36;
        r10 = r19;
        r1 = r20;
        r2 = r23;
        r6 = r26;
        r7 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02f1, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0322, code lost:
    
        if (r0 != r15) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0345, code lost:
    
        if (r0 != r15) goto L102;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x008f. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zzv(java.lang.Object r32, byte[] r33, int r34, int r35, com.google.android.gms.internal.gtm.zzbbf r36) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 944
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzbgv.zzv(java.lang.Object, byte[], int, int, com.google.android.gms.internal.gtm.zzbbf):int");
    }

    private final int zzw(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzbbf zzbbfVar) throws IOException {
        int i8;
        int i9;
        int i10;
        int i11;
        int iZzj;
        int iZzj2 = i;
        Unsafe unsafe = zzb;
        zzbfp zzbfpVarZzd = (zzbfp) unsafe.getObject(obj, j2);
        if (!zzbfpVarZzd.zzc()) {
            int size = zzbfpVarZzd.size();
            zzbfpVarZzd = zzbfpVarZzd.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j2, zzbfpVarZzd);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzbej zzbejVar = (zzbej) zzbfpVarZzd;
                    int iZzj3 = zzbbg.zzj(bArr, iZzj2, zzbbfVar);
                    int i12 = zzbbfVar.zza + iZzj3;
                    while (iZzj3 < i12) {
                        zzbejVar.zze(Double.longBitsToDouble(zzbbg.zzo(bArr, iZzj3)));
                        iZzj3 += 8;
                    }
                    if (iZzj3 == i12) {
                        return iZzj3;
                    }
                    throw zzbfs.zzj();
                }
                if (i5 == 1) {
                    zzbej zzbejVar2 = (zzbej) zzbfpVarZzd;
                    zzbejVar2.zze(Double.longBitsToDouble(zzbbg.zzo(bArr, i)));
                    while (true) {
                        i8 = iZzj2 + 8;
                        if (i8 < i2) {
                            iZzj2 = zzbbg.zzj(bArr, i8, zzbbfVar);
                            if (i3 == zzbbfVar.zza) {
                                zzbejVar2.zze(Double.longBitsToDouble(zzbbg.zzo(bArr, iZzj2)));
                            }
                        }
                    }
                    return i8;
                }
                return iZzj2;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzbew zzbewVar = (zzbew) zzbfpVarZzd;
                    int iZzj4 = zzbbg.zzj(bArr, iZzj2, zzbbfVar);
                    int i13 = zzbbfVar.zza + iZzj4;
                    while (iZzj4 < i13) {
                        zzbewVar.zzf(Float.intBitsToFloat(zzbbg.zzb(bArr, iZzj4)));
                        iZzj4 += 4;
                    }
                    if (iZzj4 == i13) {
                        return iZzj4;
                    }
                    throw zzbfs.zzj();
                }
                if (i5 == 5) {
                    zzbew zzbewVar2 = (zzbew) zzbfpVarZzd;
                    zzbewVar2.zzf(Float.intBitsToFloat(zzbbg.zzb(bArr, i)));
                    while (true) {
                        i9 = iZzj2 + 4;
                        if (i9 < i2) {
                            iZzj2 = zzbbg.zzj(bArr, i9, zzbbfVar);
                            if (i3 == zzbbfVar.zza) {
                                zzbewVar2.zzf(Float.intBitsToFloat(zzbbg.zzb(bArr, iZzj2)));
                            }
                        }
                    }
                    return i9;
                }
                return iZzj2;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzbgh zzbghVar = (zzbgh) zzbfpVarZzd;
                    int iZzj5 = zzbbg.zzj(bArr, iZzj2, zzbbfVar);
                    int i14 = zzbbfVar.zza + iZzj5;
                    while (iZzj5 < i14) {
                        iZzj5 = zzbbg.zzm(bArr, iZzj5, zzbbfVar);
                        zzbghVar.zzg(zzbbfVar.zzb);
                    }
                    if (iZzj5 == i14) {
                        return iZzj5;
                    }
                    throw zzbfs.zzj();
                }
                if (i5 == 0) {
                    zzbgh zzbghVar2 = (zzbgh) zzbfpVarZzd;
                    int iZzm = zzbbg.zzm(bArr, iZzj2, zzbbfVar);
                    zzbghVar2.zzg(zzbbfVar.zzb);
                    while (iZzm < i2) {
                        int iZzj6 = zzbbg.zzj(bArr, iZzm, zzbbfVar);
                        if (i3 != zzbbfVar.zza) {
                            return iZzm;
                        }
                        iZzm = zzbbg.zzm(bArr, iZzj6, zzbbfVar);
                        zzbghVar2.zzg(zzbbfVar.zzb);
                    }
                    return iZzm;
                }
                return iZzj2;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzbbg.zzf(bArr, iZzj2, zzbfpVarZzd, zzbbfVar);
                }
                if (i5 == 0) {
                    return zzbbg.zzl(i3, bArr, i, i2, zzbfpVarZzd, zzbbfVar);
                }
                return iZzj2;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzbgh zzbghVar3 = (zzbgh) zzbfpVarZzd;
                    int iZzj7 = zzbbg.zzj(bArr, iZzj2, zzbbfVar);
                    int i15 = zzbbfVar.zza + iZzj7;
                    while (iZzj7 < i15) {
                        zzbghVar3.zzg(zzbbg.zzo(bArr, iZzj7));
                        iZzj7 += 8;
                    }
                    if (iZzj7 == i15) {
                        return iZzj7;
                    }
                    throw zzbfs.zzj();
                }
                if (i5 == 1) {
                    zzbgh zzbghVar4 = (zzbgh) zzbfpVarZzd;
                    zzbghVar4.zzg(zzbbg.zzo(bArr, i));
                    while (true) {
                        i10 = iZzj2 + 8;
                        if (i10 < i2) {
                            iZzj2 = zzbbg.zzj(bArr, i10, zzbbfVar);
                            if (i3 == zzbbfVar.zza) {
                                zzbghVar4.zzg(zzbbg.zzo(bArr, iZzj2));
                            }
                        }
                    }
                    return i10;
                }
                return iZzj2;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzbfg zzbfgVar = (zzbfg) zzbfpVarZzd;
                    int iZzj8 = zzbbg.zzj(bArr, iZzj2, zzbbfVar);
                    int i16 = zzbbfVar.zza + iZzj8;
                    while (iZzj8 < i16) {
                        zzbfgVar.zzh(zzbbg.zzb(bArr, iZzj8));
                        iZzj8 += 4;
                    }
                    if (iZzj8 == i16) {
                        return iZzj8;
                    }
                    throw zzbfs.zzj();
                }
                if (i5 == 5) {
                    zzbfg zzbfgVar2 = (zzbfg) zzbfpVarZzd;
                    zzbfgVar2.zzh(zzbbg.zzb(bArr, i));
                    while (true) {
                        i11 = iZzj2 + 4;
                        if (i11 < i2) {
                            iZzj2 = zzbbg.zzj(bArr, i11, zzbbfVar);
                            if (i3 == zzbbfVar.zza) {
                                zzbfgVar2.zzh(zzbbg.zzb(bArr, iZzj2));
                            }
                        }
                    }
                    return i11;
                }
                return iZzj2;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzbbl zzbblVar = (zzbbl) zzbfpVarZzd;
                    iZzj = zzbbg.zzj(bArr, iZzj2, zzbbfVar);
                    int i17 = zzbbfVar.zza + iZzj;
                    while (iZzj < i17) {
                        iZzj = zzbbg.zzm(bArr, iZzj, zzbbfVar);
                        zzbblVar.zze(zzbbfVar.zzb != 0);
                    }
                    if (iZzj != i17) {
                        throw zzbfs.zzj();
                    }
                    return iZzj;
                }
                if (i5 == 0) {
                    zzbbl zzbblVar2 = (zzbbl) zzbfpVarZzd;
                    int iZzm2 = zzbbg.zzm(bArr, iZzj2, zzbbfVar);
                    zzbblVar2.zze(zzbbfVar.zzb != 0);
                    while (iZzm2 < i2) {
                        int iZzj9 = zzbbg.zzj(bArr, iZzm2, zzbbfVar);
                        if (i3 != zzbbfVar.zza) {
                            return iZzm2;
                        }
                        iZzm2 = zzbbg.zzm(bArr, iZzj9, zzbbfVar);
                        zzbblVar2.zze(zzbbfVar.zzb != 0);
                    }
                    return iZzm2;
                }
                return iZzj2;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iZzj10 = zzbbg.zzj(bArr, iZzj2, zzbbfVar);
                        int i18 = zzbbfVar.zza;
                        if (i18 < 0) {
                            throw zzbfs.zzf();
                        }
                        if (i18 == 0) {
                            zzbfpVarZzd.add("");
                        } else {
                            zzbfpVarZzd.add(new String(bArr, iZzj10, i18, zzbfq.zzb));
                            iZzj10 += i18;
                        }
                        while (iZzj10 < i2) {
                            int iZzj11 = zzbbg.zzj(bArr, iZzj10, zzbbfVar);
                            if (i3 != zzbbfVar.zza) {
                                return iZzj10;
                            }
                            iZzj10 = zzbbg.zzj(bArr, iZzj11, zzbbfVar);
                            int i19 = zzbbfVar.zza;
                            if (i19 < 0) {
                                throw zzbfs.zzf();
                            }
                            if (i19 == 0) {
                                zzbfpVarZzd.add("");
                            } else {
                                zzbfpVarZzd.add(new String(bArr, iZzj10, i19, zzbfq.zzb));
                                iZzj10 += i19;
                            }
                        }
                        return iZzj10;
                    }
                    int iZzj12 = zzbbg.zzj(bArr, iZzj2, zzbbfVar);
                    int i20 = zzbbfVar.zza;
                    if (i20 < 0) {
                        throw zzbfs.zzf();
                    }
                    if (i20 == 0) {
                        zzbfpVarZzd.add("");
                    } else {
                        int i21 = iZzj12 + i20;
                        if (!zzbio.zzf(bArr, iZzj12, i21)) {
                            throw zzbfs.zzd();
                        }
                        zzbfpVarZzd.add(new String(bArr, iZzj12, i20, zzbfq.zzb));
                        iZzj12 = i21;
                    }
                    while (iZzj12 < i2) {
                        int iZzj13 = zzbbg.zzj(bArr, iZzj12, zzbbfVar);
                        if (i3 != zzbbfVar.zza) {
                            return iZzj12;
                        }
                        iZzj12 = zzbbg.zzj(bArr, iZzj13, zzbbfVar);
                        int i22 = zzbbfVar.zza;
                        if (i22 < 0) {
                            throw zzbfs.zzf();
                        }
                        if (i22 == 0) {
                            zzbfpVarZzd.add("");
                        } else {
                            int i23 = iZzj12 + i22;
                            if (!zzbio.zzf(bArr, iZzj12, i23)) {
                                throw zzbfs.zzd();
                            }
                            zzbfpVarZzd.add(new String(bArr, iZzj12, i22, zzbfq.zzb));
                            iZzj12 = i23;
                        }
                    }
                    return iZzj12;
                }
                return iZzj2;
            case 27:
                if (i5 == 2) {
                    return zzbbg.zze(zzF(i6), i3, bArr, i, i2, zzbfpVarZzd, zzbbfVar);
                }
                return iZzj2;
            case 28:
                if (i5 == 2) {
                    int iZzj14 = zzbbg.zzj(bArr, iZzj2, zzbbfVar);
                    int i24 = zzbbfVar.zza;
                    if (i24 < 0) {
                        throw zzbfs.zzf();
                    }
                    if (i24 > bArr.length - iZzj14) {
                        throw zzbfs.zzj();
                    }
                    if (i24 == 0) {
                        zzbfpVarZzd.add(zzbbw.zzb);
                    } else {
                        zzbfpVarZzd.add(zzbbw.zzn(bArr, iZzj14, i24));
                        iZzj14 += i24;
                    }
                    while (iZzj14 < i2) {
                        int iZzj15 = zzbbg.zzj(bArr, iZzj14, zzbbfVar);
                        if (i3 != zzbbfVar.zza) {
                            return iZzj14;
                        }
                        iZzj14 = zzbbg.zzj(bArr, iZzj15, zzbbfVar);
                        int i25 = zzbbfVar.zza;
                        if (i25 < 0) {
                            throw zzbfs.zzf();
                        }
                        if (i25 > bArr.length - iZzj14) {
                            throw zzbfs.zzj();
                        }
                        if (i25 == 0) {
                            zzbfpVarZzd.add(zzbbw.zzb);
                        } else {
                            zzbfpVarZzd.add(zzbbw.zzn(bArr, iZzj14, i25));
                            iZzj14 += i25;
                        }
                    }
                    return iZzj14;
                }
                return iZzj2;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        iZzj = zzbbg.zzl(i3, bArr, i, i2, zzbfpVarZzd, zzbbfVar);
                    }
                    return iZzj2;
                }
                iZzj = zzbbg.zzf(bArr, iZzj2, zzbfpVarZzd, zzbbfVar);
                zzbff zzbffVar = (zzbff) obj;
                zzbia zzbiaVar = zzbffVar.zzd;
                if (zzbiaVar == zzbia.zzc()) {
                    zzbiaVar = null;
                }
                Object objZzC = zzbhh.zzC(i4, zzbfpVarZzd, zzE(i6), zzbiaVar, this.zzo);
                if (objZzC != null) {
                    zzbffVar.zzd = (zzbia) objZzC;
                    return iZzj;
                }
                return iZzj;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzbfg zzbfgVar3 = (zzbfg) zzbfpVarZzd;
                    int iZzj16 = zzbbg.zzj(bArr, iZzj2, zzbbfVar);
                    int i26 = zzbbfVar.zza + iZzj16;
                    while (iZzj16 < i26) {
                        iZzj16 = zzbbg.zzj(bArr, iZzj16, zzbbfVar);
                        zzbfgVar3.zzh(zzbcc.zzs(zzbbfVar.zza));
                    }
                    if (iZzj16 == i26) {
                        return iZzj16;
                    }
                    throw zzbfs.zzj();
                }
                if (i5 == 0) {
                    zzbfg zzbfgVar4 = (zzbfg) zzbfpVarZzd;
                    int iZzj17 = zzbbg.zzj(bArr, iZzj2, zzbbfVar);
                    zzbfgVar4.zzh(zzbcc.zzs(zzbbfVar.zza));
                    while (iZzj17 < i2) {
                        int iZzj18 = zzbbg.zzj(bArr, iZzj17, zzbbfVar);
                        if (i3 != zzbbfVar.zza) {
                            return iZzj17;
                        }
                        iZzj17 = zzbbg.zzj(bArr, iZzj18, zzbbfVar);
                        zzbfgVar4.zzh(zzbcc.zzs(zzbbfVar.zza));
                    }
                    return iZzj17;
                }
                return iZzj2;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzbgh zzbghVar5 = (zzbgh) zzbfpVarZzd;
                    int iZzj19 = zzbbg.zzj(bArr, iZzj2, zzbbfVar);
                    int i27 = zzbbfVar.zza + iZzj19;
                    while (iZzj19 < i27) {
                        iZzj19 = zzbbg.zzm(bArr, iZzj19, zzbbfVar);
                        zzbghVar5.zzg(zzbcc.zzt(zzbbfVar.zzb));
                    }
                    if (iZzj19 == i27) {
                        return iZzj19;
                    }
                    throw zzbfs.zzj();
                }
                if (i5 == 0) {
                    zzbgh zzbghVar6 = (zzbgh) zzbfpVarZzd;
                    int iZzm3 = zzbbg.zzm(bArr, iZzj2, zzbbfVar);
                    zzbghVar6.zzg(zzbcc.zzt(zzbbfVar.zzb));
                    while (iZzm3 < i2) {
                        int iZzj20 = zzbbg.zzj(bArr, iZzm3, zzbbfVar);
                        if (i3 != zzbbfVar.zza) {
                            return iZzm3;
                        }
                        iZzm3 = zzbbg.zzm(bArr, iZzj20, zzbbfVar);
                        zzbghVar6.zzg(zzbcc.zzt(zzbbfVar.zzb));
                    }
                    return iZzm3;
                }
                return iZzj2;
            default:
                if (i5 == 3) {
                    zzbhf zzbhfVarZzF = zzF(i6);
                    int i28 = (i3 & (-8)) | 4;
                    int iZzc = zzbbg.zzc(zzbhfVarZzF, bArr, i, i2, i28, zzbbfVar);
                    zzbfpVarZzd.add(zzbbfVar.zzc);
                    while (iZzc < i2) {
                        int iZzj21 = zzbbg.zzj(bArr, iZzc, zzbbfVar);
                        if (i3 != zzbbfVar.zza) {
                            return iZzc;
                        }
                        iZzc = zzbbg.zzc(zzbhfVarZzF, bArr, iZzj21, i2, i28, zzbbfVar);
                        zzbfpVarZzd.add(zzbbfVar.zzc);
                    }
                    return iZzc;
                }
                return iZzj2;
        }
    }

    private final int zzx(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzA(i, 0);
    }

    private final int zzy(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzA(i, i2);
    }

    private final int zzz(int i) {
        return this.zzc[i + 2];
    }

    @Override // com.google.android.gms.internal.gtm.zzbhf
    public final int zza(Object obj) {
        return this.zzj ? zzr(obj) : zzq(obj);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhf
    public final int zzb(Object obj) {
        int i;
        int iZzc;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzC = zzC(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzC;
            int iHashCode = 37;
            switch (zzB(iZzC)) {
                case 0:
                    i = i2 * 53;
                    iZzc = zzbfq.zzc(Double.doubleToLongBits(zzbij.zza(obj, j)));
                    i2 = i + iZzc;
                    break;
                case 1:
                    i = i2 * 53;
                    iZzc = Float.floatToIntBits(zzbij.zzb(obj, j));
                    i2 = i + iZzc;
                    break;
                case 2:
                    i = i2 * 53;
                    iZzc = zzbfq.zzc(zzbij.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 3:
                    i = i2 * 53;
                    iZzc = zzbfq.zzc(zzbij.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 4:
                    i = i2 * 53;
                    iZzc = zzbij.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 5:
                    i = i2 * 53;
                    iZzc = zzbfq.zzc(zzbij.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 6:
                    i = i2 * 53;
                    iZzc = zzbij.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 7:
                    i = i2 * 53;
                    iZzc = zzbfq.zza(zzbij.zzw(obj, j));
                    i2 = i + iZzc;
                    break;
                case 8:
                    i = i2 * 53;
                    iZzc = ((String) zzbij.zzf(obj, j)).hashCode();
                    i2 = i + iZzc;
                    break;
                case 9:
                    Object objZzf = zzbij.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZzc = zzbij.zzf(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 11:
                    i = i2 * 53;
                    iZzc = zzbij.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 12:
                    i = i2 * 53;
                    iZzc = zzbij.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 13:
                    i = i2 * 53;
                    iZzc = zzbij.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 14:
                    i = i2 * 53;
                    iZzc = zzbfq.zzc(zzbij.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 15:
                    i = i2 * 53;
                    iZzc = zzbij.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 16:
                    i = i2 * 53;
                    iZzc = zzbfq.zzc(zzbij.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 17:
                    Object objZzf2 = zzbij.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iZzc = zzbij.zzf(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 50:
                    i = i2 * 53;
                    iZzc = zzbij.zzf(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 51:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzbfq.zzc(Double.doubleToLongBits(zzo(obj, j)));
                        i2 = i + iZzc;
                    }
                    break;
                case 52:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = Float.floatToIntBits(zzp(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 53:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzbfq.zzc(zzD(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 54:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzbfq.zzc(zzD(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 55:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzs(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 56:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzbfq.zzc(zzD(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 57:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzs(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 58:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzbfq.zza(zzU(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 59:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = ((String) zzbij.zzf(obj, j)).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
                case 60:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzbij.zzf(obj, j).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
                case 61:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzbij.zzf(obj, j).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
                case 62:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzs(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 63:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzs(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 64:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzs(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 65:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzbfq.zzc(zzD(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 66:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzs(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 67:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzbfq.zzc(zzD(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 68:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzbij.zzf(obj, j).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzo.zzd(obj).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzp.zzb(obj).zza.hashCode() : iHashCode2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:200:0x0615, code lost:
    
        if (r2 == r3) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0617, code lost:
    
        r30.putInt(r13, r2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x061d, code lost:
    
        r2 = r9.zzl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0621, code lost:
    
        if (r2 >= r9.zzm) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x0623, code lost:
    
        r9.zzG(r13, r9.zzk[r2], null, r9.zzo);
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0630, code lost:
    
        if (r7 != 0) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0632, code lost:
    
        if (r0 != r6) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0639, code lost:
    
        throw com.google.android.gms.internal.gtm.zzbfs.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x063a, code lost:
    
        if (r0 > r6) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x063c, code lost:
    
        if (r1 != r7) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x063e, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0643, code lost:
    
        throw com.google.android.gms.internal.gtm.zzbfs.zzg();
     */
    /* JADX WARN: Removed duplicated region for block: B:184:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x05b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int zzc(java.lang.Object r33, byte[] r34, int r35, int r36, int r37, com.google.android.gms.internal.gtm.zzbbf r38) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1682
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzbgv.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.gtm.zzbbf):int");
    }

    @Override // com.google.android.gms.internal.gtm.zzbhf
    public final Object zze() {
        return ((zzbff) this.zzg).zzb(4, null, null);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhf
    public final void zzf(Object obj) {
        int i;
        int i2 = this.zzl;
        while (true) {
            i = this.zzm;
            if (i2 >= i) {
                break;
            }
            long jZzC = zzC(this.zzk[i2]) & 1048575;
            Object objZzf = zzbij.zzf(obj, jZzC);
            if (objZzf != null) {
                ((zzbgm) objZzf).zzc();
                zzbij.zzs(obj, jZzC, objZzf);
            }
            i2++;
        }
        int length = this.zzk.length;
        while (i < length) {
            this.zzn.zzb(obj, this.zzk[i]);
            i++;
        }
        this.zzo.zzm(obj);
        if (this.zzh) {
            this.zzp.zzf(obj);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbhf
    public final void zzh(Object obj, zzbhe zzbheVar, zzbep zzbepVar) throws IOException {
        zzbepVar.getClass();
        zzbhz zzbhzVar = this.zzo;
        zzbeq zzbeqVar = this.zzp;
        zzbeu zzbeuVarZzc = null;
        Object objZze = null;
        while (true) {
            try {
                int iZzc = zzbheVar.zzc();
                int iZzx = zzx(iZzc);
                if (iZzx >= 0) {
                    int iZzC = zzC(iZzx);
                    try {
                        switch (zzB(iZzC)) {
                            case 0:
                                zzbij.zzo(obj, iZzC & 1048575, zzbheVar.zza());
                                zzM(obj, iZzx);
                                break;
                            case 1:
                                zzbij.zzp(obj, iZzC & 1048575, zzbheVar.zzb());
                                zzM(obj, iZzx);
                                break;
                            case 2:
                                zzbij.zzr(obj, iZzC & 1048575, zzbheVar.zzl());
                                zzM(obj, iZzx);
                                break;
                            case 3:
                                zzbij.zzr(obj, iZzC & 1048575, zzbheVar.zzo());
                                zzM(obj, iZzx);
                                break;
                            case 4:
                                zzbij.zzq(obj, iZzC & 1048575, zzbheVar.zzg());
                                zzM(obj, iZzx);
                                break;
                            case 5:
                                zzbij.zzr(obj, iZzC & 1048575, zzbheVar.zzk());
                                zzM(obj, iZzx);
                                break;
                            case 6:
                                zzbij.zzq(obj, iZzC & 1048575, zzbheVar.zzf());
                                zzM(obj, iZzx);
                                break;
                            case 7:
                                zzbij.zzm(obj, iZzC & 1048575, zzbheVar.zzS());
                                zzM(obj, iZzx);
                                break;
                            case 8:
                                zzL(obj, iZzC, zzbheVar);
                                zzM(obj, iZzx);
                                break;
                            case 9:
                                if (zzQ(obj, iZzx)) {
                                    long j = iZzC & 1048575;
                                    zzbij.zzs(obj, j, zzbfq.zzg(zzbij.zzf(obj, j), zzbheVar.zzu(zzF(iZzx), zzbepVar)));
                                } else {
                                    zzbij.zzs(obj, iZzC & 1048575, zzbheVar.zzu(zzF(iZzx), zzbepVar));
                                    zzM(obj, iZzx);
                                }
                                break;
                            case 10:
                                zzbij.zzs(obj, iZzC & 1048575, zzbheVar.zzq());
                                zzM(obj, iZzx);
                                break;
                            case 11:
                                zzbij.zzq(obj, iZzC & 1048575, zzbheVar.zzj());
                                zzM(obj, iZzx);
                                break;
                            case 12:
                                int iZze = zzbheVar.zze();
                                zzbfj zzbfjVarZzE = zzE(iZzx);
                                if (zzbfjVarZzE == null || zzbfjVarZzE.zza(iZze)) {
                                    zzbij.zzq(obj, iZzC & 1048575, iZze);
                                    zzM(obj, iZzx);
                                } else {
                                    objZze = zzbhh.zzD(iZzc, iZze, objZze, zzbhzVar);
                                }
                                break;
                            case 13:
                                zzbij.zzq(obj, iZzC & 1048575, zzbheVar.zzh());
                                zzM(obj, iZzx);
                                break;
                            case 14:
                                zzbij.zzr(obj, iZzC & 1048575, zzbheVar.zzm());
                                zzM(obj, iZzx);
                                break;
                            case 15:
                                zzbij.zzq(obj, iZzC & 1048575, zzbheVar.zzi());
                                zzM(obj, iZzx);
                                break;
                            case 16:
                                zzbij.zzr(obj, iZzC & 1048575, zzbheVar.zzn());
                                zzM(obj, iZzx);
                                break;
                            case 17:
                                if (zzQ(obj, iZzx)) {
                                    long j2 = iZzC & 1048575;
                                    zzbij.zzs(obj, j2, zzbfq.zzg(zzbij.zzf(obj, j2), zzbheVar.zzs(zzF(iZzx), zzbepVar)));
                                } else {
                                    zzbij.zzs(obj, iZzC & 1048575, zzbheVar.zzs(zzF(iZzx), zzbepVar));
                                    zzM(obj, iZzx);
                                }
                                break;
                            case 18:
                                zzbheVar.zzA(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 19:
                                zzbheVar.zzE(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 20:
                                zzbheVar.zzH(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 21:
                                zzbheVar.zzR(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 22:
                                zzbheVar.zzG(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 23:
                                zzbheVar.zzD(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 24:
                                zzbheVar.zzC(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 25:
                                zzbheVar.zzy(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 26:
                                if (zzP(iZzC)) {
                                    zzbheVar.zzP(this.zzn.zza(obj, iZzC & 1048575));
                                } else {
                                    zzbheVar.zzN(this.zzn.zza(obj, iZzC & 1048575));
                                }
                                break;
                            case 27:
                                zzbheVar.zzI(this.zzn.zza(obj, iZzC & 1048575), zzF(iZzx), zzbepVar);
                                break;
                            case 28:
                                zzbheVar.zzz(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 29:
                                zzbheVar.zzQ(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 30:
                                List listZza = this.zzn.zza(obj, iZzC & 1048575);
                                zzbheVar.zzB(listZza);
                                objZze = zzbhh.zzC(iZzc, listZza, zzE(iZzx), objZze, zzbhzVar);
                                break;
                            case 31:
                                zzbheVar.zzJ(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 32:
                                zzbheVar.zzK(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 33:
                                zzbheVar.zzL(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 34:
                                zzbheVar.zzM(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 35:
                                zzbheVar.zzA(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 36:
                                zzbheVar.zzE(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 37:
                                zzbheVar.zzH(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 38:
                                zzbheVar.zzR(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 39:
                                zzbheVar.zzG(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 40:
                                zzbheVar.zzD(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 41:
                                zzbheVar.zzC(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 42:
                                zzbheVar.zzy(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 43:
                                zzbheVar.zzQ(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 44:
                                List listZza2 = this.zzn.zza(obj, iZzC & 1048575);
                                zzbheVar.zzB(listZza2);
                                objZze = zzbhh.zzC(iZzc, listZza2, zzE(iZzx), objZze, zzbhzVar);
                                break;
                            case 45:
                                zzbheVar.zzJ(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 46:
                                zzbheVar.zzK(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 47:
                                zzbheVar.zzL(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 48:
                                zzbheVar.zzM(this.zzn.zza(obj, iZzC & 1048575));
                                break;
                            case 49:
                                zzbheVar.zzF(this.zzn.zza(obj, iZzC & 1048575), zzF(iZzx), zzbepVar);
                                break;
                            case 50:
                                Object objZzH = zzH(iZzx);
                                long jZzC = zzC(iZzx) & 1048575;
                                Object objZzf = zzbij.zzf(obj, jZzC);
                                if (objZzf == null) {
                                    objZzf = zzbgm.zza().zzb();
                                    zzbij.zzs(obj, jZzC, objZzf);
                                } else if (zzbgn.zzb(objZzf)) {
                                    Object objZzb = zzbgm.zza().zzb();
                                    zzbgn.zzc(objZzb, objZzf);
                                    zzbij.zzs(obj, jZzC, objZzb);
                                    objZzf = objZzb;
                                }
                                throw null;
                            case 51:
                                zzbij.zzs(obj, iZzC & 1048575, Double.valueOf(zzbheVar.zza()));
                                zzN(obj, iZzc, iZzx);
                                break;
                            case 52:
                                zzbij.zzs(obj, iZzC & 1048575, Float.valueOf(zzbheVar.zzb()));
                                zzN(obj, iZzc, iZzx);
                                break;
                            case 53:
                                zzbij.zzs(obj, iZzC & 1048575, Long.valueOf(zzbheVar.zzl()));
                                zzN(obj, iZzc, iZzx);
                                break;
                            case 54:
                                zzbij.zzs(obj, iZzC & 1048575, Long.valueOf(zzbheVar.zzo()));
                                zzN(obj, iZzc, iZzx);
                                break;
                            case 55:
                                zzbij.zzs(obj, iZzC & 1048575, Integer.valueOf(zzbheVar.zzg()));
                                zzN(obj, iZzc, iZzx);
                                break;
                            case 56:
                                zzbij.zzs(obj, iZzC & 1048575, Long.valueOf(zzbheVar.zzk()));
                                zzN(obj, iZzc, iZzx);
                                break;
                            case 57:
                                zzbij.zzs(obj, iZzC & 1048575, Integer.valueOf(zzbheVar.zzf()));
                                zzN(obj, iZzc, iZzx);
                                break;
                            case 58:
                                zzbij.zzs(obj, iZzC & 1048575, Boolean.valueOf(zzbheVar.zzS()));
                                zzN(obj, iZzc, iZzx);
                                break;
                            case 59:
                                zzL(obj, iZzC, zzbheVar);
                                zzN(obj, iZzc, iZzx);
                                break;
                            case 60:
                                if (zzT(obj, iZzc, iZzx)) {
                                    long j3 = iZzC & 1048575;
                                    zzbij.zzs(obj, j3, zzbfq.zzg(zzbij.zzf(obj, j3), zzbheVar.zzu(zzF(iZzx), zzbepVar)));
                                } else {
                                    zzbij.zzs(obj, iZzC & 1048575, zzbheVar.zzu(zzF(iZzx), zzbepVar));
                                    zzM(obj, iZzx);
                                }
                                zzN(obj, iZzc, iZzx);
                                break;
                            case 61:
                                zzbij.zzs(obj, iZzC & 1048575, zzbheVar.zzq());
                                zzN(obj, iZzc, iZzx);
                                break;
                            case 62:
                                zzbij.zzs(obj, iZzC & 1048575, Integer.valueOf(zzbheVar.zzj()));
                                zzN(obj, iZzc, iZzx);
                                break;
                            case 63:
                                int iZze2 = zzbheVar.zze();
                                zzbfj zzbfjVarZzE2 = zzE(iZzx);
                                if (zzbfjVarZzE2 == null || zzbfjVarZzE2.zza(iZze2)) {
                                    zzbij.zzs(obj, iZzC & 1048575, Integer.valueOf(iZze2));
                                    zzN(obj, iZzc, iZzx);
                                } else {
                                    objZze = zzbhh.zzD(iZzc, iZze2, objZze, zzbhzVar);
                                }
                                break;
                            case 64:
                                zzbij.zzs(obj, iZzC & 1048575, Integer.valueOf(zzbheVar.zzh()));
                                zzN(obj, iZzc, iZzx);
                                break;
                            case 65:
                                zzbij.zzs(obj, iZzC & 1048575, Long.valueOf(zzbheVar.zzm()));
                                zzN(obj, iZzc, iZzx);
                                break;
                            case 66:
                                zzbij.zzs(obj, iZzC & 1048575, Integer.valueOf(zzbheVar.zzi()));
                                zzN(obj, iZzc, iZzx);
                                break;
                            case 67:
                                zzbij.zzs(obj, iZzC & 1048575, Long.valueOf(zzbheVar.zzn()));
                                zzN(obj, iZzc, iZzx);
                                break;
                            case 68:
                                zzbij.zzs(obj, iZzC & 1048575, zzbheVar.zzs(zzF(iZzx), zzbepVar));
                                zzN(obj, iZzc, iZzx);
                                break;
                            default:
                                if (objZze == null) {
                                    objZze = zzbhzVar.zzf();
                                }
                                if (!zzbhzVar.zzp(objZze, zzbheVar)) {
                                    for (int i = this.zzl; i < this.zzm; i++) {
                                        zzG(obj, this.zzk[i], objZze, zzbhzVar);
                                    }
                                    zzbhzVar.zzn(obj, objZze);
                                    return;
                                }
                                break;
                                break;
                        }
                    } catch (zzbfr unused) {
                        zzbhzVar.zzq(zzbheVar);
                        if (objZze == null) {
                            objZze = zzbhzVar.zzc(obj);
                        }
                        if (!zzbhzVar.zzp(objZze, zzbheVar)) {
                            for (int i2 = this.zzl; i2 < this.zzm; i2++) {
                                zzG(obj, this.zzk[i2], objZze, zzbhzVar);
                            }
                            if (objZze != null) {
                                zzbhzVar.zzn(obj, objZze);
                                return;
                            }
                            return;
                        }
                    }
                } else {
                    if (iZzc == Integer.MAX_VALUE) {
                        for (int i3 = this.zzl; i3 < this.zzm; i3++) {
                            zzG(obj, this.zzk[i3], objZze, zzbhzVar);
                        }
                        if (objZze != null) {
                            zzbhzVar.zzn(obj, objZze);
                            return;
                        }
                        return;
                    }
                    Object objZzd = !this.zzh ? null : zzbeqVar.zzd(zzbepVar, this.zzg, iZzc);
                    if (objZzd != null) {
                        if (zzbeuVarZzc == null) {
                            zzbeuVarZzc = zzbeqVar.zzc(obj);
                        }
                        zzbeu zzbeuVar = zzbeuVarZzc;
                        objZze = zzbeqVar.zze(zzbheVar, objZzd, zzbepVar, zzbeuVar, objZze, zzbhzVar);
                        zzbeuVarZzc = zzbeuVar;
                    } else {
                        zzbhzVar.zzq(zzbheVar);
                        if (objZze == null) {
                            objZze = zzbhzVar.zzc(obj);
                        }
                        if (!zzbhzVar.zzp(objZze, zzbheVar)) {
                            for (int i4 = this.zzl; i4 < this.zzm; i4++) {
                                zzG(obj, this.zzk[i4], objZze, zzbhzVar);
                            }
                            if (objZze != null) {
                                zzbhzVar.zzn(obj, objZze);
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                for (int i5 = this.zzl; i5 < this.zzm; i5++) {
                    zzG(obj, this.zzk[i5], objZze, zzbhzVar);
                }
                if (objZze != null) {
                    zzbhzVar.zzn(obj, objZze);
                }
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbhf
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzbbf zzbbfVar) throws IOException {
        if (this.zzj) {
            zzv(obj, bArr, i, i2, zzbbfVar);
        } else {
            zzc(obj, bArr, i, i2, 0, zzbbfVar);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbhf
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzH;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzC = zzC(i);
            long j = iZzC & 1048575;
            switch (zzB(iZzC)) {
                case 0:
                    if (!zzO(obj, obj2, i) || Double.doubleToLongBits(zzbij.zza(obj, j)) != Double.doubleToLongBits(zzbij.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzO(obj, obj2, i) || Float.floatToIntBits(zzbij.zzb(obj, j)) != Float.floatToIntBits(zzbij.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzO(obj, obj2, i) || zzbij.zzd(obj, j) != zzbij.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzO(obj, obj2, i) || zzbij.zzd(obj, j) != zzbij.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzO(obj, obj2, i) || zzbij.zzc(obj, j) != zzbij.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzO(obj, obj2, i) || zzbij.zzd(obj, j) != zzbij.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzO(obj, obj2, i) || zzbij.zzc(obj, j) != zzbij.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzO(obj, obj2, i) || zzbij.zzw(obj, j) != zzbij.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzO(obj, obj2, i) || !zzbhh.zzH(zzbij.zzf(obj, j), zzbij.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzO(obj, obj2, i) || !zzbhh.zzH(zzbij.zzf(obj, j), zzbij.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzO(obj, obj2, i) || !zzbhh.zzH(zzbij.zzf(obj, j), zzbij.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzO(obj, obj2, i) || zzbij.zzc(obj, j) != zzbij.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzO(obj, obj2, i) || zzbij.zzc(obj, j) != zzbij.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzO(obj, obj2, i) || zzbij.zzc(obj, j) != zzbij.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzO(obj, obj2, i) || zzbij.zzd(obj, j) != zzbij.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzO(obj, obj2, i) || zzbij.zzc(obj, j) != zzbij.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzO(obj, obj2, i) || zzbij.zzd(obj, j) != zzbij.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzO(obj, obj2, i) || !zzbhh.zzH(zzbij.zzf(obj, j), zzbij.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zZzH = zzbhh.zzH(zzbij.zzf(obj, j), zzbij.zzf(obj2, j));
                    break;
                case 50:
                    zZzH = zzbhh.zzH(zzbij.zzf(obj, j), zzbij.zzf(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jZzz = zzz(i) & 1048575;
                    if (zzbij.zzc(obj, jZzz) != zzbij.zzc(obj2, jZzz) || !zzbhh.zzH(zzbij.zzf(obj, j), zzbij.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    break;
            }
            if (!zZzH) {
                return false;
            }
        }
        if (!this.zzo.zzd(obj).equals(this.zzo.zzd(obj2))) {
            return false;
        }
        if (this.zzh) {
            return this.zzp.zzb(obj).equals(this.zzp.zzb(obj2));
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009b  */
    @Override // com.google.android.gms.internal.gtm.zzbhf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzk(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzbgv.zzk(java.lang.Object):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // com.google.android.gms.internal.gtm.zzbhf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzn(java.lang.Object r13, com.google.android.gms.internal.gtm.zzbck r14) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzbgv.zzn(java.lang.Object, com.google.android.gms.internal.gtm.zzbck):void");
    }

    @Override // com.google.android.gms.internal.gtm.zzbhf
    public final void zzg(Object obj, Object obj2) {
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzC = zzC(i);
            long j = 1048575 & iZzC;
            int i2 = this.zzc[i];
            switch (zzB(iZzC)) {
                case 0:
                    if (zzQ(obj2, i)) {
                        zzbij.zzo(obj, j, zzbij.zza(obj2, j));
                        zzM(obj, i);
                    }
                    break;
                case 1:
                    if (zzQ(obj2, i)) {
                        zzbij.zzp(obj, j, zzbij.zzb(obj2, j));
                        zzM(obj, i);
                    }
                    break;
                case 2:
                    if (zzQ(obj2, i)) {
                        zzbij.zzr(obj, j, zzbij.zzd(obj2, j));
                        zzM(obj, i);
                    }
                    break;
                case 3:
                    if (zzQ(obj2, i)) {
                        zzbij.zzr(obj, j, zzbij.zzd(obj2, j));
                        zzM(obj, i);
                    }
                    break;
                case 4:
                    if (zzQ(obj2, i)) {
                        zzbij.zzq(obj, j, zzbij.zzc(obj2, j));
                        zzM(obj, i);
                    }
                    break;
                case 5:
                    if (zzQ(obj2, i)) {
                        zzbij.zzr(obj, j, zzbij.zzd(obj2, j));
                        zzM(obj, i);
                    }
                    break;
                case 6:
                    if (zzQ(obj2, i)) {
                        zzbij.zzq(obj, j, zzbij.zzc(obj2, j));
                        zzM(obj, i);
                    }
                    break;
                case 7:
                    if (zzQ(obj2, i)) {
                        zzbij.zzm(obj, j, zzbij.zzw(obj2, j));
                        zzM(obj, i);
                    }
                    break;
                case 8:
                    if (zzQ(obj2, i)) {
                        zzbij.zzs(obj, j, zzbij.zzf(obj2, j));
                        zzM(obj, i);
                    }
                    break;
                case 9:
                    zzJ(obj, obj2, i);
                    break;
                case 10:
                    if (zzQ(obj2, i)) {
                        zzbij.zzs(obj, j, zzbij.zzf(obj2, j));
                        zzM(obj, i);
                    }
                    break;
                case 11:
                    if (zzQ(obj2, i)) {
                        zzbij.zzq(obj, j, zzbij.zzc(obj2, j));
                        zzM(obj, i);
                    }
                    break;
                case 12:
                    if (zzQ(obj2, i)) {
                        zzbij.zzq(obj, j, zzbij.zzc(obj2, j));
                        zzM(obj, i);
                    }
                    break;
                case 13:
                    if (zzQ(obj2, i)) {
                        zzbij.zzq(obj, j, zzbij.zzc(obj2, j));
                        zzM(obj, i);
                    }
                    break;
                case 14:
                    if (zzQ(obj2, i)) {
                        zzbij.zzr(obj, j, zzbij.zzd(obj2, j));
                        zzM(obj, i);
                    }
                    break;
                case 15:
                    if (zzQ(obj2, i)) {
                        zzbij.zzq(obj, j, zzbij.zzc(obj2, j));
                        zzM(obj, i);
                    }
                    break;
                case 16:
                    if (zzQ(obj2, i)) {
                        zzbij.zzr(obj, j, zzbij.zzd(obj2, j));
                        zzM(obj, i);
                    }
                    break;
                case 17:
                    zzJ(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzn.zzc(obj, obj2, j);
                    break;
                case 50:
                    zzbhh.zzI(this.zzr, obj, obj2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzT(obj2, i2, i)) {
                        zzbij.zzs(obj, j, zzbij.zzf(obj2, j));
                        zzN(obj, i2, i);
                    }
                    break;
                case 60:
                    zzK(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzT(obj2, i2, i)) {
                        zzbij.zzs(obj, j, zzbij.zzf(obj2, j));
                        zzN(obj, i2, i);
                    }
                    break;
                case 68:
                    zzK(obj, obj2, i);
                    break;
            }
        }
        zzbhh.zzF(this.zzo, obj, obj2);
        if (this.zzh) {
            zzbhh.zzE(this.zzp, obj, obj2);
        }
    }
}
