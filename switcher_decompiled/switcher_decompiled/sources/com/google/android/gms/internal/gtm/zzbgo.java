package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbgo {
    private static final zzbgn zza;
    private static final zzbgn zzb;

    static {
        zzbgn zzbgnVar;
        try {
            zzbgnVar = (zzbgn) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzbgnVar = null;
        }
        zza = zzbgnVar;
        zzb = new zzbgn();
    }

    static zzbgn zza() {
        return zza;
    }

    static zzbgn zzb() {
        return zzb;
    }
}
