package kr.switcher.switcherm.ui.widget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetIdFinder {
    public static int[] getExistedOneButtonWidgetIds(Context context) {
        return getExistedWidgetIds(context, OneButtonWidget.class);
    }

    public static int[] getExistedTwoButtonWidgetIds(Context context) {
        return getExistedWidgetIds(context, TwoButtonWidget.class);
    }

    public static int[] getExistedAirconWidgetIds(Context context) {
        return getExistedWidgetIds(context, AirconWidget.class);
    }

    public static int[] getExistedCheckerWidgetIds(Context context) {
        return getExistedWidgetIds(context, CheckerWidget.class);
    }

    public static int[] getExistedSettopWidgetIds(Context context) {
        return getExistedWidgetIds(context, SettopWidget.class);
    }

    private static int[] getExistedWidgetIds(Context context, Class<?> cls) {
        int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, cls));
        return appWidgetIds == null ? new int[0] : appWidgetIds;
    }
}
