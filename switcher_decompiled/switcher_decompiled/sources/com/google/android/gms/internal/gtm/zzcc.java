package com.google.android.gms.internal.gtm;

import android.content.ComponentName;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzcc implements Runnable {
    final /* synthetic */ ComponentName zza;
    final /* synthetic */ zzcd zzb;

    zzcc(zzcd zzcdVar, ComponentName componentName) {
        this.zzb = zzcdVar;
        this.zza = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzce.zzb(this.zzb.zza, this.zza);
    }
}
