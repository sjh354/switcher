package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzkk extends zzap {
    final /* synthetic */ zzkl zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzkk(zzkl zzklVar, zzgt zzgtVar) {
        super(zzgtVar);
        this.zza = zzklVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzap
    public final void zzc() {
        this.zza.zza();
        this.zza.zzs.zzay().zzj().zza("Starting upload from DelayedRunnable");
        this.zza.zzf.zzX();
    }
}
