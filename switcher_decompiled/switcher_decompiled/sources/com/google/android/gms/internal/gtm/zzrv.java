package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzrv {
    private final List zza;
    private final Map zzb;
    private final String zzc;

    /* synthetic */ zzrv(List list, Map map, String str, int i, zzru zzruVar) {
        this.zza = Collections.unmodifiableList(list);
        this.zzb = Collections.unmodifiableMap(map);
        this.zzc = str;
    }

    public static zzrx zza() {
        return new zzrx(null);
    }

    public final String toString() {
        return "Rules: " + String.valueOf(this.zza) + "  Macros: " + String.valueOf(this.zzb);
    }

    public final String zzb() {
        return this.zzc;
    }

    public final List zzc() {
        return this.zza;
    }

    public final Map zzd() {
        return this.zzb;
    }
}
