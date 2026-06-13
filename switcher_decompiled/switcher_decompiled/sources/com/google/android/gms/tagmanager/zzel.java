package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.gtm.zzgb;
import com.google.android.gms.internal.gtm.zzro;
import java.io.File;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzel implements zzaj {
    private final Context zza;
    private final String zzb;
    private final ExecutorService zzc = zzgb.zza().zza(2);
    private zzdf zzd;

    zzel(Context context, String str) {
        this.zza = context;
        this.zzb = str;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final synchronized void release() {
        this.zzc.shutdown();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00ac A[Catch: IOException -> 0x00d9, TryCatch #0 {IOException -> 0x00d9, blocks: (B:5:0x003a, B:6:0x0042, B:7:0x005a, B:9:0x0060, B:10:0x0097, B:16:0x00ac, B:18:0x00b4, B:19:0x00b8, B:21:0x00cd, B:22:0x00d3, B:12:0x009c, B:13:0x00a2), top: B:28:0x003a, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b4 A[Catch: IOException -> 0x00d9, TRY_LEAVE, TryCatch #0 {IOException -> 0x00d9, blocks: (B:5:0x003a, B:6:0x0042, B:7:0x005a, B:9:0x0060, B:10:0x0097, B:16:0x00ac, B:18:0x00b4, B:19:0x00b8, B:21:0x00cd, B:22:0x00d3, B:12:0x009c, B:13:0x00a2), top: B:28:0x003a, inners: #1, #2, #3, #4 }] */
    @Override // com.google.android.gms.tagmanager.zzaj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.gtm.zzrv zza(int r12) {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzel.zza(int):com.google.android.gms.internal.gtm.zzrv");
    }

    @Override // com.google.android.gms.tagmanager.zzaj
    public final void zzb() {
        this.zzc.execute(new zzej(this));
    }

    @Override // com.google.android.gms.tagmanager.zzaj
    public final void zzc(zzro zzroVar) {
        this.zzc.execute(new zzek(this, zzroVar));
    }

    @Override // com.google.android.gms.tagmanager.zzaj
    public final void zzd(zzdf zzdfVar) {
        this.zzd = zzdfVar;
    }

    final File zze() {
        return new File(this.zza.getDir("google_tagmanager", 0), "resource_".concat(String.valueOf(this.zzb)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void zzf() {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzel.zzf():void");
    }
}
