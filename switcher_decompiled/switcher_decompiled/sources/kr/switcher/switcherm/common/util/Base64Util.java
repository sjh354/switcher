package kr.switcher.switcherm.common.util;

import android.util.Base64;

/* JADX INFO: loaded from: classes2.dex */
public class Base64Util {
    public static String encodeBase64(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    public static String decodeBase64(String str) {
        return new String(Base64.decode(str, 0));
    }
}
