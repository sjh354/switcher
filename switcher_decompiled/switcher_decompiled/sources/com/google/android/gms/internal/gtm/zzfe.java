package com.google.android.gms.internal.gtm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzfe extends BroadcastReceiver {
    static final String zza = "com.google.android.gms.internal.gtm.zzfe";
    private final zzbx zzb;
    private boolean zzc;
    private boolean zzd;

    zzfe(zzbx zzbxVar) {
        Preconditions.checkNotNull(zzbxVar);
        this.zzb = zzbxVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zzb.zzm();
        this.zzb.zzf();
        String action = intent.getAction();
        this.zzb.zzm().zzO("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zZze = zze();
            if (this.zzd != zZze) {
                this.zzd = zZze;
                zzbs zzbsVarZzf = this.zzb.zzf();
                zzbsVarZzf.zzO("Network connectivity status changed", Boolean.valueOf(zZze));
                zzbsVarZzf.zzq().zzi(new zzbl(zzbsVarZzf, zZze));
                return;
            }
            return;
        }
        if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.zzb.zzm().zzR("NetworkBroadcastReceiver received unknown action", action);
        } else {
            if (intent.hasExtra(zza)) {
                return;
            }
            zzbs zzbsVarZzf2 = this.zzb.zzf();
            zzbsVarZzf2.zzN("Radio powered up");
            zzbsVarZzf2.zzc();
        }
    }

    public final void zza() {
        this.zzb.zzm();
        this.zzb.zzf();
        if (this.zzc) {
            return;
        }
        Context contextZza = this.zzb.zza();
        contextZza.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
        intentFilter.addCategory(contextZza.getPackageName());
        contextZza.registerReceiver(this, intentFilter);
        this.zzd = zze();
        this.zzb.zzm().zzO("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzd));
        this.zzc = true;
    }

    public final void zzb() {
        Context contextZza = this.zzb.zza();
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(contextZza.getPackageName());
        intent.putExtra(zza, true);
        contextZza.sendOrderedBroadcast(intent, null);
    }

    public final void zzc() {
        if (this.zzc) {
            this.zzb.zzm().zzN("Unregistering connectivity change receiver");
            this.zzc = false;
            this.zzd = false;
            try {
                this.zzb.zza().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zzb.zzm().zzJ("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public final boolean zzd() {
        if (!this.zzc) {
            this.zzb.zzm().zzQ("Connectivity unknown. Receiver not registered");
        }
        return this.zzd;
    }

    protected final boolean zze() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.zzb.zza().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (SecurityException unused) {
        }
        return false;
    }
}
