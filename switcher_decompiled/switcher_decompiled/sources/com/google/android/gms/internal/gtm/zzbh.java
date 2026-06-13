package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbh extends com.google.android.gms.analytics.zzj {
    private int zza;

    public zzbh() {
        UUID uuidRandomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (uuidRandomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits == 0 && (leastSignificantBits = (int) (uuidRandomUUID.getMostSignificantBits() & 2147483647L)) == 0) {
            Log.e("GAv4", "UUID.randomUUID() returned 0.");
            leastSignificantBits = Integer.MAX_VALUE;
        }
        Preconditions.checkNotZero(leastSignificantBits);
        this.zza = leastSignificantBits;
    }

    public final String toString() {
        HashMap map = new HashMap();
        map.put("screenName", null);
        map.put("interstitial", false);
        map.put("automatic", false);
        map.put("screenId", Integer.valueOf(this.zza));
        map.put("referrerScreenId", 0);
        map.put("referrerScreenName", null);
        map.put("referrerUri", null);
        return zza(map);
    }

    @Override // com.google.android.gms.analytics.zzj
    public final /* bridge */ /* synthetic */ void zzc(com.google.android.gms.analytics.zzj zzjVar) {
        zzbh zzbhVar = (zzbh) zzjVar;
        TextUtils.isEmpty(null);
        int i = this.zza;
        if (i != 0) {
            zzbhVar.zza = i;
        }
        TextUtils.isEmpty(null);
        if (TextUtils.isEmpty(null)) {
            return;
        }
        TextUtils.isEmpty(null);
    }

    public final int zzd() {
        return this.zza;
    }
}
