package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzkf extends zzap {
    final /* synthetic */ zzkg zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzkf(zzkg zzkgVar, zzgt zzgtVar) {
        super(zzgtVar);
        this.zza = zzkgVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzap
    public final void zzc() {
        zzkg zzkgVar = this.zza;
        zzkgVar.zzc.zzg();
        zzkgVar.zzd(false, false, zzkgVar.zzc.zzs.zzav().elapsedRealtime());
        zzkgVar.zzc.zzs.zzd().zzf(zzkgVar.zzc.zzs.zzav().elapsedRealtime());
    }
}
