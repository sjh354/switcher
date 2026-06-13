package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public class zzbep {
    static final zzbep zza = new zzbep(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzbep zzd;
    private final Map zze;

    zzbep() {
        this.zze = new HashMap();
    }

    public zzbfd zzb(zzbgs zzbgsVar, int i) {
        return (zzbfd) this.zze.get(new zzbeo(zzbgsVar, i));
    }

    zzbep(boolean z) {
        this.zze = Collections.emptyMap();
    }

    public static zzbep zza() {
        zzbep zzbepVar = zzd;
        if (zzbepVar != null) {
            return zzbepVar;
        }
        synchronized (zzbep.class) {
            zzbep zzbepVar2 = zzd;
            if (zzbepVar2 != null) {
                return zzbepVar2;
            }
            zzbep zzbepVarZzb = zzbex.zzb(zzbep.class);
            zzd = zzbepVarZzb;
            return zzbepVarZzb;
        }
    }
}
