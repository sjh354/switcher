package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbz {
    private final String zza;
    private final String zzb;
    private final boolean zzc;
    private long zzd;
    private final Map zze;

    public zzbz(long j, String str, String str2, boolean z, long j2, Map map) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = j2;
        if (map != null) {
            this.zze = new HashMap(map);
        } else {
            this.zze = Collections.emptyMap();
        }
    }

    public final long zza() {
        return this.zzd;
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final Map zzd() {
        return this.zze;
    }

    public final void zze(long j) {
        this.zzd = j;
    }

    public final boolean zzf() {
        return this.zzc;
    }
}
