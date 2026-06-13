package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzkp implements Runnable {
    final /* synthetic */ zzla zza;
    final /* synthetic */ zzkz zzb;

    zzkp(zzkz zzkzVar, zzla zzlaVar) {
        this.zzb = zzkzVar;
        this.zza = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkz.zzy(this.zzb, this.zza);
        this.zzb.zzS();
    }
}
