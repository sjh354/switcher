package com.google.android.gms.analytics;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.internal.gtm.zzfo;
import com.google.android.gms.internal.gtm.zzfp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class AnalyticsJobService extends JobService implements zzfo {
    private zzfp zza;

    private final zzfp zzb() {
        if (this.zza == null) {
            this.zza = new zzfp(this);
        }
        return this.zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzfo
    public boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        zzb().zze();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        zzb().zzf();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        zzb().zza(intent, i, i2);
        return 2;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        zzb().zzi(jobParameters);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // com.google.android.gms.internal.gtm.zzfo
    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }
}
