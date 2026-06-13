package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzc implements Runnable {
    final /* synthetic */ BroadcastReceiver.PendingResult zza;

    zzc(CampaignTrackingReceiver campaignTrackingReceiver, BroadcastReceiver.PendingResult pendingResult) {
        this.zza = pendingResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BroadcastReceiver.PendingResult pendingResult = this.zza;
        if (pendingResult != null) {
            pendingResult.finish();
        }
    }
}
