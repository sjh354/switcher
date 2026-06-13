package com.google.android.gms.internal.gtm;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbge extends zzbgg {
    private zzbge() {
        super(null);
    }

    /* synthetic */ zzbge(zzbgd zzbgdVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.gtm.zzbgg
    final List zza(Object obj, long j) {
        zzbfp zzbfpVar = (zzbfp) zzbij.zzf(obj, j);
        if (zzbfpVar.zzc()) {
            return zzbfpVar;
        }
        int size = zzbfpVar.size();
        zzbfp zzbfpVarZzd = zzbfpVar.zzd(size == 0 ? 10 : size + size);
        zzbij.zzs(obj, j, zzbfpVarZzd);
        return zzbfpVarZzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzbgg
    final void zzb(Object obj, long j) {
        ((zzbfp) zzbij.zzf(obj, j)).zzb();
    }

    @Override // com.google.android.gms.internal.gtm.zzbgg
    final void zzc(Object obj, Object obj2, long j) {
        zzbfp zzbfpVarZzd = (zzbfp) zzbij.zzf(obj, j);
        zzbfp zzbfpVar = (zzbfp) zzbij.zzf(obj2, j);
        int size = zzbfpVarZzd.size();
        int size2 = zzbfpVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzbfpVarZzd.zzc()) {
                zzbfpVarZzd = zzbfpVarZzd.zzd(size2 + size);
            }
            zzbfpVarZzd.addAll(zzbfpVar);
        }
        if (size > 0) {
            zzbfpVar = zzbfpVarZzd;
        }
        zzbij.zzs(obj, j, zzbfpVar);
    }
}
