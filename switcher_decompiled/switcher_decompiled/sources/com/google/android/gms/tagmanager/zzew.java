package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzew implements zzeb {
    private long zzb;
    private final Object zzc = new Object();
    private double zza = 60.0d;
    private final Clock zzd = DefaultClock.getInstance();

    @Override // com.google.android.gms.tagmanager.zzeb
    public final boolean zza() {
        synchronized (this.zzc) {
            long jCurrentTimeMillis = this.zzd.currentTimeMillis();
            double dMin = this.zza;
            if (dMin < 60.0d) {
                double d = (jCurrentTimeMillis - this.zzb) / 2000.0d;
                if (d > 0.0d) {
                    dMin = Math.min(60.0d, dMin + d);
                    this.zza = dMin;
                }
            }
            this.zzb = jCurrentTimeMillis;
            if (dMin >= 1.0d) {
                this.zza = dMin - 1.0d;
                return true;
            }
            Log.w("GoogleTagManager", "No more tokens available.");
            return false;
        }
    }
}
