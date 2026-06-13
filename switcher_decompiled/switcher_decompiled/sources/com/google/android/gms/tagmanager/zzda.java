package com.google.android.gms.tagmanager;

import android.util.LruCache;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzda {
    private final LruCache zza;

    zzda(int i, zzq zzqVar) {
        this.zza = new zzcz(this, 1048576, zzqVar);
    }

    public final Object zza(Object obj) {
        return this.zza.get(obj);
    }

    public final void zzb(Object obj, Object obj2) {
        this.zza.put(obj, obj2);
    }
}
