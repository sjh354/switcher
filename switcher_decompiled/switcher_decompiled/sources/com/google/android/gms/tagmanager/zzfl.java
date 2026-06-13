package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzfl implements zzau {
    final /* synthetic */ TagManager zza;

    zzfl(TagManager tagManager) {
        this.zza = tagManager;
    }

    @Override // com.google.android.gms.tagmanager.zzau
    public final void zza(Map map) {
        Object obj = map.get("event");
        if (obj != null) {
            TagManager.zzb(this.zza, obj.toString());
        }
    }
}
