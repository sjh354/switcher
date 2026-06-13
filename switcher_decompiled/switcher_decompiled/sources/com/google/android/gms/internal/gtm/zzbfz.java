package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbfz extends zzbba implements RandomAccess, zzbga {
    public static final zzbga zza;
    private static final zzbfz zzb;
    private final List zzc;

    static {
        zzbfz zzbfzVar = new zzbfz(10);
        zzb = zzbfzVar;
        zzbfzVar.zzb();
        zza = zzbfzVar;
    }

    public zzbfz() {
        this(10);
    }

    private static String zzj(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzbbw ? ((zzbbw) obj).zzr(zzbfq.zzb) : zzbfq.zzh((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.gtm.zzbba, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zza();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.gtm.zzbba, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        zza();
        if (collection instanceof zzbga) {
            collection = ((zzbga) collection).zzh();
        }
        boolean zAddAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.gtm.zzbba, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.gtm.zzbba, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        Object objRemove = this.zzc.remove(i);
        this.modCount++;
        return zzj(objRemove);
    }

    @Override // com.google.android.gms.internal.gtm.zzbba, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zza();
        return zzj(this.zzc.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.gtm.zzbfp
    public final /* bridge */ /* synthetic */ zzbfp zzd(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzc);
        return new zzbfz(arrayList);
    }

    @Override // com.google.android.gms.internal.gtm.zzbga
    public final zzbga zze() {
        return zzc() ? new zzbie(this) : this;
    }

    @Override // com.google.android.gms.internal.gtm.zzbga
    public final Object zzf(int i) {
        return this.zzc.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzbbw) {
            zzbbw zzbbwVar = (zzbbw) obj;
            String strZzr = zzbbwVar.zzr(zzbfq.zzb);
            if (zzbbwVar.zzj()) {
                this.zzc.set(i, strZzr);
            }
            return strZzr;
        }
        byte[] bArr = (byte[]) obj;
        String strZzh = zzbfq.zzh(bArr);
        if (zzbfq.zzj(bArr)) {
            this.zzc.set(i, strZzh);
        }
        return strZzh;
    }

    @Override // com.google.android.gms.internal.gtm.zzbga
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.gms.internal.gtm.zzbga
    public final void zzi(zzbbw zzbbwVar) {
        zza();
        this.zzc.add(zzbbwVar);
        this.modCount++;
    }

    public zzbfz(int i) {
        this.zzc = new ArrayList(i);
    }

    private zzbfz(ArrayList arrayList) {
        this.zzc = arrayList;
    }

    @Override // com.google.android.gms.internal.gtm.zzbba, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
