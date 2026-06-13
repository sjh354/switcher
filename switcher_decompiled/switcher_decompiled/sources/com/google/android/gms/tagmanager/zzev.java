package com.google.android.gms.tagmanager;

import android.os.Build;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzev extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.SDK_VERSION.toString();

    public zzev() {
        super(zza, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        return zzfu.zzc(Integer.valueOf(Build.VERSION.SDK_INT));
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return true;
    }
}
