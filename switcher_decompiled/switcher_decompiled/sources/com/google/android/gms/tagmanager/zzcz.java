package com.google.android.gms.tagmanager;

import android.util.LruCache;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzcz extends LruCache {
    final /* synthetic */ zzq zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcz(zzda zzdaVar, int i, zzq zzqVar) {
        super(1048576);
        this.zza = zzqVar;
    }

    @Override // android.util.LruCache
    protected final int sizeOf(Object obj, Object obj2) {
        return this.zza.zza(obj, obj2);
    }
}
