package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzbax;
import com.google.android.gms.internal.gtm.zzbay;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzbax<MessageType extends zzbay<MessageType, BuilderType>, BuilderType extends zzbax<MessageType, BuilderType>> implements zzbgr {
    @Override // 
    public abstract zzbax zzv();

    protected abstract zzbax zzw(zzbay zzbayVar);

    @Override // com.google.android.gms.internal.gtm.zzbgr
    public final /* bridge */ /* synthetic */ zzbgr zzx(zzbgs zzbgsVar) {
        if (zzav().getClass().isInstance(zzbgsVar)) {
            return zzw((zzbay) zzbgsVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
