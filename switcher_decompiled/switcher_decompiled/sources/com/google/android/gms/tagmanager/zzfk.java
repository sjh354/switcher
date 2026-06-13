package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzfk extends zzdx {
    public zzfk(String str) {
        super(str);
    }

    protected abstract boolean zzc(String str, String str2, Map map);

    @Override // com.google.android.gms.tagmanager.zzdx
    protected final boolean zzd(com.google.android.gms.internal.gtm.zzam zzamVar, com.google.android.gms.internal.gtm.zzam zzamVar2, Map map) {
        String strZzn = zzfu.zzn(zzfu.zzl(zzamVar));
        String strZzn2 = zzfu.zzn(zzfu.zzl(zzamVar2));
        if (strZzn == zzfu.zzm() || strZzn2 == zzfu.zzm()) {
            return false;
        }
        return zzc(strZzn, strZzn2, map);
    }
}
