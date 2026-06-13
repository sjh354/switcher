package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzab {
    zzab(Context context) {
    }

    public static final boolean zza() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
