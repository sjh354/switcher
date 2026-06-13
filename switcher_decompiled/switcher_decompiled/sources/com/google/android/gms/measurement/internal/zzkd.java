package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzkd implements Runnable {
    final long zza;
    final long zzb;
    final /* synthetic */ zzke zzc;

    zzkd(zzke zzkeVar, long j, long j2) {
        this.zzc = zzkeVar;
        this.zza = j;
        this.zzb = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzs.zzaz().zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkc
            @Override // java.lang.Runnable
            public final void run() {
                zzkd zzkdVar = this.zza;
                zzke zzkeVar = zzkdVar.zzc;
                long j = zzkdVar.zza;
                long j2 = zzkdVar.zzb;
                zzkeVar.zza.zzg();
                zzkeVar.zza.zzs.zzay().zzc().zza("Application going to the background");
                zzkeVar.zza.zzs.zzm().zzl.zza(true);
                Bundle bundle = new Bundle();
                if (!zzkeVar.zza.zzs.zzf().zzu()) {
                    zzkeVar.zza.zzb.zzb(j2);
                    zzkeVar.zza.zzb.zzd(false, false, j2);
                }
                zzkeVar.zza.zzs.zzq().zzH(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ab", j, bundle);
            }
        });
    }
}
