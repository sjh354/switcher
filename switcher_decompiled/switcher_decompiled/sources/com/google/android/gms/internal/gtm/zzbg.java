package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbg extends com.google.android.gms.analytics.zzj {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private boolean zze;
    private boolean zzf;

    public final String toString() {
        HashMap map = new HashMap();
        map.put("hitType", this.zza);
        map.put("clientId", this.zzb);
        map.put("userId", this.zzc);
        map.put("androidAdId", this.zzd);
        map.put("AdTargetingEnabled", Boolean.valueOf(this.zze));
        map.put("sessionControl", null);
        map.put("nonInteraction", Boolean.valueOf(this.zzf));
        map.put("sampleRate", Double.valueOf(0.0d));
        return zza(map);
    }

    @Override // com.google.android.gms.analytics.zzj
    public final /* bridge */ /* synthetic */ void zzc(com.google.android.gms.analytics.zzj zzjVar) {
        zzbg zzbgVar = (zzbg) zzjVar;
        if (!TextUtils.isEmpty(this.zza)) {
            zzbgVar.zza = this.zza;
        }
        if (!TextUtils.isEmpty(this.zzb)) {
            zzbgVar.zzb = this.zzb;
        }
        if (!TextUtils.isEmpty(this.zzc)) {
            zzbgVar.zzc = this.zzc;
        }
        if (!TextUtils.isEmpty(this.zzd)) {
            zzbgVar.zzd = this.zzd;
        }
        if (this.zze) {
            zzbgVar.zze = true;
        }
        TextUtils.isEmpty(null);
        if (this.zzf) {
            zzbgVar.zzf = true;
        }
    }

    public final String zzd() {
        return this.zzd;
    }

    public final String zze() {
        return this.zzb;
    }

    public final String zzf() {
        return this.zza;
    }

    public final String zzg() {
        return this.zzc;
    }

    public final void zzh(boolean z) {
        this.zze = z;
    }

    public final void zzi(String str) {
        this.zzd = str;
    }

    public final void zzj(String str) {
        this.zzb = str;
    }

    public final void zzk(String str) {
        this.zza = "data";
    }

    public final void zzl(boolean z) {
        this.zzf = true;
    }

    public final void zzm(String str) {
        this.zzc = str;
    }

    public final boolean zzn() {
        return this.zze;
    }

    public final boolean zzo() {
        return this.zzf;
    }
}
