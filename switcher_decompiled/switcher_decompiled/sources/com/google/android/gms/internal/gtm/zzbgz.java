package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbgz {
    private static final zzbgy zza;
    private static final zzbgy zzb;

    static {
        zzbgy zzbgyVar;
        try {
            zzbgyVar = (zzbgy) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzbgyVar = null;
        }
        zza = zzbgyVar;
        zzb = new zzbgy();
    }

    static zzbgy zza() {
        return zza;
    }

    static zzbgy zzb() {
        return zzb;
    }
}
