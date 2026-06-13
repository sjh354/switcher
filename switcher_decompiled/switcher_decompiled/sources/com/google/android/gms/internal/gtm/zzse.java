package com.google.android.gms.internal.gtm;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzse {
    public static final Integer zza = 0;
    public static final Integer zzb = 1;
    private final Context zzc;
    private final ExecutorService zzd;

    public zzse(Context context) {
        ExecutorService executorServiceZza = zzgb.zza().zza(2);
        this.zzc = context;
        this.zzd = executorServiceZza;
    }
}
