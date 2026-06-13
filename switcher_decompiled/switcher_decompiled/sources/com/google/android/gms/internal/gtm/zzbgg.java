package com.google.android.gms.internal.gtm;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzbgg {
    private static final zzbgg zza = new zzbgc(null);
    private static final zzbgg zzb = new zzbge(0 == true ? 1 : 0);

    /* synthetic */ zzbgg(zzbgf zzbgfVar) {
    }

    static zzbgg zzd() {
        return zza;
    }

    static zzbgg zze() {
        return zzb;
    }

    abstract List zza(Object obj, long j);

    abstract void zzb(Object obj, long j);

    abstract void zzc(Object obj, Object obj2, long j);
}
