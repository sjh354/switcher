package com.google.android.gms.tagmanager;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzas implements zzav {
    final /* synthetic */ DataLayer zza;

    zzas(DataLayer dataLayer) {
        this.zza = dataLayer;
    }

    @Override // com.google.android.gms.tagmanager.zzav
    public final void zza(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzat zzatVar = (zzat) it.next();
            DataLayer dataLayer = this.zza;
            dataLayer.zzi(dataLayer.zza(zzatVar.zza, zzatVar.zzb));
        }
        this.zza.zzh.countDown();
    }
}
