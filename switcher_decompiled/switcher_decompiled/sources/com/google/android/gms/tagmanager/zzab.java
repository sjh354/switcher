package com.google.android.gms.tagmanager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzab {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzak zzb;
    private Long zzc;

    zzab(zzak zzakVar, boolean z) {
        this.zzb = zzakVar;
        this.zza = z;
    }

    public final boolean zza(Container container) {
        if (!this.zza) {
            return !container.isDefault();
        }
        long lastRefreshTime = container.getLastRefreshTime();
        if (this.zzc == null) {
            this.zzc = Long.valueOf(this.zzb.zzi.zza());
        }
        return lastRefreshTime + this.zzc.longValue() >= this.zzb.zza.currentTimeMillis();
    }
}
