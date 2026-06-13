package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzrp {
    final Map zza;
    private final Context zzb;
    private final zzse zzc;
    private final Clock zzd;
    private final Map zze;

    public zzrp(Context context) {
        HashMap map = new HashMap();
        zzse zzseVar = new zzse(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.zza = new HashMap();
        this.zzb = context;
        this.zzd = defaultClock;
        this.zzc = zzseVar;
        this.zze = map;
    }
}
