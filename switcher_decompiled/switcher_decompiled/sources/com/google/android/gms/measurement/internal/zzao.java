package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzao implements Runnable {
    final /* synthetic */ zzgt zza;
    final /* synthetic */ zzap zzb;

    zzao(zzap zzapVar, zzgt zzgtVar) {
        this.zzb = zzapVar;
        this.zza = zzgtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzaw();
        if (zzab.zza()) {
            this.zza.zzaz().zzp(this);
            return;
        }
        boolean zZze = this.zzb.zze();
        this.zzb.zzd = 0L;
        if (zZze) {
            this.zzb.zzc();
        }
    }
}
