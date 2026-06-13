package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbgc extends zzbgg {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzbgc() {
        super(null);
    }

    /* synthetic */ zzbgc(zzbgb zzbgbVar) {
        super(null);
    }

    private static List zzf(Object obj, long j, int i) {
        List list;
        List list2 = (List) zzbij.zzf(obj, j);
        if (list2.isEmpty()) {
            List zzbfzVar = list2 instanceof zzbga ? new zzbfz(i) : ((list2 instanceof zzbha) && (list2 instanceof zzbfp)) ? ((zzbfp) list2).zzd(i) : new ArrayList(i);
            zzbij.zzs(obj, j, zzbfzVar);
            return zzbfzVar;
        }
        if (zza.isAssignableFrom(list2.getClass())) {
            ArrayList arrayList = new ArrayList(list2.size() + i);
            arrayList.addAll(list2);
            zzbij.zzs(obj, j, arrayList);
            list = arrayList;
        } else {
            if (!(list2 instanceof zzbie)) {
                if (!(list2 instanceof zzbha) || !(list2 instanceof zzbfp)) {
                    return list2;
                }
                zzbfp zzbfpVar = (zzbfp) list2;
                if (zzbfpVar.zzc()) {
                    return list2;
                }
                zzbfp zzbfpVarZzd = zzbfpVar.zzd(list2.size() + i);
                zzbij.zzs(obj, j, zzbfpVarZzd);
                return zzbfpVarZzd;
            }
            zzbfz zzbfzVar2 = new zzbfz(list2.size() + i);
            zzbfzVar2.addAll(zzbfzVar2.size(), (zzbie) list2);
            zzbij.zzs(obj, j, zzbfzVar2);
            list = zzbfzVar2;
        }
        return list;
    }

    @Override // com.google.android.gms.internal.gtm.zzbgg
    final List zza(Object obj, long j) {
        return zzf(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.gtm.zzbgg
    final void zzb(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzbij.zzf(obj, j);
        if (list instanceof zzbga) {
            objUnmodifiableList = ((zzbga) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzbha) && (list instanceof zzbfp)) {
                zzbfp zzbfpVar = (zzbfp) list;
                if (zzbfpVar.zzc()) {
                    zzbfpVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzbij.zzs(obj, j, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.gtm.zzbgg
    final void zzc(Object obj, Object obj2, long j) {
        List list = (List) zzbij.zzf(obj2, j);
        List listZzf = zzf(obj, j, list.size());
        int size = listZzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listZzf.addAll(list);
        }
        if (size > 0) {
            list = listZzf;
        }
        zzbij.zzs(obj, j, list);
    }
}
