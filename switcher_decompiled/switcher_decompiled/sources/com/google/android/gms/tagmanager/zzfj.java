package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzfj extends zzfk {
    private static final String zza = com.google.android.gms.internal.gtm.zza.STARTS_WITH.toString();

    public zzfj() {
        super(zza);
    }

    @Override // com.google.android.gms.tagmanager.zzfk
    protected final boolean zzc(String str, String str2, Map map) {
        return str.startsWith(str2);
    }
}
