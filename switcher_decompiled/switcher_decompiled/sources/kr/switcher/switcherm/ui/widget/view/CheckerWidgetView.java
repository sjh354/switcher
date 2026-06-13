package kr.switcher.switcherm.ui.widget.view;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.widget.RemoteViews;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface CheckerWidgetView {
    void hideRefreshScreen(RemoteViews remoteViews);

    void setButtonEvent(RemoteViews remoteViews, List<PendingIntent> list);

    void setCheckerName(RemoteViews remoteViews, String str);

    void setCheckerRecentHistory(RemoteViews remoteViews, String str, String str2, String str3);

    void setCheckerSurveillanceIsActive(RemoteViews remoteViews, String str);

    void setSurveillanceLevel(RemoteViews remoteViews, int i);

    void showActiveInfo(RemoteViews remoteViews);

    void showBatteryEnough(RemoteViews remoteViews);

    void showBatteryLow(RemoteViews remoteViews);

    void showConnected(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str);

    void showConnecting(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str);

    void showDisabled(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str);

    void showInActiveInfo(RemoteViews remoteViews);

    void showRefreshScreen(RemoteViews remoteViews);

    void updateAppWidget(AppWidgetManager appWidgetManager, int i, RemoteViews remoteViews);
}
