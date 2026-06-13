package com.afollestad.materialdialogs.util;

import android.content.Context;
import android.graphics.Typeface;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceHelper {
    private static final SimpleArrayMap<String, Typeface> cache = new SimpleArrayMap<>();

    public static Typeface get(Context context, String str) {
        SimpleArrayMap<String, Typeface> simpleArrayMap = cache;
        synchronized (simpleArrayMap) {
            if (!simpleArrayMap.containsKey(str)) {
                try {
                    Typeface typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), String.format("fonts/%s", str));
                    simpleArrayMap.put(str, typefaceCreateFromAsset);
                    return typefaceCreateFromAsset;
                } catch (RuntimeException unused) {
                    return null;
                }
            }
            return simpleArrayMap.get(str);
        }
    }
}
