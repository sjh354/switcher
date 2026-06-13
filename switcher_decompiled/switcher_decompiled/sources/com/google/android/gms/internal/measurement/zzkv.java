package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzkv extends zzkz {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzkv() {
        super(null);
    }

    /* synthetic */ zzkv(zzku zzkuVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzkz
    final void zza(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzmx.zzf(obj, j);
        if (list instanceof zzkt) {
            objUnmodifiableList = ((zzkt) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzls) && (list instanceof zzkl)) {
                zzkl zzklVar = (zzkl) list;
                if (zzklVar.zzc()) {
                    zzklVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzmx.zzs(obj, j, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.measurement.zzkz
    final void zzb(Object obj, Object obj2, long j) {
        List list;
        List list2;
        List list3 = (List) zzmx.zzf(obj2, j);
        int size = list3.size();
        List list4 = (List) zzmx.zzf(obj, j);
        if (list4.isEmpty()) {
            List zzksVar = list4 instanceof zzkt ? new zzks(size) : ((list4 instanceof zzls) && (list4 instanceof zzkl)) ? ((zzkl) list4).zzd(size) : new ArrayList(size);
            zzmx.zzs(obj, j, zzksVar);
            list2 = zzksVar;
        } else {
            if (zza.isAssignableFrom(list4.getClass())) {
                ArrayList arrayList = new ArrayList(list4.size() + size);
                arrayList.addAll(list4);
                zzmx.zzs(obj, j, arrayList);
                list = arrayList;
            } else if (list4 instanceof zzms) {
                zzks zzksVar2 = new zzks(list4.size() + size);
                zzksVar2.addAll(zzksVar2.size(), (zzms) list4);
                zzmx.zzs(obj, j, zzksVar2);
                list = zzksVar2;
            } else {
                boolean z = list4 instanceof zzls;
                list2 = list4;
                if (z) {
                    boolean z2 = list4 instanceof zzkl;
                    list2 = list4;
                    if (z2) {
                        zzkl zzklVar = (zzkl) list4;
                        list2 = list4;
                        if (!zzklVar.zzc()) {
                            zzkl zzklVarZzd = zzklVar.zzd(list4.size() + size);
                            zzmx.zzs(obj, j, zzklVarZzd);
                            list2 = zzklVarZzd;
                        }
                    }
                }
            }
            list2 = list;
        }
        int size2 = list2.size();
        int size3 = list3.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list3);
        }
        if (size2 > 0) {
            list3 = list2;
        }
        zzmx.zzs(obj, j, list3);
    }
}
