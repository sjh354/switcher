package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.stats.WakeLock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfk {
    static final Object zza = new Object();
    static WakeLock zzb;
    static Boolean zzc;

    public static boolean zza(Context context) {
        Preconditions.checkNotNull(context);
        Boolean bool = zzc;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zZzi = zzfu.zzi(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        zzc = Boolean.valueOf(zZzi);
        return zZzi;
    }

    public static final void zzb(Context context, Intent intent) {
        zzbx zzbxVarZzg = zzbx.zzg(context);
        zzfd zzfdVarZzm = zzbxVarZzg.zzm();
        if (intent == null) {
            zzfdVarZzm.zzQ("AnalyticsReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zzbxVarZzg.zzj();
        zzfdVarZzm.zzO("Local AnalyticsReceiver got", action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean zZzh = zzfp.zzh(context);
            Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent2.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (zza) {
                context.startService(intent2);
                if (zZzh) {
                    try {
                        if (zzb == null) {
                            WakeLock wakeLock = new WakeLock(context, 1, "Analytics WakeLock");
                            zzb = wakeLock;
                            wakeLock.setReferenceCounted(false);
                        }
                        zzb.acquire(1000L);
                    } catch (SecurityException unused) {
                        zzfdVarZzm.zzQ("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                }
            }
        }
    }
}
