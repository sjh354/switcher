package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzhh implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzid zzb;

    zzhh(zzid zzidVar, long j) {
        this.zzb = zzidVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzs.zzm().zzf.zzb(this.zza);
        this.zzb.zzs.zzay().zzc().zzb("Session timeout duration set", Long.valueOf(this.zza));
    }
}
