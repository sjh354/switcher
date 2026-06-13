package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzbhz {
    zzbhz() {
    }

    abstract int zza(Object obj);

    abstract int zzb(Object obj);

    abstract Object zzc(Object obj);

    abstract Object zzd(Object obj);

    abstract Object zze(Object obj, Object obj2);

    abstract Object zzf();

    abstract Object zzg(Object obj);

    abstract void zzh(Object obj, int i, int i2);

    abstract void zzi(Object obj, int i, long j);

    abstract void zzj(Object obj, int i, Object obj2);

    abstract void zzk(Object obj, int i, zzbbw zzbbwVar);

    abstract void zzl(Object obj, int i, long j);

    abstract void zzm(Object obj);

    abstract void zzn(Object obj, Object obj2);

    abstract void zzo(Object obj, Object obj2);

    final boolean zzp(Object obj, zzbhe zzbheVar) throws IOException {
        int iZzd = zzbheVar.zzd();
        int i = iZzd >>> 3;
        int i2 = iZzd & 7;
        if (i2 == 0) {
            zzl(obj, i, zzbheVar.zzl());
            return true;
        }
        if (i2 == 1) {
            zzi(obj, i, zzbheVar.zzk());
            return true;
        }
        if (i2 == 2) {
            zzk(obj, i, zzbheVar.zzq());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzbfs.zza();
            }
            zzh(obj, i, zzbheVar.zzf());
            return true;
        }
        Object objZzf = zzf();
        int i3 = 4 | (i << 3);
        while (zzbheVar.zzc() != Integer.MAX_VALUE && zzp(objZzf, zzbheVar)) {
        }
        if (i3 != zzbheVar.zzd()) {
            throw zzbfs.zzb();
        }
        zzg(objZzf);
        zzj(obj, i, objZzf);
        return true;
    }

    abstract boolean zzq(zzbhe zzbheVar);

    abstract void zzr(Object obj, zzbck zzbckVar) throws IOException;

    abstract void zzs(Object obj, zzbck zzbckVar) throws IOException;
}
