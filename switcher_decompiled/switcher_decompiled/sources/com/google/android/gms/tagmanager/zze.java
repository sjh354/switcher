package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zze extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.ADVERTISER_ID.toString();
    private final zzd zzb;

    zze(zzd zzdVar) {
        super(zza, new String[0]);
        this.zzb = zzdVar;
        zzdVar.zzc();
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        String strZzc = this.zzb.zzc();
        return strZzc == null ? zzfu.zzb() : zzfu.zzc(strZzc);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return false;
    }
}
