package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzdq extends zzdx {
    public zzdq(String str) {
        super(str);
    }

    protected abstract boolean zzc(zzft zzftVar, zzft zzftVar2, Map map);

    @Override // com.google.android.gms.tagmanager.zzdx
    protected final boolean zzd(com.google.android.gms.internal.gtm.zzam zzamVar, com.google.android.gms.internal.gtm.zzam zzamVar2, Map map) {
        zzft zzftVarZze = zzfu.zze(zzfu.zzl(zzamVar));
        zzft zzftVarZze2 = zzfu.zze(zzfu.zzl(zzamVar2));
        if (zzftVarZze == zzfu.zzd() || zzftVarZze2 == zzfu.zzd()) {
            return false;
        }
        return zzc(zzftVarZze, zzftVarZze2, map);
    }
}
