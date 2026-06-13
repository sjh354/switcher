package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzh extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.ADWORDS_CLICK_REFERRER.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.COMPONENT.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.CONVERSION_ID.toString();
    private final Context zzd;

    public zzh(Context context) {
        super(zza, zzc);
        this.zzd = context;
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        com.google.android.gms.internal.gtm.zzam zzamVar = (com.google.android.gms.internal.gtm.zzam) map.get(zzc);
        if (zzamVar == null) {
            return zzfu.zzb();
        }
        String strZzn = zzfu.zzn(zzfu.zzl(zzamVar));
        com.google.android.gms.internal.gtm.zzam zzamVar2 = (com.google.android.gms.internal.gtm.zzam) map.get(zzb);
        String strZzn2 = zzamVar2 != null ? zzfu.zzn(zzfu.zzl(zzamVar2)) : null;
        Context context = this.zzd;
        String string = (String) zzcw.zza.get(strZzn);
        if (string == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            string = sharedPreferences != null ? sharedPreferences.getString(strZzn, "") : "";
            zzcw.zza.put(strZzn, string);
        }
        String strZza = zzcw.zza(string, strZzn2);
        return strZza != null ? zzfu.zzc(strZza) : zzfu.zzb();
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return true;
    }
}
