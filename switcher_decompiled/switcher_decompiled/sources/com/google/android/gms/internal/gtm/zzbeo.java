package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbeo {
    private final Object zza;
    private final int zzb;

    zzbeo(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbeo)) {
            return false;
        }
        zzbeo zzbeoVar = (zzbeo) obj;
        return this.zza == zzbeoVar.zza && this.zzb == zzbeoVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
