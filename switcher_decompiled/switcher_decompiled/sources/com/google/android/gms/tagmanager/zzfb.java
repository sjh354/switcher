package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzfb implements Handler.Callback {
    final /* synthetic */ zzfd zza;

    zzfb(zzfd zzfdVar) {
        this.zza = zzfdVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 1 && zzfe.zza.equals(message.obj)) {
            this.zza.zza.zza();
            zzfd zzfdVar = this.zza;
            if (!zzfdVar.zza.zzm()) {
                zzfdVar.zzc(1800000L);
            }
        }
        return true;
    }
}
