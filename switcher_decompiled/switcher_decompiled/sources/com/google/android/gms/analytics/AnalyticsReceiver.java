package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.gtm.zzfk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class AnalyticsReceiver extends BroadcastReceiver {
    private zzfk zza;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new zzfk();
        }
        zzfk.zzb(context, intent);
    }
}
