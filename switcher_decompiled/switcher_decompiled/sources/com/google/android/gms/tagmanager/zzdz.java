package com.google.android.gms.tagmanager;

import android.net.Uri;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzdz {
    private static zzdz zza;
    private volatile int zze = 1;
    private volatile String zzc = null;
    private volatile String zzb = null;
    private volatile String zzd = null;

    zzdz() {
    }

    static zzdz zza() {
        zzdz zzdzVar;
        synchronized (zzdz.class) {
            if (zza == null) {
                zza = new zzdz();
            }
            zzdzVar = zza;
        }
        return zzdzVar;
    }

    private static final String zzf(String str) {
        return str.split("&")[0].split("=")[1];
    }

    final String zzb() {
        return this.zzc;
    }

    final String zzc() {
        return this.zzb;
    }

    final synchronized boolean zzd(Uri uri) {
        try {
            String strDecode = URLDecoder.decode(uri.toString(), "UTF-8");
            if (strDecode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                zzdg.zzb.zzd("Container preview url: ".concat(String.valueOf(strDecode)));
                if (strDecode.matches(".*?&gtm_debug=x$")) {
                    this.zze = 3;
                } else {
                    this.zze = 2;
                }
                this.zzd = uri.getQuery().replace("&gtm_debug=x", "");
                if (this.zze == 2 || this.zze == 3) {
                    this.zzc = "/r?".concat(String.valueOf(this.zzd));
                }
                this.zzb = zzf(this.zzd);
                return true;
            }
            if (!strDecode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                Log.w("GoogleTagManager", "Invalid preview uri: ".concat(String.valueOf(strDecode)));
                return false;
            }
            if (!zzf(uri.getQuery()).equals(this.zzb)) {
                return false;
            }
            zzdg.zzb.zzd("Exit preview mode for container: ".concat(String.valueOf(this.zzb)));
            this.zze = 1;
            this.zzc = null;
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    final int zze() {
        return this.zze;
    }
}
