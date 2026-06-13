package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzcb implements Runnable {
    final /* synthetic */ zzcd zza;
    final /* synthetic */ zzfa zzb;

    zzcb(zzcd zzcdVar, zzfa zzfaVar, byte[] bArr) {
        this.zza = zzcdVar;
        this.zzb = zzfaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zza.zza.zzg()) {
            return;
        }
        this.zza.zza.zzE("Connected to service after a timeout");
        zzce.zzi(this.zza.zza, this.zzb);
    }
}
