package com.google.android.gms.internal.firebase_messaging;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
@Encodable
public abstract class zze {
    private static final zzx zza;

    static {
        zzw zzwVar = new zzw();
        zzd.zza.configure(zzwVar);
        zza = zzwVar.zza();
    }

    private zze() {
    }

    public static void zzb(Object obj, OutputStream outputStream) throws IOException {
        zza.zza(obj, outputStream);
    }

    public static byte[] zzc(Object obj) {
        zzx zzxVar = zza;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            zzxVar.zza(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    public abstract MessagingClientEventExtension zza();
}
