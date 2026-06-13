package com.google.android.gms.internal.measurement;

import android.os.Build;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbs {
    public static final int zza;

    static {
        zza = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
    }
}
