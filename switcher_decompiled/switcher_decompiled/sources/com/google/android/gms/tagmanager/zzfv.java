package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kr.switcher.device.switcher.Switcher;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfv extends zzfs {
    private static final String zza = com.google.android.gms.internal.gtm.zza.UNIVERSAL_ANALYTICS.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.ACCOUNT.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.ANALYTICS_PASS_THROUGH.toString();
    private static final String zzd = com.google.android.gms.internal.gtm.zzb.ENABLE_ECOMMERCE.toString();
    private static final String zze = com.google.android.gms.internal.gtm.zzb.ECOMMERCE_USE_DATA_LAYER.toString();
    private static final String zzf = com.google.android.gms.internal.gtm.zzb.ECOMMERCE_MACRO_DATA.toString();
    private static final String zzg = com.google.android.gms.internal.gtm.zzb.ANALYTICS_FIELDS.toString();
    private static final String zzh = com.google.android.gms.internal.gtm.zzb.TRACK_TRANSACTION.toString();
    private static final String zzi = com.google.android.gms.internal.gtm.zzb.TRANSACTION_DATALAYER_MAP.toString();
    private static final String zzj = com.google.android.gms.internal.gtm.zzb.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    private static final List zzk = Arrays.asList(ProductAction.ACTION_DETAIL, ProductAction.ACTION_CHECKOUT, ProductAction.ACTION_CHECKOUT_OPTION, "click", ProductAction.ACTION_ADD, ProductAction.ACTION_REMOVE, "purchase", "refund");
    private static final Pattern zzl = Pattern.compile("dimension(\\d+)");
    private static final Pattern zzm = Pattern.compile("metric(\\d+)");
    private static Map zzn;
    private static Map zzo;
    private final Set zzp;
    private final zzfr zzq;
    private final DataLayer zzr;

    public zzfv(Context context, DataLayer dataLayer) {
        zzfr zzfrVar = new zzfr(context);
        super(zza, new String[0]);
        this.zzr = dataLayer;
        this.zzq = zzfrVar;
        HashSet hashSet = new HashSet();
        this.zzp = hashSet;
        hashSet.add("");
        hashSet.add(Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE);
        hashSet.add("false");
    }

    private final String zzd(String str) {
        Object obj = this.zzr.get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    private final Map zzh(com.google.android.gms.internal.gtm.zzam zzamVar) {
        if (zzamVar == null) {
            return new HashMap();
        }
        Map mapZzm = zzm(zzamVar);
        if (mapZzm == null) {
            return new HashMap();
        }
        String str = (String) mapZzm.get("&aip");
        if (str != null && this.zzp.contains(str.toLowerCase())) {
            mapZzm.remove("&aip");
        }
        return mapZzm;
    }

    private static final void zzi(Map map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    private static final boolean zzj(Map map, String str) {
        com.google.android.gms.internal.gtm.zzam zzamVar = (com.google.android.gms.internal.gtm.zzam) map.get(str);
        if (zzamVar == null) {
            return false;
        }
        return zzfu.zzg(zzfu.zzl(zzamVar)).booleanValue();
    }

    private static final Double zzk(Object obj) {
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Cannot convert the object to Double: ".concat(String.valueOf(e.getMessage())));
            }
        }
        if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        }
        if (obj instanceof Double) {
            return (Double) obj;
        }
        throw new RuntimeException("Cannot convert the object to Double: ".concat(String.valueOf(obj.toString())));
    }

    private static final Integer zzl(Object obj) {
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Cannot convert the object to Integer: ".concat(String.valueOf(e.getMessage())));
            }
        }
        if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        throw new RuntimeException("Cannot convert the object to Integer: ".concat(String.valueOf(obj.toString())));
    }

    private static final Map zzm(com.google.android.gms.internal.gtm.zzam zzamVar) {
        Object objZzl = zzfu.zzl(zzamVar);
        if (!(objZzl instanceof Map)) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : ((Map) objZzl).entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private static final Product zzn(Map map) {
        Product product = new Product();
        Object obj = map.get("id");
        if (obj != null) {
            product.setId(obj.toString());
        }
        Object obj2 = map.get("name");
        if (obj2 != null) {
            product.setName(obj2.toString());
        }
        Object obj3 = map.get("brand");
        if (obj3 != null) {
            product.setBrand(obj3.toString());
        }
        Object obj4 = map.get("category");
        if (obj4 != null) {
            product.setCategory(obj4.toString());
        }
        Object obj5 = map.get("variant");
        if (obj5 != null) {
            product.setVariant(obj5.toString());
        }
        Object obj6 = map.get(FirebaseAnalytics.Param.COUPON);
        if (obj6 != null) {
            product.setCouponCode(obj6.toString());
        }
        Object obj7 = map.get("position");
        if (obj7 != null) {
            product.setPosition(zzl(obj7).intValue());
        }
        Object obj8 = map.get("price");
        if (obj8 != null) {
            product.setPrice(zzk(obj8).doubleValue());
        }
        Object obj9 = map.get(FirebaseAnalytics.Param.QUANTITY);
        if (obj9 != null) {
            product.setQuantity(zzl(obj9).intValue());
        }
        for (String str : map.keySet()) {
            Matcher matcher = zzl.matcher(str);
            if (matcher.matches()) {
                try {
                    product.setCustomDimension(Integer.parseInt(matcher.group(1)), String.valueOf(map.get(str)));
                } catch (NumberFormatException unused) {
                    Log.w("GoogleTagManager", "illegal number in custom dimension value: ".concat(String.valueOf(str)));
                }
            } else {
                Matcher matcher2 = zzm.matcher(str);
                if (matcher2.matches()) {
                    try {
                        product.setCustomMetric(Integer.parseInt(matcher2.group(1)), zzl(map.get(str)).intValue());
                    } catch (NumberFormatException unused2) {
                        Log.w("GoogleTagManager", "illegal number in custom metric value: ".concat(String.valueOf(str)));
                    }
                }
            }
        }
        return product;
    }

    @Override // com.google.android.gms.tagmanager.zzfs, com.google.android.gms.tagmanager.zzbt
    public final /* bridge */ /* synthetic */ boolean zzb() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x026b A[EDGE_INSN: B:200:0x026b->B:110:0x026b BREAK  A[LOOP:2: B:62:0x0160->B:201:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0166  */
    @Override // com.google.android.gms.tagmanager.zzfs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzc(java.util.Map r15) {
        /*
            Method dump skipped, instruction units count: 1055
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzfv.zzc(java.util.Map):void");
    }
}
