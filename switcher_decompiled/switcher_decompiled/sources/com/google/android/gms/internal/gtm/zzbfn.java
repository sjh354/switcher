package com.google.android.gms.internal.gtm;

import java.util.AbstractList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbfn extends AbstractList {
    private final List zza;
    private final zzbfm zzb;

    public zzbfn(List list, zzbfm zzbfmVar) {
        this.zza = list;
        this.zzb = zzbfmVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.zzb.zzb(this.zza.get(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }
}
