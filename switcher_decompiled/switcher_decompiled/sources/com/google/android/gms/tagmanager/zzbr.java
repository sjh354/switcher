package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbr extends zzfk {
    private static final String zza = com.google.android.gms.internal.gtm.zza.EQUALS.toString();

    public zzbr() {
        super(zza);
    }

    @Override // com.google.android.gms.tagmanager.zzfk
    protected final boolean zzc(String str, String str2, Map map) {
        return str.equals(str2);
    }
}
