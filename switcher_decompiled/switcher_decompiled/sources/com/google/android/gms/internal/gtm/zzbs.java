package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbs extends zzbu {
    private final zzcm zza;

    public zzbs(zzbx zzbxVar, zzby zzbyVar) {
        super(zzbxVar);
        Preconditions.checkNotNull(zzbyVar);
        this.zza = new zzcm(zzbxVar, zzbyVar);
    }

    public final long zza(zzbz zzbzVar) {
        zzV();
        Preconditions.checkNotNull(zzbzVar);
        com.google.android.gms.analytics.zzr.zzh();
        long jZzb = this.zza.zzb(zzbzVar, true);
        if (jZzb != 0) {
            return jZzb;
        }
        this.zza.zzk(zzbzVar);
        return 0L;
    }

    public final void zzc() {
        zzV();
        Context contextZzo = zzo();
        if (!zzfk.zza(contextZzo) || !zzfp.zzh(contextZzo)) {
            zze(null);
            return;
        }
        Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent.setComponent(new ComponentName(contextZzo, "com.google.android.gms.analytics.AnalyticsService"));
        contextZzo.startService(intent);
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
        this.zza.zzW();
    }

    public final void zze(zzdb zzdbVar) {
        zzV();
        zzq().zzi(new zzbq(this, zzdbVar));
    }

    public final void zzf(String str, Runnable runnable) {
        Preconditions.checkNotEmpty(str, "campaign param can't be empty");
        zzq().zzi(new zzbm(this, str, runnable));
    }

    public final void zzg() {
        zzV();
        zzw();
        zzq().zzi(new zzbp(this));
    }

    public final void zzh(zzez zzezVar) {
        Preconditions.checkNotNull(zzezVar);
        zzV();
        zzF("Hit delivery requested", zzezVar);
        zzq().zzi(new zzbo(this, zzezVar));
    }

    final void zzi() {
        com.google.android.gms.analytics.zzr.zzh();
        this.zza.zzl();
    }

    final void zzj() {
        com.google.android.gms.analytics.zzr.zzh();
        this.zza.zzm();
    }

    public final void zzk() {
        zzV();
        com.google.android.gms.analytics.zzr.zzh();
        zzcm zzcmVar = this.zza;
        com.google.android.gms.analytics.zzr.zzh();
        zzcmVar.zzV();
        zzcmVar.zzN("Service disconnected");
    }

    public final void zzl(int i) {
        zzV();
        zzF("setLocalDispatchPeriod (sec)", Integer.valueOf(i));
        zzq().zzi(new zzbn(this, i));
    }

    public final void zzm() {
        this.zza.zzZ();
    }

    public final boolean zzn() {
        zzV();
        try {
            zzq().zzg(new zzbr(this)).get(4L, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e) {
            zzR("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            zzJ("syncDispatchLocalHits failed", e2);
            return false;
        } catch (TimeoutException e3) {
            zzR("syncDispatchLocalHits timed out", e3);
            return false;
        }
    }
}
