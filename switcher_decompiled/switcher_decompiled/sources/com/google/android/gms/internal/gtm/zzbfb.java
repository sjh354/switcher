package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzbfb extends zzbff implements zzbgt {
    protected zzbeu zzb = zzbeu.zze();

    private final void zzc(zzbfd zzbfdVar) {
        if (zzbfdVar.zza != ((zzbff) zzb(6, null, null))) {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }

    final zzbeu zzV() {
        if (this.zzb.zzl()) {
            this.zzb = this.zzb.clone();
        }
        return this.zzb;
    }

    public final Object zzW(zzben zzbenVar) {
        zzbfd zzbfdVar = (zzbfd) zzbenVar;
        zzc(zzbfdVar);
        Object objZzf = this.zzb.zzf(zzbfdVar.zzd);
        if (objZzf == null) {
            return zzbfdVar.zzb;
        }
        zzbfc zzbfcVar = zzbfdVar.zzd;
        if (!zzbfcVar.zzd) {
            return zzbfdVar.zza(objZzf);
        }
        if (zzbfcVar.zzc.zza() != zzbiq.ENUM) {
            return objZzf;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) objZzf).iterator();
        while (it.hasNext()) {
            arrayList.add(zzbfdVar.zza(it.next()));
        }
        return arrayList;
    }

    public final boolean zzX(zzben zzbenVar) {
        zzbfd zzbfdVar = (zzbfd) zzbenVar;
        zzc(zzbfdVar);
        zzbeu zzbeuVar = this.zzb;
        zzbfc zzbfcVar = zzbfdVar.zzd;
        if (zzbfcVar.zzd) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return zzbeuVar.zza.get(zzbfcVar) != null;
    }
}
