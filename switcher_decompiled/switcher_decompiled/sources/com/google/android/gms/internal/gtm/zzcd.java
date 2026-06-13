package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcd implements ServiceConnection {
    final /* synthetic */ zzce zza;
    private volatile boolean zzb;
    private volatile zzfa zzc;

    protected zzcd(zzce zzceVar) {
        this.zza = zzceVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzfa zzfaVar;
        Preconditions.checkMainThread("AnalyticsServiceConnection.onServiceConnected");
        synchronized (this) {
            try {
                if (iBinder == null) {
                    this.zza.zzI("Service connected with null binder");
                    return;
                }
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(interfaceDescriptor)) {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                        zzfaVar = iInterfaceQueryLocalInterface instanceof zzfa ? (zzfa) iInterfaceQueryLocalInterface : new zzfa(iBinder);
                        try {
                            this.zza.zzN("Bound to IAnalyticsService interface");
                        } catch (RemoteException unused) {
                            this.zza.zzI("Service connect failed to get IAnalyticsService");
                        }
                    } else {
                        this.zza.zzJ("Got binder with a wrong descriptor", interfaceDescriptor);
                        zzfaVar = null;
                    }
                } catch (RemoteException unused2) {
                    zzfaVar = null;
                }
                if (zzfaVar == null) {
                    try {
                        ConnectionTracker.getInstance().unbindService(this.zza.zzo(), this.zza.zza);
                    } catch (IllegalArgumentException unused3) {
                    }
                } else if (this.zzb) {
                    this.zzc = zzfaVar;
                } else {
                    this.zza.zzQ("onServiceConnected received after the timeout limit");
                    this.zza.zzq().zzi(new zzcb(this, zzfaVar, null));
                }
            } finally {
                notifyAll();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("AnalyticsServiceConnection.onServiceDisconnected");
        this.zza.zzq().zzi(new zzcc(this, componentName));
    }

    public final zzfa zza() {
        com.google.android.gms.analytics.zzr.zzh();
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        Context contextZzo = this.zza.zzo();
        intent.putExtra("app_package_name", contextZzo.getPackageName());
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (this) {
            this.zzc = null;
            this.zzb = true;
            boolean zBindService = connectionTracker.bindService(contextZzo, intent, this.zza.zza, 129);
            this.zza.zzO("Bind to service requested", Boolean.valueOf(zBindService));
            if (!zBindService) {
                this.zzb = false;
                return null;
            }
            try {
                this.zza.zzw();
                wait(((Long) zzew.zzL.zzb()).longValue());
            } catch (InterruptedException unused) {
                this.zza.zzQ("Wait for service connect was interrupted");
            }
            this.zzb = false;
            zzfa zzfaVar = this.zzc;
            this.zzc = null;
            if (zzfaVar == null) {
                this.zza.zzI("Successfully bound to service but never got onServiceConnected callback");
            }
            return zzfaVar;
        }
    }
}
