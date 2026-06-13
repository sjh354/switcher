package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzku implements zzlg {
    final /* synthetic */ zzkz zza;

    zzku(zzkz zzkzVar) {
        this.zza = zzkzVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlg
    public final void zza(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzaz().zzp(new zzkt(this, str, "_err", bundle));
            return;
        }
        zzkz zzkzVar = this.zza;
        if (zzkzVar.zzn != null) {
            zzkzVar.zzn.zzay().zzd().zzb("AppId not known when logging event", "_err");
        }
    }
}
