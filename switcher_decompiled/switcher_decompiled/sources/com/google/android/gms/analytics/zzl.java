package com.google.android.gms.analytics;

import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzl implements Runnable {
    final /* synthetic */ zzh zza;
    final /* synthetic */ zzr zzb;

    zzl(zzr zzrVar, zzh zzhVar) {
        this.zzb = zzrVar;
        this.zza = zzhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzh zzhVar = this.zza;
        zzhVar.zzd().zze(zzhVar);
        Iterator it = this.zzb.zzc.iterator();
        while (it.hasNext()) {
            ((zzs) it.next()).zza();
        }
        zzh zzhVar2 = this.zza;
        Preconditions.checkNotMainThread("deliver should be called from worker thread");
        Preconditions.checkArgument(zzhVar2.zzm(), "Measurement must be submitted");
        List<zzt> listZzf = zzhVar2.zzf();
        if (listZzf.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (zzt zztVar : listZzf) {
            Uri uriZzb = zztVar.zzb();
            if (!hashSet.contains(uriZzb)) {
                hashSet.add(uriZzb);
                zztVar.zze(zzhVar2);
            }
        }
    }
}
