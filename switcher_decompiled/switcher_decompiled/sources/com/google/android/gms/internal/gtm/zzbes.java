package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbes {
    private static final zzbeq zza = new zzber();
    private static final zzbeq zzb;

    static {
        zzbeq zzbeqVar;
        try {
            zzbeqVar = (zzbeq) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzbeqVar = null;
        }
        zzb = zzbeqVar;
    }

    static zzbeq zza() {
        zzbeq zzbeqVar = zzb;
        if (zzbeqVar != null) {
            return zzbeqVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzbeq zzb() {
        return zza;
    }
}
