package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzs extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.CONSTANT.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.VALUE.toString();

    public zzs() {
        super(zza, zzb);
    }

    public static String zzc() {
        return zza;
    }

    public static String zzd() {
        return zzb;
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        return (com.google.android.gms.internal.gtm.zzam) map.get(zzb);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return true;
    }
}
