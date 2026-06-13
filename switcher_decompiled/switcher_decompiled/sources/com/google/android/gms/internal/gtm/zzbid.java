package com.google.android.gms.internal.gtm;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbid implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzbie zzb;

    zzbid(zzbie zzbieVar) {
        this.zzb = zzbieVar;
        this.zza = zzbieVar.zza.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
