package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbg {
    private static zzbg zza;
    private static final Object zzb = new Object();
    private final zzeb zzc;
    private final zzcb zzd;

    private zzbg(Context context) {
        zzcb zzcbVarZzb = zzcb.zzb(context);
        zzew zzewVar = new zzew();
        this.zzd = zzcbVarZzb;
        this.zzc = zzewVar;
    }

    public static zzbg zzb(Context context) {
        zzbg zzbgVar;
        synchronized (zzb) {
            if (zza == null) {
                zza = new zzbg(context);
            }
            zzbgVar = zza;
        }
        return zzbgVar;
    }

    public final boolean zza(String str) {
        if (this.zzc.zza()) {
            this.zzd.zzf(str, System.currentTimeMillis());
            return true;
        }
        Log.w("GoogleTagManager", "Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return false;
    }
}
