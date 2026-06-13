package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzlh {
    private static final zzlg zza;
    private static final zzlg zzb;

    static {
        zzlg zzlgVar;
        try {
            zzlgVar = (zzlg) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzlgVar = null;
        }
        zza = zzlgVar;
        zzb = new zzlg();
    }

    static zzlg zza() {
        return zza;
    }

    static zzlg zzb() {
        return zzb;
    }
}
