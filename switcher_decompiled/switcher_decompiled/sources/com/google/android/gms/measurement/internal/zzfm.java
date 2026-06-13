package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzfm extends LruCache {
    final /* synthetic */ zzfp zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfm(zzfp zzfpVar, int i) {
        super(20);
        this.zza = zzfpVar;
    }

    @Override // androidx.collection.LruCache
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        return zzfp.zzd(this.zza, str);
    }
}
