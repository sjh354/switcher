package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzio implements Runnable {
    final /* synthetic */ zzis zza;

    zzio(zzis zzisVar) {
        this.zza = zzisVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzis zzisVar = this.zza;
        zzisVar.zza = zzisVar.zzh;
    }
}
