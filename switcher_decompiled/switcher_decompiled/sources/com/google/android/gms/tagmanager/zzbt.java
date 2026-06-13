package com.google.android.gms.tagmanager;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzbt {
    private final Set zzs;
    private final String zzt;

    public zzbt(String str, String... strArr) {
        this.zzt = str;
        this.zzs = new HashSet(strArr.length);
        for (String str2 : strArr) {
            this.zzs.add(str2);
        }
    }

    public abstract com.google.android.gms.internal.gtm.zzam zza(Map map);

    public abstract boolean zzb();

    public final String zze() {
        return this.zzt;
    }

    public final Set zzf() {
        return this.zzs;
    }

    final boolean zzg(Set set) {
        return set.containsAll(this.zzs);
    }
}
