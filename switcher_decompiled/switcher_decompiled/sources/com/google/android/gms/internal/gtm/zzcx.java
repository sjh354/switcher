package com.google.android.gms.internal.gtm;

import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzcx implements Runnable {
    final /* synthetic */ zzcy zza;

    zzcx(zzcy zzcyVar) {
        this.zza = zzcyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.zza.zzb.zzd().zzi(this);
            return;
        }
        boolean zZzh = this.zza.zzh();
        this.zza.zzd = 0L;
        if (zZzh) {
            this.zza.zza();
        }
    }
}
