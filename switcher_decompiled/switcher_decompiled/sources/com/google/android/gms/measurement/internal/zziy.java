package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zziy implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf zzb;
    final /* synthetic */ zzjs zzc;

    zziy(zzjs zzjsVar, zzq zzqVar, com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        this.zzc = zzjsVar;
        this.zza = zzqVar;
        this.zzb = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfy zzfyVar;
        String strZzd = null;
        try {
            try {
                if (this.zzc.zzs.zzm().zzc().zzi(zzah.ANALYTICS_STORAGE)) {
                    zzjs zzjsVar = this.zzc;
                    zzee zzeeVar = zzjsVar.zzb;
                    if (zzeeVar == null) {
                        zzjsVar.zzs.zzay().zzd().zza("Failed to get app instance id");
                        zzfyVar = this.zzc.zzs;
                    } else {
                        Preconditions.checkNotNull(this.zza);
                        strZzd = zzeeVar.zzd(this.zza);
                        if (strZzd != null) {
                            this.zzc.zzs.zzq().zzO(strZzd);
                            this.zzc.zzs.zzm().zze.zzb(strZzd);
                        }
                        this.zzc.zzQ();
                        zzfyVar = this.zzc.zzs;
                    }
                } else {
                    this.zzc.zzs.zzay().zzl().zza("Analytics storage consent denied; will not get app instance id");
                    this.zzc.zzs.zzq().zzO(null);
                    this.zzc.zzs.zzm().zze.zzb(null);
                    zzfyVar = this.zzc.zzs;
                }
            } catch (RemoteException e) {
                this.zzc.zzs.zzay().zzd().zzb("Failed to get app instance id", e);
                zzfyVar = this.zzc.zzs;
            }
            zzfyVar.zzv().zzV(this.zzb, strZzd);
        } catch (Throwable th) {
            this.zzc.zzs.zzv().zzV(this.zzb, null);
            throw th;
        }
    }
}
