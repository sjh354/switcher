package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbv {
    public static final String zza;
    public static final String zzb;

    static {
        String strReplaceAll = String.valueOf(GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
        zza = strReplaceAll;
        zzb = "ma".concat(String.valueOf(strReplaceAll));
    }
}
