package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzax;
import com.google.android.gms.internal.gtm.zzbc;
import com.google.android.gms.internal.gtm.zzfu;
import java.lang.Thread;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzr {
    private static volatile zzr zza;
    private final Context zzb;
    private final List zzc;
    private final zzg zzd;
    private final zzn zze;
    private volatile zzax zzf;
    private Thread.UncaughtExceptionHandler zzg;

    zzr(Context context) {
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zzb = applicationContext;
        this.zze = new zzn(this);
        this.zzc = new CopyOnWriteArrayList();
        this.zzd = new zzg();
    }

    public static zzr zzb(Context context) {
        Preconditions.checkNotNull(context);
        if (zza == null) {
            synchronized (zzr.class) {
                if (zza == null) {
                    zza = new zzr(context);
                }
            }
        }
        return zza;
    }

    public static void zzh() {
        if (!(Thread.currentThread() instanceof zzq)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final Context zza() {
        return this.zzb;
    }

    public final zzax zzc() {
        if (this.zzf == null) {
            synchronized (this) {
                if (this.zzf == null) {
                    zzax zzaxVar = new zzax();
                    PackageManager packageManager = this.zzb.getPackageManager();
                    String packageName = this.zzb.getPackageName();
                    zzaxVar.zzi(packageName);
                    zzaxVar.zzj(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.zzb.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        Log.e("GAv4", "Error retrieving package info: appName set to " + packageName);
                    }
                    zzaxVar.zzk(packageName);
                    zzaxVar.zzl(str);
                    this.zzf = zzaxVar;
                }
            }
        }
        return this.zzf;
    }

    public final zzbc zzd() {
        DisplayMetrics displayMetrics = this.zzb.getResources().getDisplayMetrics();
        zzbc zzbcVar = new zzbc();
        zzbcVar.zze(zzfu.zzd(Locale.getDefault()));
        zzbcVar.zza = displayMetrics.widthPixels;
        zzbcVar.zzb = displayMetrics.heightPixels;
        return zzbcVar;
    }

    public final Future zzg(Callable callable) {
        Preconditions.checkNotNull(callable);
        if (!(Thread.currentThread() instanceof zzq)) {
            return this.zze.submit(callable);
        }
        FutureTask futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    public final void zzi(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        this.zze.submit(runnable);
    }

    public final void zzj(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzg = uncaughtExceptionHandler;
    }

    final void zzk(zzh zzhVar) {
        if (zzhVar.zzl()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        }
        if (zzhVar.zzm()) {
            throw new IllegalStateException("Measurement can only be submitted once");
        }
        zzh zzhVar2 = new zzh(zzhVar);
        zzhVar2.zzi();
        this.zze.execute(new zzl(this, zzhVar2));
    }
}
