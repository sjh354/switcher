package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzat {
    public final String zza;
    public final Object zzb;

    zzat(String str, Object obj) {
        this.zza = str;
        this.zzb = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzat)) {
            return false;
        }
        zzat zzatVar = (zzat) obj;
        if (!this.zza.equals(zzatVar.zza)) {
            return false;
        }
        Object obj2 = this.zzb;
        if (obj2 == null && zzatVar.zzb == null) {
            return true;
        }
        return obj2 != null && obj2.equals(zzatVar.zzb);
    }

    public final int hashCode() {
        Preconditions.checkNotNull(this.zzb);
        return Arrays.hashCode(new Integer[]{Integer.valueOf(this.zza.hashCode()), Integer.valueOf(this.zzb.hashCode())});
    }

    public final String toString() {
        return "Key: " + this.zza + " value: " + String.valueOf(this.zzb);
    }
}
