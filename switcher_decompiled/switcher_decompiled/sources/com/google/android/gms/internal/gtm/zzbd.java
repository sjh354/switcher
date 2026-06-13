package com.google.android.gms.internal.gtm;

import com.google.android.gms.analytics.ecommerce.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbd extends com.google.android.gms.analytics.zzj {
    private final List zza = new ArrayList();
    private final List zzb = new ArrayList();
    private final Map zzc = new HashMap();

    public final String toString() {
        HashMap map = new HashMap();
        if (!this.zza.isEmpty()) {
            map.put("products", this.zza);
        }
        if (!this.zzb.isEmpty()) {
            map.put("promotions", this.zzb);
        }
        if (!this.zzc.isEmpty()) {
            map.put("impressions", this.zzc);
        }
        map.put("productAction", null);
        return zza(map);
    }

    @Override // com.google.android.gms.analytics.zzj
    public final /* bridge */ /* synthetic */ void zzc(com.google.android.gms.analytics.zzj zzjVar) {
        zzbd zzbdVar = (zzbd) zzjVar;
        zzbdVar.zza.addAll(this.zza);
        zzbdVar.zzb.addAll(this.zzb);
        for (Map.Entry entry : this.zzc.entrySet()) {
            String str = (String) entry.getKey();
            for (Product product : (List) entry.getValue()) {
                if (product != null) {
                    String str2 = str == null ? "" : str;
                    if (!zzbdVar.zzc.containsKey(str2)) {
                        zzbdVar.zzc.put(str2, new ArrayList());
                    }
                    ((List) zzbdVar.zzc.get(str2)).add(product);
                }
            }
        }
    }

    public final List zzd() {
        return Collections.unmodifiableList(this.zza);
    }

    public final List zze() {
        return Collections.unmodifiableList(this.zzb);
    }

    public final Map zzf() {
        return this.zzc;
    }
}
