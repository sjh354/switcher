package com.google.android.gms.tagmanager;

import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbf {
    private int zza = 5;

    public final void zza(String str) {
        if (this.zza <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    public final void zzb(String str) {
        if (this.zza <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    public final void zzc(int i) {
        this.zza = i;
    }

    public final void zzd(String str) {
        if (this.zza <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }
}
