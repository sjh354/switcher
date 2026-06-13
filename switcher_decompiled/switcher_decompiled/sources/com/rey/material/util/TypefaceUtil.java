package com.rey.material.util;

import android.content.Context;
import android.graphics.Typeface;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceUtil {
    private static final String PREFIX_ASSET = "asset:";
    private static final HashMap<String, Typeface> sCachedFonts = new HashMap<>();

    private TypefaceUtil() {
    }

    public static Typeface load(Context context, String str, int i) {
        if (str != null && str.startsWith(PREFIX_ASSET)) {
            HashMap<String, Typeface> map = sCachedFonts;
            synchronized (map) {
                try {
                    try {
                        if (!map.containsKey(str)) {
                            Typeface typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), str.substring(6));
                            map.put(str, typefaceCreateFromAsset);
                            return typefaceCreateFromAsset;
                        }
                        return map.get(str);
                    } catch (Exception unused) {
                        return Typeface.DEFAULT;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Typeface.create(str, i);
    }
}
