package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzif implements Serializable {
    zzif() {
    }

    public static zzif zzc() {
        return zzid.zza;
    }

    public static zzif zzd(Object obj) {
        return new zzig(obj);
    }

    public abstract Object zza();

    public abstract boolean zzb();
}
