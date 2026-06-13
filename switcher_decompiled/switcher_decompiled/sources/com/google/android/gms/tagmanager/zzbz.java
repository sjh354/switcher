package com.google.android.gms.tagmanager;

import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbz {
    private final long zza;
    private final long zzb;
    private String zzc;

    zzbz(long j, long j2, long j3) {
        this.zza = j;
        this.zzb = j3;
    }

    final long zza() {
        return this.zzb;
    }

    final long zzb() {
        return this.zza;
    }

    final String zzc() {
        return this.zzc;
    }

    final void zzd(String str) {
        if (str == null || TextUtils.isEmpty(str.trim())) {
            return;
        }
        this.zzc = str;
    }
}
