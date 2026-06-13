package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzba extends com.google.android.gms.analytics.zzj {
    private final Map zza = new HashMap(4);

    public final String toString() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.zza.entrySet()) {
            map.put("metric".concat(String.valueOf(String.valueOf(entry.getKey()))), entry.getValue());
        }
        return zza(map);
    }

    @Override // com.google.android.gms.analytics.zzj
    public final /* bridge */ /* synthetic */ void zzc(com.google.android.gms.analytics.zzj zzjVar) {
        ((zzba) zzjVar).zza.putAll(this.zza);
    }

    public final Map zzd() {
        return Collections.unmodifiableMap(this.zza);
    }
}
