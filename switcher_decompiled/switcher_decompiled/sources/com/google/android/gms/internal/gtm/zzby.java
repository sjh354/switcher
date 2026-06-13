package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzby {
    private final Context zza;
    private final Context zzb;

    public zzby(Context context) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext, "Application context can't be null");
        this.zza = applicationContext;
        this.zzb = applicationContext;
    }

    public final Context zza() {
        return this.zza;
    }

    public final Context zzb() {
        return this.zzb;
    }
}
