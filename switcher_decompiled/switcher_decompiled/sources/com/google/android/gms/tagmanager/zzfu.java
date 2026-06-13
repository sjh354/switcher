package com.google.android.gms.tagmanager;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfu {
    private static final Long zza = new Long(0);
    private static final Double zzb = new Double(0.0d);
    private static final zzft zzc = zzft.zzd(0);
    private static final String zzd;
    private static final Boolean zze;
    private static final List zzf;
    private static final Map zzg;
    private static final com.google.android.gms.internal.gtm.zzam zzh;

    static {
        String str = new String("");
        zzd = str;
        zze = new Boolean(false);
        zzf = new ArrayList(0);
        zzg = new HashMap();
        zzh = zzc(str);
    }

    public static com.google.android.gms.internal.gtm.zzam zza(String str) {
        com.google.android.gms.internal.gtm.zzan zzanVarZzg = com.google.android.gms.internal.gtm.zzam.zzg();
        zzanVarZzg.zzt(com.google.android.gms.internal.gtm.zzat.STRING);
        zzanVarZzg.zzt(com.google.android.gms.internal.gtm.zzat.FUNCTION_ID);
        zzanVarZzg.zzp(str);
        zzanVarZzg.zzo(false);
        return (com.google.android.gms.internal.gtm.zzam) zzanVarZzg.zzC();
    }

    public static com.google.android.gms.internal.gtm.zzam zzb() {
        return zzh;
    }

    public static com.google.android.gms.internal.gtm.zzam zzc(Object obj) {
        com.google.android.gms.internal.gtm.zzan zzanVarZzg = com.google.android.gms.internal.gtm.zzam.zzg();
        zzanVarZzg.zzt(com.google.android.gms.internal.gtm.zzat.STRING);
        if (obj instanceof com.google.android.gms.internal.gtm.zzam) {
            return (com.google.android.gms.internal.gtm.zzam) obj;
        }
        boolean z = false;
        if (obj instanceof String) {
            zzanVarZzg.zzt(com.google.android.gms.internal.gtm.zzat.STRING);
            zzanVarZzg.zzs((String) obj);
        } else if (obj instanceof List) {
            zzanVarZzg.zzt(com.google.android.gms.internal.gtm.zzat.LIST);
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                com.google.android.gms.internal.gtm.zzam zzamVarZzc = zzc(it.next());
                com.google.android.gms.internal.gtm.zzam zzamVar = zzh;
                if (zzamVarZzc == zzamVar) {
                    return zzamVar;
                }
                z2 = z2 || zzamVarZzc.zzP();
                arrayList.add(zzamVarZzc);
            }
            zzanVarZzg.zzj();
            zzanVarZzg.zzb(arrayList);
            z = z2;
        } else if (obj instanceof Map) {
            zzanVarZzg.zzt(com.google.android.gms.internal.gtm.zzat.MAP);
            Set<Map.Entry> setEntrySet = ((Map) obj).entrySet();
            ArrayList arrayList2 = new ArrayList(setEntrySet.size());
            ArrayList arrayList3 = new ArrayList(setEntrySet.size());
            boolean z3 = false;
            for (Map.Entry entry : setEntrySet) {
                com.google.android.gms.internal.gtm.zzam zzamVarZzc2 = zzc(entry.getKey());
                com.google.android.gms.internal.gtm.zzam zzamVarZzc3 = zzc(entry.getValue());
                com.google.android.gms.internal.gtm.zzam zzamVar2 = zzh;
                if (zzamVarZzc2 == zzamVar2 || zzamVarZzc3 == zzamVar2) {
                    return zzamVar2;
                }
                z3 = z3 || zzamVarZzc2.zzP() || zzamVarZzc3.zzP();
                arrayList2.add(zzamVarZzc2);
                arrayList3.add(zzamVarZzc3);
            }
            zzanVarZzg.zzk();
            zzanVarZzg.zzc(arrayList2);
            zzanVarZzg.zzl();
            zzanVarZzg.zzd(arrayList3);
            z = z3;
        } else if (zzr(obj)) {
            zzanVarZzg.zzt(com.google.android.gms.internal.gtm.zzat.STRING);
            zzanVarZzg.zzs(obj.toString());
        } else if (zzs(obj)) {
            zzanVarZzg.zzt(com.google.android.gms.internal.gtm.zzat.INTEGER);
            zzanVarZzg.zzq(zzp(obj));
        } else {
            if (!(obj instanceof Boolean)) {
                Log.e("GoogleTagManager", "Converting to Value from unknown object type: ".concat(String.valueOf(obj == null ? "null" : obj.getClass().toString())));
                return zzh;
            }
            zzanVarZzg.zzt(com.google.android.gms.internal.gtm.zzat.BOOLEAN);
            zzanVarZzg.zzn(((Boolean) obj).booleanValue());
        }
        zzanVarZzg.zzo(z);
        return (com.google.android.gms.internal.gtm.zzam) zzanVarZzg.zzC();
    }

    public static zzft zzd() {
        return zzc;
    }

    public static zzft zze(Object obj) {
        return obj instanceof zzft ? (zzft) obj : zzs(obj) ? zzft.zzd(zzp(obj)) : zzr(obj) ? zzft.zzc(Double.valueOf(zzo(obj))) : zzq(zzn(obj));
    }

    public static Boolean zzf() {
        return zze;
    }

    public static Boolean zzg(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        String strZzn = zzn(obj);
        return "true".equalsIgnoreCase(strZzn) ? Boolean.TRUE : "false".equalsIgnoreCase(strZzn) ? Boolean.FALSE : zze;
    }

    public static Double zzh() {
        return zzb;
    }

    public static Double zzi(Object obj) {
        if (zzr(obj)) {
            return Double.valueOf(zzo(obj));
        }
        zzft zzftVarZzq = zzq(zzn(obj));
        return zzftVarZzq == zzc ? zzb : Double.valueOf(zzftVarZzq.doubleValue());
    }

    public static Long zzj() {
        return zza;
    }

    public static Long zzk(Object obj) {
        if (zzs(obj)) {
            return Long.valueOf(zzp(obj));
        }
        zzft zzftVarZzq = zzq(zzn(obj));
        return zzftVarZzq == zzc ? zza : Long.valueOf(zzftVarZzq.zzb());
    }

    public static Object zzl(com.google.android.gms.internal.gtm.zzam zzamVar) {
        if (zzamVar == null) {
            return null;
        }
        com.google.android.gms.internal.gtm.zzat zzatVar = com.google.android.gms.internal.gtm.zzat.STRING;
        switch (zzamVar.zzh().ordinal()) {
            case 0:
                break;
            case 1:
                ArrayList arrayList = new ArrayList(zzamVar.zza());
                Iterator it = zzamVar.zzs().iterator();
                while (it.hasNext()) {
                    Object objZzl = zzl((com.google.android.gms.internal.gtm.zzam) it.next());
                    if (objZzl != null) {
                        arrayList.add(objZzl);
                    }
                    break;
                }
                break;
            case 2:
                if (zzamVar.zzc() != zzamVar.zzd()) {
                    Log.e("GoogleTagManager", "Converting an invalid value to object: ".concat(zzamVar.toString()));
                } else {
                    HashMap map = new HashMap(zzamVar.zzd());
                    for (int i = 0; i < zzamVar.zzc(); i++) {
                        Object objZzl2 = zzl(zzamVar.zzl(i));
                        Object objZzl3 = zzl(zzamVar.zzm(i));
                        if (objZzl2 != null && objZzl3 != null) {
                            map.put(objZzl2, objZzl3);
                        }
                    }
                }
                break;
            case 3:
                Log.e("GoogleTagManager", "Trying to convert a macro reference to object");
                break;
            case 4:
                Log.e("GoogleTagManager", "Trying to convert a function id to object");
                break;
            case 5:
                break;
            case 6:
                StringBuilder sb = new StringBuilder();
                Iterator it2 = zzamVar.zzt().iterator();
                while (it2.hasNext()) {
                    String strZzn = zzn(zzl((com.google.android.gms.internal.gtm.zzam) it2.next()));
                    if (strZzn != zzd) {
                        sb.append(strZzn);
                    }
                    break;
                }
                break;
            case 7:
                break;
            default:
                Log.e("GoogleTagManager", "Failed to convert a value of type: ".concat(String.valueOf(String.valueOf(zzamVar.zzh()))));
                break;
        }
        return null;
    }

    public static String zzm() {
        return zzd;
    }

    public static String zzn(Object obj) {
        return obj == null ? zzd : obj.toString();
    }

    private static double zzo(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        Log.e("GoogleTagManager", "getDouble received non-Number");
        return 0.0d;
    }

    private static long zzp(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        Log.e("GoogleTagManager", "getInt64 received non-Number");
        return 0L;
    }

    private static zzft zzq(String str) {
        try {
            return zzft.zze(str);
        } catch (NumberFormatException unused) {
            Log.e("GoogleTagManager", "Failed to convert '" + str + "' to a number.");
            return zzc;
        }
    }

    private static boolean zzr(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof zzft) && ((zzft) obj).zzf());
    }

    private static boolean zzs(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof zzft) && ((zzft) obj).zzg());
    }
}
