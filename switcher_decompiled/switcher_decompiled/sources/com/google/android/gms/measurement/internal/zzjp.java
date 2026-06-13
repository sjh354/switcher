package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzjp implements Runnable {
    final /* synthetic */ zzjr zza;

    zzjp(zzjr zzjrVar) {
        this.zza = zzjrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjs zzjsVar = this.zza.zza;
        Context contextZzau = zzjsVar.zzs.zzau();
        this.zza.zza.zzs.zzaw();
        zzjs.zzo(zzjsVar, new ComponentName(contextZzau, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
