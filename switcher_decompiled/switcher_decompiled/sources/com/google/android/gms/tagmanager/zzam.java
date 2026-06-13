package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzam extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.CONTAINER_VERSION.toString();
    private final String zzb;

    public zzam(String str) {
        super(zza, new String[0]);
        this.zzb = str;
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        String str = this.zzb;
        return str == null ? zzfu.zzb() : zzfu.zzc(str);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return true;
    }
}
