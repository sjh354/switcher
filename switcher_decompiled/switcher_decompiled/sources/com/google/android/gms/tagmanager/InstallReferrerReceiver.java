package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.CampaignTrackingReceiver;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class InstallReferrerReceiver extends CampaignTrackingReceiver {
    @Override // com.google.android.gms.analytics.CampaignTrackingReceiver
    protected final void zza(Context context, String str) {
        zzcw.zzd(str);
        zzcw.zze(context, str);
    }
}
