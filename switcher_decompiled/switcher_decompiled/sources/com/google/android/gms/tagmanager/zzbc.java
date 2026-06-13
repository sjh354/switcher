package com.google.android.gms.tagmanager;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbc {
    final String zza;
    final byte[] zzb;

    zzbc(String str, byte[] bArr) {
        this.zza = str;
        this.zzb = bArr;
    }

    public final String toString() {
        return "KeyAndSerialized: key = " + this.zza + " serialized hash = " + Arrays.hashCode(this.zzb);
    }
}
