package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbhh {
    private static final Class zza;
    private static final zzbhz zzb;
    private static final zzbhz zzc;
    private static final zzbhz zzd;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
        zzb = zzab(false);
        zzc = zzab(true);
        zzd = new zzbib();
    }

    public static zzbhz zzA() {
        return zzc;
    }

    public static zzbhz zzB() {
        return zzd;
    }

    static Object zzC(int i, List list, zzbfj zzbfjVar, Object obj, zzbhz zzbhzVar) {
        if (zzbfjVar == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int iIntValue = ((Integer) list.get(i3)).intValue();
                if (zzbfjVar.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(iIntValue));
                    }
                    i2++;
                } else {
                    obj = zzD(i, iIntValue, obj, zzbhzVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!zzbfjVar.zza(iIntValue2)) {
                    obj = zzD(i, iIntValue2, obj, zzbhzVar);
                    it.remove();
                }
            }
        }
        return obj;
    }

    static Object zzD(int i, int i2, Object obj, zzbhz zzbhzVar) {
        if (obj == null) {
            obj = zzbhzVar.zzf();
        }
        zzbhzVar.zzl(obj, i, i2);
        return obj;
    }

    static void zzE(zzbeq zzbeqVar, Object obj, Object obj2) {
        zzbeu zzbeuVarZzb = zzbeqVar.zzb(obj2);
        if (zzbeuVarZzb.zza.isEmpty()) {
            return;
        }
        zzbeqVar.zzc(obj).zzj(zzbeuVarZzb);
    }

    static void zzF(zzbhz zzbhzVar, Object obj, Object obj2) {
        zzbhzVar.zzo(obj, zzbhzVar.zze(zzbhzVar.zzd(obj), zzbhzVar.zzd(obj2)));
    }

    public static void zzG(Class cls) {
        Class cls2;
        if (!zzbff.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean zzH(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static void zzI(zzbgn zzbgnVar, Object obj, Object obj2, long j) {
        zzbij.zzs(obj, j, zzbgn.zzc(zzbij.zzf(obj, j), zzbij.zzf(obj2, j)));
    }

    public static void zzJ(int i, List list, zzbck zzbckVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbckVar.zzc(i, list, z);
    }

    public static void zzK(int i, List list, zzbck zzbckVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbckVar.zze(i, list);
    }

    public static void zzL(int i, List list, zzbck zzbckVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbckVar.zzg(i, list, z);
    }

    public static void zzM(int i, List list, zzbck zzbckVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbckVar.zzj(i, list, z);
    }

    public static void zzN(int i, List list, zzbck zzbckVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbckVar.zzl(i, list, z);
    }

    public static void zzO(int i, List list, zzbck zzbckVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbckVar.zzn(i, list, z);
    }

    public static void zzP(int i, List list, zzbck zzbckVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbckVar.zzp(i, list, z);
    }

    public static void zzQ(int i, List list, zzbck zzbckVar, zzbhf zzbhfVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzbckVar.zzq(i, list.get(i2), zzbhfVar);
        }
    }

    public static void zzR(int i, List list, zzbck zzbckVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbckVar.zzs(i, list, z);
    }

    public static void zzS(int i, List list, zzbck zzbckVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbckVar.zzu(i, list, z);
    }

    public static void zzT(int i, List list, zzbck zzbckVar, zzbhf zzbhfVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzbckVar.zzv(i, list.get(i2), zzbhfVar);
        }
    }

    public static void zzU(int i, List list, zzbck zzbckVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbckVar.zzy(i, list, z);
    }

    public static void zzV(int i, List list, zzbck zzbckVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbckVar.zzA(i, list, z);
    }

    public static void zzW(int i, List list, zzbck zzbckVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbckVar.zzC(i, list, z);
    }

    public static void zzX(int i, List list, zzbck zzbckVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbckVar.zzE(i, list, z);
    }

    public static void zzY(int i, List list, zzbck zzbckVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbckVar.zzH(i, list);
    }

    public static void zzZ(int i, List list, zzbck zzbckVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbckVar.zzJ(i, list, z);
    }

    static int zza(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzbcj.zzJ(i << 3) + 1);
    }

    public static void zzaa(int i, List list, zzbck zzbckVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzbckVar.zzL(i, list, z);
    }

    private static zzbhz zzab(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzbhz) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    static int zzb(List list) {
        return list.size();
    }

    static int zzc(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzI = size * zzbcj.zzI(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iZzI += zzbcj.zzz((zzbbw) list.get(i2));
        }
        return iZzI;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzbcj.zzI(i));
    }

    static int zze(List list) {
        int iZzC;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbfg) {
            zzbfg zzbfgVar = (zzbfg) list;
            iZzC = 0;
            while (i < size) {
                iZzC += zzbcj.zzC(zzbfgVar.zze(i));
                i++;
            }
        } else {
            iZzC = 0;
            while (i < size) {
                iZzC += zzbcj.zzC(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzC;
    }

    static int zzf(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzbcj.zzJ(i << 3) + 4);
    }

    static int zzg(List list) {
        return list.size() * 4;
    }

    static int zzh(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzbcj.zzJ(i << 3) + 8);
    }

    static int zzi(List list) {
        return list.size() * 8;
    }

    static int zzj(int i, List list, zzbhf zzbhfVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzA = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzA += zzbcj.zzA(i, (zzbgs) list.get(i2), zzbhfVar);
        }
        return iZzA;
    }

    static int zzk(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzbcj.zzI(i));
    }

    static int zzl(List list) {
        int iZzC;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbfg) {
            zzbfg zzbfgVar = (zzbfg) list;
            iZzC = 0;
            while (i < size) {
                iZzC += zzbcj.zzC(zzbfgVar.zze(i));
                i++;
            }
        } else {
            iZzC = 0;
            while (i < size) {
                iZzC += zzbcj.zzC(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzC;
    }

    static int zzm(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzn(list) + (list.size() * zzbcj.zzI(i));
    }

    static int zzn(List list) {
        int iZzK;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbgh) {
            zzbgh zzbghVar = (zzbgh) list;
            iZzK = 0;
            while (i < size) {
                iZzK += zzbcj.zzK(zzbghVar.zze(i));
                i++;
            }
        } else {
            iZzK = 0;
            while (i < size) {
                iZzK += zzbcj.zzK(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzK;
    }

    static int zzo(int i, Object obj, zzbhf zzbhfVar) {
        if (!(obj instanceof zzbfy)) {
            return zzbcj.zzJ(i << 3) + zzbcj.zzF((zzbgs) obj, zzbhfVar);
        }
        int iZzJ = zzbcj.zzJ(i << 3);
        int iZza = ((zzbfy) obj).zza();
        return iZzJ + zzbcj.zzJ(iZza) + iZza;
    }

    static int zzp(int i, List list, zzbhf zzbhfVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzI = zzbcj.zzI(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            iZzI += obj instanceof zzbfy ? zzbcj.zzD((zzbfy) obj) : zzbcj.zzF((zzbgs) obj, zzbhfVar);
        }
        return iZzI;
    }

    static int zzq(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzbcj.zzI(i));
    }

    static int zzr(List list) {
        int iZzJ;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbfg) {
            zzbfg zzbfgVar = (zzbfg) list;
            iZzJ = 0;
            while (i < size) {
                int iZze = zzbfgVar.zze(i);
                iZzJ += zzbcj.zzJ((iZze >> 31) ^ (iZze + iZze));
                i++;
            }
        } else {
            iZzJ = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzJ += zzbcj.zzJ((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
        }
        return iZzJ;
    }

    static int zzs(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzbcj.zzI(i));
    }

    static int zzt(List list) {
        int iZzK;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbgh) {
            zzbgh zzbghVar = (zzbgh) list;
            iZzK = 0;
            while (i < size) {
                long jZze = zzbghVar.zze(i);
                iZzK += zzbcj.zzK((jZze >> 63) ^ (jZze + jZze));
                i++;
            }
        } else {
            iZzK = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzK += zzbcj.zzK((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
        }
        return iZzK;
    }

    static int zzu(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iZzI = zzbcj.zzI(i) * size;
        if (list instanceof zzbga) {
            zzbga zzbgaVar = (zzbga) list;
            while (i2 < size) {
                Object objZzf = zzbgaVar.zzf(i2);
                iZzI += objZzf instanceof zzbbw ? zzbcj.zzz((zzbbw) objZzf) : zzbcj.zzH((String) objZzf);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                iZzI += obj instanceof zzbbw ? zzbcj.zzz((zzbbw) obj) : zzbcj.zzH((String) obj);
                i2++;
            }
        }
        return iZzI;
    }

    static int zzv(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzbcj.zzI(i));
    }

    static int zzw(List list) {
        int iZzJ;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbfg) {
            zzbfg zzbfgVar = (zzbfg) list;
            iZzJ = 0;
            while (i < size) {
                iZzJ += zzbcj.zzJ(zzbfgVar.zze(i));
                i++;
            }
        } else {
            iZzJ = 0;
            while (i < size) {
                iZzJ += zzbcj.zzJ(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzJ;
    }

    static int zzx(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzbcj.zzI(i));
    }

    static int zzy(List list) {
        int iZzK;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbgh) {
            zzbgh zzbghVar = (zzbgh) list;
            iZzK = 0;
            while (i < size) {
                iZzK += zzbcj.zzK(zzbghVar.zze(i));
                i++;
            }
        } else {
            iZzK = 0;
            while (i < size) {
                iZzK += zzbcj.zzK(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzK;
    }

    public static zzbhz zzz() {
        return zzb;
    }
}
