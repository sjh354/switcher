package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzax extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.CUSTOM_VAR.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.NAME.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.DEFAULT_VALUE.toString();
    private final DataLayer zzd;

    public zzax(DataLayer dataLayer) {
        super(zza, zzb);
        this.zzd = dataLayer;
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        Object obj = this.zzd.get(zzfu.zzn(zzfu.zzl((com.google.android.gms.internal.gtm.zzam) map.get(zzb))));
        if (obj != null) {
            return zzfu.zzc(obj);
        }
        com.google.android.gms.internal.gtm.zzam zzamVar = (com.google.android.gms.internal.gtm.zzam) map.get(zzc);
        return zzamVar != null ? zzamVar : zzfu.zzb();
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return false;
    }
}
