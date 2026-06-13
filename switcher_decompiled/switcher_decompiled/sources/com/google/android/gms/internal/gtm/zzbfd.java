package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbfd extends zzben {
    final zzbgs zza;
    final Object zzb;
    final zzbgs zzc;
    final zzbfc zzd;

    zzbfd(zzbgs zzbgsVar, Object obj, zzbgs zzbgsVar2, zzbfc zzbfcVar, Class cls) {
        if (zzbgsVar == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
        if (zzbfcVar.zzc == zzbip.MESSAGE && zzbgsVar2 == null) {
            throw new IllegalArgumentException("Null messageDefaultInstance");
        }
        this.zza = zzbgsVar;
        this.zzb = obj;
        this.zzc = zzbgsVar2;
        this.zzd = zzbfcVar;
    }

    final Object zza(Object obj) {
        return this.zzd.zzc.zza() == zzbiq.ENUM ? this.zzd.zza.zza(((Integer) obj).intValue()) : obj;
    }
}
