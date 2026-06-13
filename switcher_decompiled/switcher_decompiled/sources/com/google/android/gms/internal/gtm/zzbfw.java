package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbfw implements Iterator {
    private final Iterator zza;

    public zzbfw(Iterator it) {
        this.zza = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        return entry.getValue() instanceof zzbfx ? new zzbfv(entry, null) : entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
    }
}
