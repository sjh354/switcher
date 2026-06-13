package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzax extends com.google.android.gms.analytics.zzj {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;

    public final String toString() {
        HashMap map = new HashMap();
        map.put("appName", this.zza);
        map.put("appVersion", this.zzb);
        map.put("appId", this.zzc);
        map.put("appInstallerId", this.zzd);
        return zza(map);
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzd;
    }

    public final String zzf() {
        return this.zza;
    }

    public final String zzg() {
        return this.zzb;
    }

    @Override // com.google.android.gms.analytics.zzj
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final void zzc(zzax zzaxVar) {
        if (!TextUtils.isEmpty(this.zza)) {
            zzaxVar.zza = this.zza;
        }
        if (!TextUtils.isEmpty(this.zzb)) {
            zzaxVar.zzb = this.zzb;
        }
        if (!TextUtils.isEmpty(this.zzc)) {
            zzaxVar.zzc = this.zzc;
        }
        if (TextUtils.isEmpty(this.zzd)) {
            return;
        }
        zzaxVar.zzd = this.zzd;
    }

    public final void zzi(String str) {
        this.zzc = str;
    }

    public final void zzj(String str) {
        this.zzd = str;
    }

    public final void zzk(String str) {
        this.zza = str;
    }

    public final void zzl(String str) {
        this.zzb = str;
    }
}
