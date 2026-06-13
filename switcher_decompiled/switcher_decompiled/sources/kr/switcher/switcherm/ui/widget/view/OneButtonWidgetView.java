package kr.switcher.switcherm.ui.widget.view;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.widget.RemoteViews;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface OneButtonWidgetView {
    void setButtonEvent(RemoteViews remoteViews, List<PendingIntent> list);

    void setSwitcherName(RemoteViews remoteViews, String str);

    void showConnected(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str);

    void showConnecting(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str);

    void showDisabled(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str);

    void showNoBlePermission(RemoteViews remoteViews);

    void updateAppWidget(AppWidgetManager appWidgetManager, int i, RemoteViews remoteViews);
}
