package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzdj extends BroadcastReceiver {
    static final String zza = "com.google.android.gms.tagmanager.zzdj";
    private final zzex zzb;

    zzdj(zzex zzexVar) {
        this.zzb = zzexVar;
    }

    public static void zza(Context context) {
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(zza, true);
        context.sendBroadcast(intent);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            if (!"com.google.analytics.RADIO_POWERED".equals(action) || intent.hasExtra(zza)) {
                return;
            }
            this.zzb.zzb();
            return;
        }
        Bundle extras = intent.getExtras();
        Boolean boolValueOf = Boolean.FALSE;
        if (extras != null) {
            boolValueOf = Boolean.valueOf(intent.getExtras().getBoolean("noConnectivity"));
        }
        this.zzb.zzc(!boolValueOf.booleanValue());
    }
}
