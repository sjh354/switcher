package kr.switcher.switcherm.ui.widget.view;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.widget.RemoteViews;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface AirconWidgetView {
    void hideAirconTemperature(RemoteViews remoteViews);

    void setAirconName(RemoteViews remoteViews, String str);

    void setAirconTemperature(RemoteViews remoteViews, String str);

    void setButtonEvent(RemoteViews remoteViews, List<PendingIntent> list);

    void showConnected(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str);

    void showConnecting(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str);

    void showDisabled(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str);

    void showRefresh(RemoteViews remoteViews);

    void updateAppWidget(AppWidgetManager appWidgetManager, int i, RemoteViews remoteViews);
}
