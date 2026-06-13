package com.google.android.gms.internal.gtm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbhb {
    private static final zzbhb zza = new zzbhb();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzbhg zzb = new zzbgk();

    private zzbhb() {
    }

    public static zzbhb zza() {
        return zza;
    }

    public final zzbhf zzb(Class cls) {
        zzbfq.zzf(cls, "messageType");
        zzbhf zzbhfVarZza = (zzbhf) this.zzc.get(cls);
        if (zzbhfVarZza == null) {
            zzbhfVarZza = this.zzb.zza(cls);
            zzbfq.zzf(cls, "messageType");
            zzbfq.zzf(zzbhfVarZza, "schema");
            zzbhf zzbhfVar = (zzbhf) this.zzc.putIfAbsent(cls, zzbhfVarZza);
            if (zzbhfVar != null) {
                return zzbhfVar;
            }
        }
        return zzbhfVarZza;
    }
}
