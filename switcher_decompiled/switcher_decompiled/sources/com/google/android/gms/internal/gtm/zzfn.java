package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzfn implements zzdb {
    final /* synthetic */ Runnable zza;
    final /* synthetic */ zzfp zzb;

    zzfn(zzfp zzfpVar, Runnable runnable) {
        this.zzb = zzfpVar;
        this.zza = runnable;
    }

    @Override // com.google.android.gms.internal.gtm.zzdb
    public final void zza(Throwable th) {
        this.zzb.zzb.post(this.zza);
    }
}
