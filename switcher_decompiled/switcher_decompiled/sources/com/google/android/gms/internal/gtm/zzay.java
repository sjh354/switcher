package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzay extends com.google.android.gms.analytics.zzj {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private String zzi;
    private String zzj;

    public final String toString() {
        HashMap map = new HashMap();
        map.put("name", this.zza);
        map.put("source", this.zzb);
        map.put("medium", this.zzc);
        map.put("keyword", this.zzd);
        map.put("content", this.zze);
        map.put("id", this.zzf);
        map.put("adNetworkId", this.zzg);
        map.put("gclid", this.zzh);
        map.put("dclid", this.zzi);
        map.put(FirebaseAnalytics.Param.ACLID, this.zzj);
        return zza(map);
    }

    @Override // com.google.android.gms.analytics.zzj
    public final /* bridge */ /* synthetic */ void zzc(com.google.android.gms.analytics.zzj zzjVar) {
        zzay zzayVar = (zzay) zzjVar;
        if (!TextUtils.isEmpty(this.zza)) {
            zzayVar.zza = this.zza;
        }
        if (!TextUtils.isEmpty(this.zzb)) {
            zzayVar.zzb = this.zzb;
        }
        if (!TextUtils.isEmpty(this.zzc)) {
            zzayVar.zzc = this.zzc;
        }
        if (!TextUtils.isEmpty(this.zzd)) {
            zzayVar.zzd = this.zzd;
        }
        if (!TextUtils.isEmpty(this.zze)) {
            zzayVar.zze = this.zze;
        }
        if (!TextUtils.isEmpty(this.zzf)) {
            zzayVar.zzf = this.zzf;
        }
        if (!TextUtils.isEmpty(this.zzg)) {
            zzayVar.zzg = this.zzg;
        }
        if (!TextUtils.isEmpty(this.zzh)) {
            zzayVar.zzh = this.zzh;
        }
        if (!TextUtils.isEmpty(this.zzi)) {
            zzayVar.zzi = this.zzi;
        }
        if (TextUtils.isEmpty(this.zzj)) {
            return;
        }
        zzayVar.zzj = this.zzj;
    }

    public final String zzd() {
        return this.zzj;
    }

    public final String zze() {
        return this.zzg;
    }

    public final String zzf() {
        return this.zze;
    }

    public final String zzg() {
        return this.zzi;
    }

    public final String zzh() {
        return this.zzh;
    }

    public final String zzi() {
        return this.zzf;
    }

    public final String zzj() {
        return this.zzd;
    }

    public final String zzk() {
        return this.zzc;
    }

    public final String zzl() {
        return this.zza;
    }

    public final String zzm() {
        return this.zzb;
    }

    public final void zzn(String str) {
        this.zzj = str;
    }

    public final void zzo(String str) {
        this.zzg = str;
    }

    public final void zzp(String str) {
        this.zze = str;
    }

    public final void zzq(String str) {
        this.zzi = str;
    }

    public final void zzr(String str) {
        this.zzh = str;
    }

    public final void zzs(String str) {
        this.zzf = str;
    }

    public final void zzt(String str) {
        this.zzd = str;
    }

    public final void zzu(String str) {
        this.zzc = str;
    }

    public final void zzv(String str) {
        this.zza = str;
    }

    public final void zzw(String str) {
        this.zzb = str;
    }
}
