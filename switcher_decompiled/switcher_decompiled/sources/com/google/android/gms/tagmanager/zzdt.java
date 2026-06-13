package com.google.android.gms.tagmanager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzdt implements zzfh {
    final /* synthetic */ zzdv zza;

    zzdt(zzdv zzdvVar) {
        this.zza = zzdvVar;
    }

    @Override // com.google.android.gms.tagmanager.zzfh
    public final void zza(zzbz zzbzVar) {
        long jZza = zzbzVar.zza();
        if (jZza == 0) {
            zzdv.zzi(this.zza, zzbzVar.zzb(), this.zza.zzg.currentTimeMillis());
            return;
        }
        if (jZza + 14400000 < this.zza.zzg.currentTimeMillis()) {
            this.zza.zzl(zzbzVar.zzb());
            zzdg.zzb.zzd("Giving up on failed hitId: " + zzbzVar.zzb());
        }
    }
}
