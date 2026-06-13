package com.google.android.gms.tagmanager;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzaq extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.FUNCTION_CALL.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.FUNCTION_CALL_NAME.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.ADDITIONAL_PARAMS.toString();
    private final zzap zzd;

    public zzaq(zzap zzapVar) {
        super(zza, zzb);
        this.zzd = zzapVar;
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        String strZzn = zzfu.zzn(zzfu.zzl((com.google.android.gms.internal.gtm.zzam) map.get(zzb)));
        HashMap map2 = new HashMap();
        com.google.android.gms.internal.gtm.zzam zzamVar = (com.google.android.gms.internal.gtm.zzam) map.get(zzc);
        if (zzamVar != null) {
            Object objZzl = zzfu.zzl(zzamVar);
            if (!(objZzl instanceof Map)) {
                Log.w("GoogleTagManager", "FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return zzfu.zzb();
            }
            for (Map.Entry entry : ((Map) objZzl).entrySet()) {
                map2.put(entry.getKey().toString(), entry.getValue());
            }
        }
        try {
            return zzfu.zzc(this.zzd.zza(strZzn, map2));
        } catch (Exception e) {
            Log.w("GoogleTagManager", "Custom macro/tag " + strZzn + " threw exception " + e.getMessage());
            return zzfu.zzb();
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return false;
    }
}
