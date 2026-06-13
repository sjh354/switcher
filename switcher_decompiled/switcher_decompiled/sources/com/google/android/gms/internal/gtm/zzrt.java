package com.google.android.gms.internal.gtm;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzrt {
    private final Map zza = new HashMap();
    private zzam zzb;

    private zzrt() {
    }

    public final zzrr zza() {
        return new zzrr(this.zza, this.zzb, null);
    }

    public final zzrt zzb(String str, zzam zzamVar) {
        this.zza.put(str, zzamVar);
        return this;
    }

    public final zzrt zzc(zzam zzamVar) {
        this.zzb = zzamVar;
        return this;
    }

    /* synthetic */ zzrt(zzrs zzrsVar) {
    }
}
