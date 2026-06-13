package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzlr {
    private static final zzlq zza;
    private static final zzlq zzb;

    static {
        zzlq zzlqVar;
        try {
            zzlqVar = (zzlq) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzlqVar = null;
        }
        zza = zzlqVar;
        zzb = new zzlq();
    }

    static zzlq zza() {
        return zza;
    }

    static zzlq zzb() {
        return zzb;
    }
}
