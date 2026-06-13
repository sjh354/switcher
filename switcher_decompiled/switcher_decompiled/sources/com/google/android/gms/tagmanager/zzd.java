package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzd {
    private static final Object zza = new Object();
    private static zzd zzb;
    private volatile AdvertisingIdClient.Info zzf;
    private volatile long zzg;
    private volatile long zzh;
    private final Context zzi;
    private final Clock zzj;
    private final Thread zzk;
    private volatile long zzc = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
    private volatile long zzd = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
    private volatile boolean zze = false;
    private final Object zzl = new Object();
    private final zzc zzm = new zza(this);

    public zzd(Context context, zzc zzcVar, Clock clock) {
        this.zzj = clock;
        if (context != null) {
            this.zzi = context.getApplicationContext();
        } else {
            this.zzi = null;
        }
        this.zzg = clock.currentTimeMillis();
        this.zzk = new Thread(new zzb(this));
    }

    public static zzd zzb(Context context) {
        if (zzb == null) {
            synchronized (zza) {
                if (zzb == null) {
                    zzd zzdVar = new zzd(context, null, DefaultClock.getInstance());
                    zzb = zzdVar;
                    zzdVar.zzk.start();
                }
            }
        }
        return zzb;
    }

    static /* synthetic */ void zzd(zzd zzdVar) {
        Process.setThreadPriority(10);
        while (!zzdVar.zze) {
            AdvertisingIdClient.Info infoZza = zzdVar.zzm.zza();
            if (infoZza != null) {
                zzdVar.zzf = infoZza;
                zzdVar.zzh = zzdVar.zzj.currentTimeMillis();
                zzdg.zzb.zzb("Obtained fresh AdvertisingId info from GmsCore.");
            }
            synchronized (zzdVar) {
                zzdVar.notifyAll();
            }
            try {
                synchronized (zzdVar.zzl) {
                    zzdVar.zzl.wait(zzdVar.zzc);
                }
            } catch (InterruptedException unused) {
                zzdg.zzb.zzb("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private final void zzg() {
        if (this.zzj.currentTimeMillis() - this.zzh > 3600000) {
            this.zzf = null;
        }
    }

    private final void zzh() {
        if (this.zzj.currentTimeMillis() - this.zzg > this.zzd) {
            synchronized (this.zzl) {
                this.zzl.notify();
            }
            this.zzg = this.zzj.currentTimeMillis();
        }
    }

    private final void zzi() {
        synchronized (this) {
            try {
                if (!this.zze) {
                    zzh();
                    wait(500L);
                }
            } catch (InterruptedException unused) {
            }
        }
    }

    public final String zzc() {
        if (this.zzf == null) {
            zzi();
        } else {
            zzh();
        }
        zzg();
        if (this.zzf == null) {
            return null;
        }
        return this.zzf.getId();
    }

    public final void zze() {
        this.zze = true;
        this.zzk.interrupt();
    }

    public final boolean zzf() {
        if (this.zzf == null) {
            zzi();
        } else {
            zzh();
        }
        zzg();
        return this.zzf == null || this.zzf.isLimitAdTrackingEnabled();
    }
}
