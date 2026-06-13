package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbgn {
    zzbgn() {
    }

    public static final int zza(int i, Object obj, Object obj2) {
        zzbgm zzbgmVar = (zzbgm) obj;
        if (zzbgmVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzbgmVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final boolean zzb(Object obj) {
        return !((zzbgm) obj).zze();
    }

    public static final Object zzc(Object obj, Object obj2) {
        zzbgm zzbgmVarZzb = (zzbgm) obj;
        zzbgm zzbgmVar = (zzbgm) obj2;
        if (!zzbgmVar.isEmpty()) {
            if (!zzbgmVarZzb.zze()) {
                zzbgmVarZzb = zzbgmVarZzb.zzb();
            }
            zzbgmVarZzb.zzd(zzbgmVar);
        }
        return zzbgmVarZzb;
    }
}
