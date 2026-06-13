package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzdc extends zzdq {
    private static final String zza = com.google.android.gms.internal.gtm.zza.LESS_EQUALS.toString();

    public zzdc() {
        super(zza);
    }

    @Override // com.google.android.gms.tagmanager.zzdq
    protected final boolean zzc(zzft zzftVar, zzft zzftVar2, Map map) {
        return zzftVar.compareTo(zzftVar2) <= 0;
    }
}
