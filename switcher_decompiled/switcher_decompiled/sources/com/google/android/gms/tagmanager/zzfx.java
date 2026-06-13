package com.google.android.gms.tagmanager;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzfx {
    static String zza(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }
}
