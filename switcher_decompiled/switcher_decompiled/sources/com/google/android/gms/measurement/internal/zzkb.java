package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzkb implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzki zzb;

    zzkb(zzki zzkiVar, long j) {
        this.zzb = zzkiVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzki.zzj(this.zzb, this.zza);
    }
}
