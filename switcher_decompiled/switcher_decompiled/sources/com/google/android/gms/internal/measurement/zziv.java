package com.google.android.gms.internal.measurement;

import java.util.Comparator;
import kotlin.UByte;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zziv implements Comparator {
    zziv() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzjd zzjdVar = (zzjd) obj;
        zzjd zzjdVar2 = (zzjd) obj2;
        zziu zziuVar = new zziu(zzjdVar);
        zziu zziuVar2 = new zziu(zzjdVar2);
        while (zziuVar.hasNext() && zziuVar2.hasNext()) {
            int iCompareTo = Integer.valueOf(zziuVar.zza() & UByte.MAX_VALUE).compareTo(Integer.valueOf(zziuVar2.zza() & UByte.MAX_VALUE));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(zzjdVar.zzd()).compareTo(Integer.valueOf(zzjdVar2.zzd()));
    }
}
