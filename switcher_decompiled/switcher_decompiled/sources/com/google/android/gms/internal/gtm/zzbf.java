package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import java.util.HashMap;
import no.nordicsemi.android.log.LogContract;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbf extends com.google.android.gms.analytics.zzj {
    public final String toString() {
        HashMap map = new HashMap();
        map.put(LogContract.SessionColumns.DESCRIPTION, null);
        map.put("fatal", false);
        return zza(map);
    }

    @Override // com.google.android.gms.analytics.zzj
    public final /* bridge */ /* synthetic */ void zzc(com.google.android.gms.analytics.zzj zzjVar) {
        TextUtils.isEmpty(null);
    }
}
