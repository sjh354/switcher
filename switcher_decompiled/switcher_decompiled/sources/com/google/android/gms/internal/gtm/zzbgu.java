package com.google.android.gms.internal.gtm;

import cz.msebera.android.httpclient.message.TokenParser;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbgu {
    static String zza(zzbgs zzbgsVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzbgsVar, sb, 0);
        return sb.toString();
    }

    static final void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(TokenParser.SP);
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzbhu.zza(zzbbw.zzo((String) obj)));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzbbw) {
            sb.append(": \"");
            sb.append(zzbhu.zza((zzbbw) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzbff) {
            sb.append(" {");
            zzd((zzbff) obj, sb, i + 2);
            sb.append("\n");
            while (i2 < i) {
                sb.append(TokenParser.SP);
                i2++;
            }
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i4 = i + 2;
        zzb(sb, i4, "key", entry.getKey());
        zzb(sb, i4, "value", entry.getValue());
        sb.append("\n");
        while (i2 < i) {
            sb.append(TokenParser.SP);
            i2++;
        }
        sb.append("}");
    }

    private static final String zzc(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }

    private static void zzd(zzbgs zzbgsVar, StringBuilder sb, int i) {
        boolean zEquals;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzbgsVar.getClass().getDeclaredMethods()) {
            map2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                map.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String strSubstring = str.startsWith("get") ? str.substring(3) : str;
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List")) {
                String strConcat = String.valueOf(strSubstring.substring(0, 1).toLowerCase()).concat(String.valueOf(strSubstring.substring(1, strSubstring.length() - 4)));
                Method method2 = (Method) map.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i, zzc(strConcat), zzbff.zzal(method2, zzbgsVar, new Object[0]));
                }
            }
            if (strSubstring.endsWith("Map") && !strSubstring.equals("Map")) {
                String strConcat2 = String.valueOf(strSubstring.substring(0, 1).toLowerCase()).concat(String.valueOf(strSubstring.substring(1, strSubstring.length() - 3)));
                Method method3 = (Method) map.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i, zzc(strConcat2), zzbff.zzal(method3, zzbgsVar, new Object[0]));
                }
            }
            if (((Method) map2.get("set".concat(String.valueOf(strSubstring)))) != null && (!strSubstring.endsWith("Bytes") || !map.containsKey("get".concat(String.valueOf(strSubstring.substring(0, strSubstring.length() - 5)))))) {
                String strConcat3 = String.valueOf(strSubstring.substring(0, 1).toLowerCase()).concat(String.valueOf(strSubstring.substring(1)));
                Method method4 = (Method) map.get("get".concat(String.valueOf(strSubstring)));
                Method method5 = (Method) map.get("has".concat(String.valueOf(strSubstring)));
                if (method4 != null) {
                    Object objZzal = zzbff.zzal(method4, zzbgsVar, new Object[0]);
                    if (method5 == null) {
                        if (objZzal instanceof Boolean) {
                            if (((Boolean) objZzal).booleanValue()) {
                                zzb(sb, i, zzc(strConcat3), objZzal);
                            }
                        } else if (objZzal instanceof Integer) {
                            if (((Integer) objZzal).intValue() != 0) {
                                zzb(sb, i, zzc(strConcat3), objZzal);
                            }
                        } else if (objZzal instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objZzal).floatValue()) != 0) {
                                zzb(sb, i, zzc(strConcat3), objZzal);
                            }
                        } else if (!(objZzal instanceof Double)) {
                            if (objZzal instanceof String) {
                                zEquals = objZzal.equals("");
                            } else if (objZzal instanceof zzbbw) {
                                zEquals = objZzal.equals(zzbbw.zzb);
                            } else if (objZzal instanceof zzbgs) {
                                if (objZzal != ((zzbgs) objZzal).zzav()) {
                                    zzb(sb, i, zzc(strConcat3), objZzal);
                                }
                            } else if (!(objZzal instanceof Enum) || ((Enum) objZzal).ordinal() != 0) {
                                zzb(sb, i, zzc(strConcat3), objZzal);
                            }
                            if (!zEquals) {
                                zzb(sb, i, zzc(strConcat3), objZzal);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objZzal).doubleValue()) != 0) {
                            zzb(sb, i, zzc(strConcat3), objZzal);
                        }
                    } else if (((Boolean) zzbff.zzal(method5, zzbgsVar, new Object[0])).booleanValue()) {
                        zzb(sb, i, zzc(strConcat3), objZzal);
                    }
                }
            }
        }
        if (zzbgsVar instanceof zzbfb) {
            Iterator itZzg = ((zzbfb) zzbgsVar).zzb.zzg();
            while (itZzg.hasNext()) {
                Map.Entry entry = (Map.Entry) itZzg.next();
                zzb(sb, i, "[" + ((zzbfc) entry.getKey()).zzb + "]", entry.getValue());
            }
        }
        zzbia zzbiaVar = ((zzbff) zzbgsVar).zzd;
        if (zzbiaVar != null) {
            zzbiaVar.zzg(sb, i);
        }
    }
}
