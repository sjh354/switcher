package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbc extends com.google.android.gms.analytics.zzj {
    public int zza;
    public int zzb;
    private String zzc;

    public final String toString() {
        HashMap map = new HashMap();
        map.put("language", this.zzc);
        map.put("screenColors", 0);
        map.put("screenWidth", Integer.valueOf(this.zza));
        map.put("screenHeight", Integer.valueOf(this.zzb));
        map.put("viewportWidth", 0);
        map.put("viewportHeight", 0);
        return zza(map);
    }

    @Override // com.google.android.gms.analytics.zzj
    public final /* bridge */ /* synthetic */ void zzc(com.google.android.gms.analytics.zzj zzjVar) {
        zzbc zzbcVar = (zzbc) zzjVar;
        int i = this.zza;
        if (i != 0) {
            zzbcVar.zza = i;
        }
        int i2 = this.zzb;
        if (i2 != 0) {
            zzbcVar.zzb = i2;
        }
        if (TextUtils.isEmpty(this.zzc)) {
            return;
        }
        zzbcVar.zzc = this.zzc;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final void zze(String str) {
        this.zzc = str;
    }
}
