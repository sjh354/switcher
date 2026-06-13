package com.github.lzyzsd.circleprogress;

import android.content.res.Resources;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    public static float dp2px(Resources resources, float f) {
        return (f * resources.getDisplayMetrics().density) + 0.5f;
    }

    public static float sp2px(Resources resources, float f) {
        return f * resources.getDisplayMetrics().scaledDensity;
    }
}
