package com.google.android.gms.internal.gtm;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzcw implements Logger {
    private int zza = 2;
    private boolean zzb;

    zzcw() {
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void error(Exception exc) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void error(String str) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public final int getLogLevel() {
        return this.zza;
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void info(String str) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void setLogLevel(int i) {
        this.zza = i;
        if (this.zzb) {
            return;
        }
        Log.i((String) zzew.zzc.zzb(), "Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + ((String) zzew.zzc.zzb()) + " DEBUG");
        this.zzb = true;
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void verbose(String str) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void warn(String str) {
    }
}
