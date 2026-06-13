package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbb extends com.google.android.gms.analytics.zzj {
    private final Map zza = new HashMap();

    public final String toString() {
        return zza(this.zza);
    }

    @Override // com.google.android.gms.analytics.zzj
    public final /* bridge */ /* synthetic */ void zzc(com.google.android.gms.analytics.zzj zzjVar) {
        zzbb zzbbVar = (zzbb) zzjVar;
        Preconditions.checkNotNull(zzbbVar);
        zzbbVar.zza.putAll(this.zza);
    }

    public final Map zzd() {
        return Collections.unmodifiableMap(this.zza);
    }

    public final void zze(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        Preconditions.checkNotEmpty(str, "Name can not be empty or \"&\"");
        this.zza.put(str, str2);
    }
}
