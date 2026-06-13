package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Message;
import com.google.android.gms.internal.gtm.zzgc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzfd implements zzfa {
    final /* synthetic */ zzfe zza;
    private final Handler zzb;

    /* synthetic */ zzfd(zzfe zzfeVar, zzfc zzfcVar) {
        this.zza = zzfeVar;
        this.zzb = new zzgc(zzfeVar.zzc.getMainLooper(), new zzfb(this));
    }

    private final Message zzd() {
        return this.zzb.obtainMessage(1, zzfe.zza);
    }

    @Override // com.google.android.gms.tagmanager.zzfa
    public final void zza() {
        this.zzb.removeMessages(1, zzfe.zza);
    }

    @Override // com.google.android.gms.tagmanager.zzfa
    public final void zzb() {
        this.zzb.removeMessages(1, zzfe.zza);
        this.zzb.sendMessage(zzd());
    }

    @Override // com.google.android.gms.tagmanager.zzfa
    public final void zzc(long j) {
        this.zzb.removeMessages(1, zzfe.zza);
        this.zzb.sendMessageDelayed(zzd(), 1800000L);
    }
}
