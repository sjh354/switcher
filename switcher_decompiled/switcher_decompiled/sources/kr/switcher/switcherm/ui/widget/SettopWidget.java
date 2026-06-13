package kr.switcher.switcherm.ui.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import java.util.List;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.linker.LinkerHandler;
import kr.switcher.switcherm.preference.WidgetPreference;
import kr.switcher.switcherm.ui.widget.helper.WidgetAnimation;
import kr.switcher.switcherm.ui.widget.presenter.SettopWidgetPresenter;
import kr.switcher.switcherm.ui.widget.view.SettopWidgetView;

/* JADX INFO: loaded from: classes2.dex */
public class SettopWidget extends AppWidgetProvider implements SettopWidgetView {
    public static final String ACTION_SETTOP_WIDGET_STATE = "kr.switcher.switcherm.ui.widget.SettopWidget.WIDGET_STATE";
    private static final String TAG = "SettopWidget";
    private SettopWidgetPresenter presenter;

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        IOLog.d(TAG, "onEnabled()");
        super.onEnabled(context);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IOLog.d(TAG, "onReceive()");
        super.onReceive(context, intent);
        int[] existedSettopWidgetIds = WidgetIdFinder.getExistedSettopWidgetIds(context);
        if (existedSettopWidgetIds.length > 0) {
            onUpdate(context, AppWidgetManager.getInstance(context), existedSettopWidgetIds);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        SettopWidgetPresenter settopWidgetPresenter = new SettopWidgetPresenter(this, IODeviceHandler.getInstance(), LinkerHandler.getInstance(), new WidgetPreference(), context);
        this.presenter = settopWidgetPresenter;
        settopWidgetPresenter.onUpdate(context, appWidgetManager, iArr);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] iArr) {
        SettopWidgetPresenter settopWidgetPresenter = new SettopWidgetPresenter(this, IODeviceHandler.getInstance(), LinkerHandler.getInstance(), new WidgetPreference(), context);
        this.presenter = settopWidgetPresenter;
        settopWidgetPresenter.onDeleted(iArr);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.SettopWidgetView
    public void showDisabled(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str) {
        WidgetAnimation.getInstance().stopAnimation(i);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.SettopWidgetView
    public void showConnected(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str) {
        WidgetAnimation.getInstance().stopAnimation(i);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.SettopWidgetView
    public void showConnecting(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str) {
        WidgetAnimation.getInstance().startAnimation(remoteViews, appWidgetManager, i, str);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.SettopWidgetView
    public void setSettopName(RemoteViews remoteViews, String str) {
        remoteViews.setTextViewText(R.id.tv_settop_name, str);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.SettopWidgetView
    public void showSettopConnected(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.tv_widget_connection_status, 0);
        remoteViews.setViewVisibility(R.id.tv_widget_disconnection_status, 8);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.SettopWidgetView
    public void showSettopDisconnected(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.tv_widget_connection_status, 8);
        remoteViews.setViewVisibility(R.id.tv_widget_disconnection_status, 0);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.SettopWidgetView
    public void setButtonEvent(RemoteViews remoteViews, List<PendingIntent> list) {
        remoteViews.setOnClickPendingIntent(R.id.ib_btn_settop_widget_power, list.get(0));
        remoteViews.setOnClickPendingIntent(R.id.btn_channel_up, list.get(1));
        remoteViews.setOnClickPendingIntent(R.id.btn_channel_down, list.get(2));
        remoteViews.setOnClickPendingIntent(R.id.btn_volume_up, list.get(3));
        remoteViews.setOnClickPendingIntent(R.id.btn_volume_down, list.get(4));
    }

    @Override // kr.switcher.switcherm.ui.widget.view.SettopWidgetView
    public void updateAppWidget(AppWidgetManager appWidgetManager, int i, RemoteViews remoteViews) {
        appWidgetManager.updateAppWidget(i, remoteViews);
        IOLog.d(TAG, "update app widget (widget id:" + i + ")");
    }
}
