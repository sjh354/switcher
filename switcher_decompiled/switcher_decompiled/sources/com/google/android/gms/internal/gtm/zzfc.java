package com.google.android.gms.internal.gtm;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzfc {
    private static volatile Logger zza = new zzcw();

    public static Logger zza() {
        return zza;
    }

    public static void zzb(String str, Object obj) {
        String str2;
        zzfd zzfdVarZza = zzfd.zza();
        if (zzfdVarZza != null) {
            zzfdVarZza.zzJ(str, obj);
        } else if (zzf(3)) {
            if (obj != null) {
                str2 = str + ":" + ((String) obj);
            } else {
                str2 = str;
            }
            Log.e((String) zzew.zzc.zzb(), str2);
        }
        Logger logger = zza;
        if (logger != null) {
            logger.error(str);
        }
    }

    public static void zzc(Logger logger) {
        zza = logger;
    }

    public static void zzd(String str) {
        zzfd zzfdVarZza = zzfd.zza();
        if (zzfdVarZza != null) {
            zzfdVarZza.zzN(str);
        } else if (zzf(0)) {
            Log.v((String) zzew.zzc.zzb(), str);
        }
        Logger logger = zza;
        if (logger != null) {
            logger.verbose(str);
        }
    }

    public static void zze(String str) {
        zzfd zzfdVarZza = zzfd.zza();
        if (zzfdVarZza != null) {
            zzfdVarZza.zzQ(str);
        } else if (zzf(2)) {
            Log.w((String) zzew.zzc.zzb(), str);
        }
        Logger logger = zza;
        if (logger != null) {
            logger.warn(str);
        }
    }

    public static boolean zzf(int i) {
        return zza != null && zza.getLogLevel() <= i;
    }
}
