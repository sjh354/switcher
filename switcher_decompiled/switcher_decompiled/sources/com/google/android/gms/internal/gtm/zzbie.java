package com.google.android.gms.internal.gtm;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbie extends AbstractList implements RandomAccess, zzbga {
    private final zzbga zza;

    public zzbie(zzbga zzbgaVar) {
        this.zza = zzbgaVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzbfz) this.zza).get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzbid(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new zzbic(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.gtm.zzbga
    public final zzbga zze() {
        return this;
    }

    @Override // com.google.android.gms.internal.gtm.zzbga
    public final Object zzf(int i) {
        return this.zza.zzf(i);
    }

    @Override // com.google.android.gms.internal.gtm.zzbga
    public final List zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.gtm.zzbga
    public final void zzi(zzbbw zzbbwVar) {
        throw new UnsupportedOperationException();
    }
}
