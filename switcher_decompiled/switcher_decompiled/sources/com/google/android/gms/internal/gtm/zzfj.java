package com.google.android.gms.internal.gtm;

import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfj extends zzbu {
    private SharedPreferences zza;
    private long zzb;
    private long zzc;
    private final zzfi zzd;

    protected zzfj(zzbx zzbxVar) {
        super(zzbxVar);
        this.zzc = -1L;
        zzw();
        this.zzd = new zzfi(this, "monitoring", ((Long) zzew.zzP.zzb()).longValue(), null);
    }

    public final long zza() {
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        long j = this.zzb;
        if (j != 0) {
            return j;
        }
        long j2 = this.zza.getLong("first_run", 0L);
        if (j2 != 0) {
            this.zzb = j2;
            return j2;
        }
        long jCurrentTimeMillis = zzC().currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.zza.edit();
        editorEdit.putLong("first_run", jCurrentTimeMillis);
        if (!editorEdit.commit()) {
            zzQ("Failed to commit first run time");
        }
        this.zzb = jCurrentTimeMillis;
        return jCurrentTimeMillis;
    }

    public final long zzb() {
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        long j = this.zzc;
        if (j != -1) {
            return j;
        }
        long j2 = this.zza.getLong("last_dispatch", 0L);
        this.zzc = j2;
        return j2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
        this.zza = zzo().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public final zzfi zze() {
        return this.zzd;
    }

    public final zzfq zzf() {
        return new zzfq(zzC(), zza());
    }

    public final String zzg() {
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        String string = this.zza.getString("installation_campaign", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    public final void zzh(String str) {
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        SharedPreferences.Editor editorEdit = this.zza.edit();
        if (TextUtils.isEmpty(str)) {
            editorEdit.remove("installation_campaign");
        } else {
            editorEdit.putString("installation_campaign", str);
        }
        if (editorEdit.commit()) {
            return;
        }
        zzQ("Failed to commit campaign data");
    }

    public final void zzi() {
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        long jCurrentTimeMillis = zzC().currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.zza.edit();
        editorEdit.putLong("last_dispatch", jCurrentTimeMillis);
        editorEdit.apply();
        this.zzc = jCurrentTimeMillis;
    }
}
