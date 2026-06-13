package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.common.util.Clock;
import no.nordicsemi.android.dfu.internal.scanner.BootloaderScanner;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzde implements zzeb {
    private long zzb;
    private final Clock zze;
    private final Object zzc = new Object();
    private double zza = Math.min(1, 5);
    private final String zzd = "refreshing";

    public zzde(int i, int i2, long j, long j2, String str, Clock clock) {
        this.zze = clock;
    }

    @Override // com.google.android.gms.tagmanager.zzeb
    public final boolean zza() {
        synchronized (this.zzc) {
            long jCurrentTimeMillis = this.zze.currentTimeMillis();
            long j = jCurrentTimeMillis - this.zzb;
            if (j < BootloaderScanner.TIMEOUT) {
                Log.w("GoogleTagManager", "Excessive " + this.zzd + " detected; call ignored.");
                return false;
            }
            double dMin = this.zza;
            if (dMin < 5.0d) {
                double d = j / 900000.0d;
                if (d > 0.0d) {
                    dMin = Math.min(5.0d, dMin + d);
                    this.zza = dMin;
                }
            }
            this.zzb = jCurrentTimeMillis;
            if (dMin >= 1.0d) {
                this.zza = dMin - 1.0d;
                return true;
            }
            Log.w("GoogleTagManager", "Excessive " + this.zzd + " detected; call ignored.");
            return false;
        }
    }
}
