package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import java.util.HashMap;
import kr.switcher.switcherm.common.ga.GALogger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbe extends com.google.android.gms.analytics.zzj {
    public final String toString() {
        HashMap map = new HashMap();
        map.put("category", null);
        map.put(GALogger.CATEGORY_ACTION, null);
        map.put(Constants.ScionAnalytics.PARAM_LABEL, null);
        map.put("value", 0L);
        return zza(map);
    }

    @Override // com.google.android.gms.analytics.zzj
    public final /* bridge */ /* synthetic */ void zzc(com.google.android.gms.analytics.zzj zzjVar) {
        TextUtils.isEmpty(null);
        TextUtils.isEmpty(null);
        TextUtils.isEmpty(null);
    }
}
