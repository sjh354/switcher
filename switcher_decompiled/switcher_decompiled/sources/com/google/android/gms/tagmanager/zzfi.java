package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzfi implements zzbj {
    private final String zza;
    private final Context zzb;
    private final zzfh zzc;
    private final zzfg zzd = new zzfg();

    zzfi(Context context, zzfh zzfhVar) {
        this.zzb = context.getApplicationContext();
        this.zzc = zzfhVar;
        String str = Build.VERSION.RELEASE;
        Locale locale = Locale.getDefault();
        String string = null;
        if (locale != null && locale.getLanguage() != null && locale.getLanguage().length() != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(locale.getLanguage().toLowerCase());
            if (locale.getCountry() != null && locale.getCountry().length() != 0) {
                sb.append("-");
                sb.append(locale.getCountry().toLowerCase());
            }
            string = sb.toString();
        }
        this.zza = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleTagManager", "4.00", str, string, Build.MODEL, Build.ID);
    }

    static final URL zzc(zzbz zzbzVar) {
        try {
            return new URL(zzbzVar.zzc());
        } catch (MalformedURLException unused) {
            Log.e("GoogleTagManager", "Error trying to parse the GTM url.");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0071 A[Catch: all -> 0x00a5, TryCatch #0 {all -> 0x00a5, blocks: (B:14:0x005e, B:16:0x0071, B:17:0x008b), top: B:37:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008b A[Catch: all -> 0x00a5, TRY_LEAVE, TryCatch #0 {all -> 0x00a5, blocks: (B:14:0x005e, B:16:0x0071, B:17:0x008b), top: B:37:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.tagmanager.zzbj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(java.util.List r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzfi.zza(java.util.List):void");
    }

    @Override // com.google.android.gms.tagmanager.zzbj
    public final boolean zzb() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.zzb.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzdg.zzb.zzd("...no network connectivity");
        return false;
    }
}
