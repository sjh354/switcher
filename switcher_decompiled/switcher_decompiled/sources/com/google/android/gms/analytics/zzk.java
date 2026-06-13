package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public class zzk {
    protected final zzh zza;
    private final zzr zzb;
    private final List zzc;

    protected zzk(zzr zzrVar, Clock clock) {
        Preconditions.checkNotNull(zzrVar);
        this.zzb = zzrVar;
        this.zzc = new ArrayList();
        zzh zzhVar = new zzh(this, clock);
        zzhVar.zzh();
        this.zza = zzhVar;
    }

    protected void zze(zzh zzhVar) {
        throw null;
    }

    protected final zzr zzm() {
        return this.zzb;
    }

    protected final void zzn(zzh zzhVar) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            ((zzi) it.next()).zza();
        }
    }
}
