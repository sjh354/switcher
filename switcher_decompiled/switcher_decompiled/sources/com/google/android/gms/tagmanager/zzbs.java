package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbs extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.EVENT.toString();
    private final zzet zzb;

    public zzbs(zzet zzetVar) {
        super(zza, new String[0]);
        this.zzb = zzetVar;
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        String strZzb = this.zzb.zzb();
        return strZzb == null ? zzfu.zzb() : zzfu.zzc(strZzb);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return false;
    }
}
