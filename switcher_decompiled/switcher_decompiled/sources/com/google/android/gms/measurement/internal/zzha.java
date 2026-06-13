package com.google.android.gms.measurement.internal;

import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzha implements zzei {
    final /* synthetic */ zzfy zza;

    zzha(zzhb zzhbVar, zzfy zzfyVar) {
        this.zza = zzfyVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final boolean zza() {
        return this.zza.zzL() && Log.isLoggable(this.zza.zzay().zzq(), 3);
    }
}
