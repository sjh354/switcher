package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbgj implements zzbgq {
    private final zzbgq[] zza;

    zzbgj(zzbgq... zzbgqVarArr) {
        this.zza = zzbgqVarArr;
    }

    @Override // com.google.android.gms.internal.gtm.zzbgq
    public final zzbgp zzb(Class cls) {
        zzbgq[] zzbgqVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzbgq zzbgqVar = zzbgqVarArr[i];
            if (zzbgqVar.zzc(cls)) {
                return zzbgqVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    @Override // com.google.android.gms.internal.gtm.zzbgq
    public final boolean zzc(Class cls) {
        zzbgq[] zzbgqVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzbgqVarArr[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
