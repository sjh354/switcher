package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzil {
    public static zzih zza(zzih zzihVar) {
        return ((zzihVar instanceof zzij) || (zzihVar instanceof zzii)) ? zzihVar : zzihVar instanceof Serializable ? new zzii(zzihVar) : new zzij(zzihVar);
    }

    public static zzih zzb(Object obj) {
        return new zzik(obj);
    }
}
