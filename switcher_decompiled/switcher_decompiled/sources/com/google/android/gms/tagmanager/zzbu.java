package com.google.android.gms.tagmanager;

import android.os.Build;
import android.util.Log;
import java.io.File;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbu {
    static boolean zza(String str) {
        try {
            if (Integer.parseInt(Build.VERSION.SDK) >= 9) {
                File file = new File(str);
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
                return true;
            }
        } catch (NumberFormatException unused) {
            Log.e("GoogleTagManager", "Invalid version number: ".concat(String.valueOf(Build.VERSION.SDK)));
        }
        return false;
    }
}
