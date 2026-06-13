package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzfs extends zzbt {
    public zzfs(String str, String... strArr) {
        super(str, strArr);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        zzc(map);
        return zzfu.zzb();
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public boolean zzb() {
        return false;
    }

    public abstract void zzc(Map map);
}
