package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzaf implements zzdf {
    final /* synthetic */ zzak zza;

    /* synthetic */ zzaf(zzak zzakVar, zzae zzaeVar) {
        this.zza = zzakVar;
    }

    @Override // com.google.android.gms.tagmanager.zzdf
    public final void zza(int i) {
        if (i == 4) {
            this.zza.zzi.zzc();
        }
        synchronized (this.zza) {
            if (!this.zza.isReady()) {
                if (this.zza.zzl != null) {
                    zzak zzakVar = this.zza;
                    zzakVar.setResult(zzakVar.zzl);
                } else {
                    zzak zzakVar2 = this.zza;
                    zzakVar2.setResult(zzakVar2.createFailedResult(Status.RESULT_TIMEOUT));
                }
            }
        }
        this.zza.zzr(this.zza.zzi.zzb());
    }
}
