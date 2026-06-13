package com.google.android.gms.internal.gtm;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzco implements Callable {
    final /* synthetic */ zzcp zza;

    zzco(zzcp zzcpVar) {
        this.zza = zzcpVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() throws Exception {
        return this.zza.zzf();
    }
}
