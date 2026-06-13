package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zziq implements Runnable {
    final /* synthetic */ zzik zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzis zzc;

    zziq(zzis zzisVar, zzik zzikVar, long j) {
        this.zzc = zzisVar;
        this.zza = zzikVar;
        this.zzb = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzB(this.zza, false, this.zzb);
        zzis zzisVar = this.zzc;
        zzisVar.zza = null;
        zzisVar.zzs.zzt().zzG(null);
    }
}
