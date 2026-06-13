package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbey implements zzbgq {
    private static final zzbey zza = new zzbey();

    private zzbey() {
    }

    public static zzbey zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbgq
    public final zzbgp zzb(Class cls) {
        if (!zzbff.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
        try {
            return (zzbgp) zzbff.zzad(cls.asSubclass(zzbff.class)).zzb(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbgq
    public final boolean zzc(Class cls) {
        return zzbff.class.isAssignableFrom(cls);
    }
}
