package com.google.android.gms.tagmanager;

import android.os.Build;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbi extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.DEVICE_NAME.toString();

    public zzbi() {
        super(zza, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (!str2.startsWith(str) && !str.equals("unknown")) {
            str2 = str + " " + str2;
        }
        return zzfu.zzc(str2);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return true;
    }
}
