package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zznx implements zznw {
    public static final zzia zza = new zzhx(zzhp.zza("com.google.android.gms.measurement")).zza().zzf("measurement.client.firebase_feature_rollout.v1.enable", true);

    @Override // com.google.android.gms.internal.measurement.zznw
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final boolean zzb() {
        return ((Boolean) zza.zzb()).booleanValue();
    }
}
