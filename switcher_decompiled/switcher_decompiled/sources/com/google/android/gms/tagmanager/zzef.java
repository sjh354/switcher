package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.gtm.zzsh;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzef implements Runnable {
    private final Context zza;
    private final zzsh zzb;
    private final String zzc;
    private final String zzd;
    private zzdf zze;
    private volatile zzao zzf;
    private volatile String zzg;
    private volatile String zzh;

    public zzef(Context context, String str, zzao zzaoVar) {
        zzsh zzshVar = new zzsh();
        this.zza = context;
        this.zzb = zzshVar;
        this.zzc = str;
        this.zzf = zzaoVar;
        String strConcat = "/r?id=".concat(String.valueOf(str));
        this.zzd = strConcat;
        this.zzg = strConcat;
        this.zzh = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x01bd A[Catch: all -> 0x01d0, TryCatch #0 {, blocks: (B:36:0x0134, B:38:0x013a, B:40:0x0149, B:41:0x0164, B:43:0x0166, B:44:0x0182, B:46:0x01bd, B:47:0x01c4), top: B:67:0x0134 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzef.run():void");
    }

    final void zza(String str) {
        if (str == null) {
            str = this.zzd;
        } else {
            zzdg.zzb.zza("Setting CTFE URL path: ".concat(str));
        }
        this.zzg = str;
    }

    final void zzb(zzdf zzdfVar) {
        this.zze = zzdfVar;
    }

    final void zzc(String str) {
        zzdg.zzb.zza("Setting previous container version: ".concat(String.valueOf(str)));
        this.zzh = str;
    }
}
