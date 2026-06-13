package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT = new Object();
    static final String[] zza = "gtm.lifetime".split("\\.");
    private static final Pattern zzb = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap zzc;
    private final Map zzd;
    private final ReentrantLock zze;
    private final LinkedList zzf;
    private final zzaw zzg;
    private final CountDownLatch zzh;

    DataLayer() {
        this(new zzar());
    }

    public static List<Object> listOf(Object... objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            arrayList.add(obj);
        }
        return arrayList;
    }

    public static Map<String, Object> mapOf(Object... objArr) {
        if ((objArr.length & 1) != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        HashMap map = new HashMap();
        for (int i = 0; i < objArr.length; i += 2) {
            Object obj = objArr[i];
            if (!(obj instanceof String)) {
                throw new IllegalArgumentException("key is not a string: ".concat(String.valueOf(String.valueOf(obj))));
            }
            map.put((String) obj, objArr[i + 1]);
        }
        return map;
    }

    private final void zzh(Map map, String str, Collection collection) {
        for (Map.Entry entry : map.entrySet()) {
            String str2 = str.length() == 0 ? "" : ".";
            String str3 = str + str2 + ((String) entry.getKey());
            if (entry.getValue() instanceof Map) {
                zzh((Map) entry.getValue(), str3, collection);
            } else if (!str3.equals("gtm.lifetime")) {
                collection.add(new zzat(str3, entry.getValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1096)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1050)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:117)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    public final void zzi(Map map) {
        Long lValueOf;
        long j;
        this.zze.lock();
        try {
            this.zzf.offer(map);
            if (this.zze.getHoldCount() == 1) {
                int i = 0;
                do {
                    Map map2 = (Map) this.zzf.poll();
                    if (map2 != null) {
                        synchronized (this.zzd) {
                            for (String str : map2.keySet()) {
                                zzf(zza(str, map2.get(str)), this.zzd);
                            }
                        }
                        Iterator it = this.zzc.keySet().iterator();
                        while (it.hasNext()) {
                            ((zzau) it.next()).zza(map2);
                        }
                        i++;
                    }
                } while (i <= 500);
                this.zzf.clear();
                throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
            }
            String[] strArr = zza;
            int length = strArr.length;
            Object obj = map;
            int i2 = 0;
            while (true) {
                lValueOf = null;
                if (i2 >= length) {
                    break;
                }
                String str2 = strArr[i2];
                if (!(obj instanceof Map)) {
                    obj = null;
                    break;
                } else {
                    obj = ((Map) obj).get(str2);
                    i2++;
                }
            }
            if (obj != null) {
                String string = obj.toString();
                Matcher matcher = zzb.matcher(string);
                if (matcher.matches()) {
                    try {
                        String strGroup = matcher.group(1);
                        Preconditions.checkNotNull(strGroup);
                        j = Long.parseLong(strGroup);
                    } catch (NumberFormatException unused) {
                        Log.w("GoogleTagManager", "illegal number in _lifetime value: ".concat(String.valueOf(string)));
                        j = 0;
                    }
                    if (j <= 0) {
                        zzdg.zzb.zzb("non-positive _lifetime: ".concat(String.valueOf(string)));
                    } else {
                        String strGroup2 = matcher.group(2);
                        Preconditions.checkNotNull(strGroup2);
                        if (strGroup2.length() == 0) {
                            lValueOf = Long.valueOf(j);
                        } else {
                            char cCharAt = strGroup2.charAt(0);
                            if (cCharAt == 'd') {
                                lValueOf = Long.valueOf(j * 86400000);
                            } else if (cCharAt == 'h') {
                                lValueOf = Long.valueOf(j * 3600000);
                            } else if (cCharAt == 'm') {
                                lValueOf = Long.valueOf(j * 60000);
                            } else if (cCharAt != 's') {
                                Log.w("GoogleTagManager", "unknown units in _lifetime: ".concat(String.valueOf(string)));
                            } else {
                                lValueOf = Long.valueOf(j * 1000);
                            }
                        }
                    }
                } else {
                    zzdg.zzb.zzb("unknown _lifetime: ".concat(String.valueOf(string)));
                }
            }
            if (lValueOf != null) {
                ArrayList arrayList = new ArrayList();
                zzh(map, "", arrayList);
                this.zzg.zzc(arrayList, lValueOf.longValue());
            }
        } finally {
            this.zze.unlock();
        }
    }

    public Object get(String str) {
        synchronized (this.zzd) {
            Object obj = this.zzd;
            for (String str2 : str.split("\\.")) {
                if (!(obj instanceof Map)) {
                    return null;
                }
                obj = ((Map) obj).get(str2);
                if (obj == null) {
                    return null;
                }
            }
            return obj;
        }
    }

    public void push(String str, Object obj) throws InterruptedException {
        push(zza(str, obj));
    }

    public void pushEvent(String str, Map<String, Object> map) throws InterruptedException {
        HashMap map2 = new HashMap(map);
        map2.put("event", str);
        push(map2);
    }

    public String toString() {
        String string;
        synchronized (this.zzd) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : this.zzd.entrySet()) {
                sb.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", entry.getKey(), entry.getValue()));
            }
            string = sb.toString();
        }
        return string;
    }

    final Map zza(String str, Object obj) {
        HashMap map = new HashMap();
        String[] strArrSplit = str.toString().split("\\.");
        int i = 0;
        HashMap map2 = map;
        while (true) {
            int length = strArrSplit.length - 1;
            if (i >= length) {
                map2.put(strArrSplit[length], obj);
                return map;
            }
            HashMap map3 = new HashMap();
            map2.put(strArrSplit[i], map3);
            i++;
            map2 = map3;
        }
    }

    final void zzd(String str) throws InterruptedException {
        push(str, null);
        this.zzg.zza(str);
    }

    final void zze(List list, List list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                Object obj2 = list2.get(i);
                Preconditions.checkNotNull(obj2);
                zze((List) obj, (List) obj2);
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                Object obj3 = list2.get(i);
                Preconditions.checkNotNull(obj3);
                zzf((Map) obj, (Map) obj3);
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i, obj);
            }
        }
    }

    final void zzf(Map map, Map map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                Object obj2 = map2.get(str);
                Preconditions.checkNotNull(obj2);
                zze((List) obj, (List) obj2);
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                Object obj3 = map2.get(str);
                Preconditions.checkNotNull(obj3);
                zzf((Map) obj, (Map) obj3);
            } else {
                map2.put(str, obj);
            }
        }
    }

    final void zzg(zzau zzauVar) {
        this.zzc.put(zzauVar, 0);
    }

    DataLayer(zzaw zzawVar) {
        this.zzg = zzawVar;
        this.zzc = new ConcurrentHashMap();
        this.zzd = new HashMap();
        this.zze = new ReentrantLock();
        this.zzf = new LinkedList();
        this.zzh = new CountDownLatch(1);
        zzawVar.zzb(new zzas(this));
    }

    @SideEffectFree
    public void push(Map<String, Object> map) throws InterruptedException {
        try {
            this.zzh.await();
        } catch (InterruptedException unused) {
            Log.w("GoogleTagManager", "DataLayer.push: unexpected InterruptedException");
        }
        zzi(map);
    }
}
