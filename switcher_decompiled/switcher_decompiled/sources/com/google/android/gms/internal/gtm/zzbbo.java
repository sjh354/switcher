package com.google.android.gms.internal.gtm;

import java.util.Comparator;
import kotlin.UByte;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbbo implements Comparator {
    zzbbo() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzbbw zzbbwVar = (zzbbw) obj;
        zzbbw zzbbwVar2 = (zzbbw) obj2;
        zzbbn zzbbnVar = new zzbbn(zzbbwVar);
        zzbbn zzbbnVar2 = new zzbbn(zzbbwVar2);
        while (zzbbnVar.hasNext() && zzbbnVar2.hasNext()) {
            int iCompareTo = Integer.valueOf(zzbbnVar.zza() & UByte.MAX_VALUE).compareTo(Integer.valueOf(zzbbnVar2.zza() & UByte.MAX_VALUE));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(zzbbwVar.zzd()).compareTo(Integer.valueOf(zzbbwVar2.zzd()));
    }
}
