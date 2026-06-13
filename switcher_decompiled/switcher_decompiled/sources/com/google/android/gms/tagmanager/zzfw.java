package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzfw extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.UPPERCASE_STRING.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.ARG0.toString();

    public zzfw() {
        super(zza, zzb);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        return zzfu.zzc(zzfu.zzn(zzfu.zzl((com.google.android.gms.internal.gtm.zzam) map.get(zzb))).toUpperCase());
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return true;
    }
}
