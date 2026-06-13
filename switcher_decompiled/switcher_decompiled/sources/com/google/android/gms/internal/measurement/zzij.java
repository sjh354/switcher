package com.google.android.gms.internal.measurement;

import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzij implements zzih {

    @CheckForNull
    volatile zzih zza;
    volatile boolean zzb;

    @CheckForNull
    Object zzc;

    zzij(zzih zzihVar) {
        zzihVar.getClass();
        this.zza = zzihVar;
    }

    public final String toString() {
        Object obj = this.zza;
        StringBuilder sb = new StringBuilder();
        sb.append("Suppliers.memoize(");
        if (obj == null) {
            obj = "<supplier that returned " + this.zzc + ">";
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    public final Object zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    zzih zzihVar = this.zza;
                    zzihVar.getClass();
                    Object objZza = zzihVar.zza();
                    this.zzc = objZza;
                    this.zzb = true;
                    this.zza = null;
                    return objZza;
                }
            }
        }
        return this.zzc;
    }
}
