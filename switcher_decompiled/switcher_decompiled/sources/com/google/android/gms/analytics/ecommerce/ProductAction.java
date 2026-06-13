package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public class ProductAction {
    public static final String ACTION_ADD = "add";
    public static final String ACTION_CHECKOUT = "checkout";
    public static final String ACTION_CHECKOUT_OPTION = "checkout_option";

    @Deprecated
    public static final String ACTION_CHECKOUT_OPTIONS = "checkout_options";
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_DETAIL = "detail";
    public static final String ACTION_PURCHASE = "purchase";
    public static final String ACTION_REFUND = "refund";
    public static final String ACTION_REMOVE = "remove";
    Map zza = new HashMap();

    public ProductAction(String str) {
        zzb("&pa", str);
    }

    public ProductAction setCheckoutOptions(String str) {
        zzb("&col", str);
        return this;
    }

    public ProductAction setCheckoutStep(int i) {
        zzb("&cos", Integer.toString(i));
        return this;
    }

    public ProductAction setProductActionList(String str) {
        zzb("&pal", str);
        return this;
    }

    public ProductAction setProductListSource(String str) {
        zzb("&pls", str);
        return this;
    }

    public ProductAction setTransactionAffiliation(String str) {
        zzb("&ta", str);
        return this;
    }

    public ProductAction setTransactionCouponCode(String str) {
        zzb("&tcc", str);
        return this;
    }

    public ProductAction setTransactionId(String str) {
        zzb("&ti", str);
        return this;
    }

    public ProductAction setTransactionRevenue(double d) {
        zzb("&tr", Double.toString(d));
        return this;
    }

    public ProductAction setTransactionShipping(double d) {
        zzb("&ts", Double.toString(d));
        return this;
    }

    public ProductAction setTransactionTax(double d) {
        zzb("&tt", Double.toString(d));
        return this;
    }

    public String toString() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.zza.entrySet()) {
            if (((String) entry.getKey()).startsWith("&")) {
                map.put(((String) entry.getKey()).substring(1), (String) entry.getValue());
            } else {
                map.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return zzj.zzb(map);
    }

    public final Map zza() {
        return new HashMap(this.zza);
    }

    final void zzb(String str, String str2) {
        Preconditions.checkNotNull(str, "Name should be non-null");
        this.zza.put(str, str2);
    }
}
