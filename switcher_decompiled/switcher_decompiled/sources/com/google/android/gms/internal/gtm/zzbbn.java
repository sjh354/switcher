package com.google.android.gms.internal.gtm;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbbn extends zzbbp {
    final /* synthetic */ zzbbw zza;
    private int zzb = 0;
    private final int zzc;

    zzbbn(zzbbw zzbbwVar) {
        this.zza = zzbbwVar;
        this.zzc = zzbbwVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzbbr
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zzb(i);
    }
}
