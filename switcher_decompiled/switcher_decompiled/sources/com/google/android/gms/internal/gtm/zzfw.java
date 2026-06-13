package com.google.android.gms.internal.gtm;

import android.os.Build;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfw {
    public static final int zza;

    static {
        zza = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
    }
}
