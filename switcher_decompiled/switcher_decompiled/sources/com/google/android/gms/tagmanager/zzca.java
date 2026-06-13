package com.google.android.gms.tagmanager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzca implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcb zzc;
    final /* synthetic */ zzcb zzd;

    zzca(zzcb zzcbVar, zzcb zzcbVar2, long j, String str, byte[] bArr) {
        this.zzc = zzcbVar;
        this.zzd = zzcbVar2;
        this.zza = j;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzc.zze == null) {
            zzfe zzfeVarZzg = zzfe.zzg();
            zzfeVarZzg.zzl(this.zzc.zzf, this.zzd);
            this.zzc.zze = zzfeVarZzg.zzf();
        }
        this.zzc.zze.zzb(this.zza, this.zzb);
    }
}
