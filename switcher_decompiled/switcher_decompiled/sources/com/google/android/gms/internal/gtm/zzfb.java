package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfb {
    private long zzb;
    private final Clock zze;
    private final Object zzc = new Object();
    private double zza = 60.0d;
    private final String zzd = "tracking";

    public zzfb(int i, long j, String str, Clock clock) {
        this.zze = clock;
    }

    public final boolean zza() {
        synchronized (this.zzc) {
            long jCurrentTimeMillis = this.zze.currentTimeMillis();
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
            zzfc.zze("Excessive " + this.zzd + " detected; call ignored.");
            return false;
        }
    }
}
