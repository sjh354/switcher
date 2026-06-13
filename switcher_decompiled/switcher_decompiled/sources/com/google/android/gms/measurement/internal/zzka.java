package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzka implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzki zzb;

    zzka(zzki zzkiVar, long j) {
        this.zzb = zzkiVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzki.zzl(this.zzb, this.zza);
    }
}
