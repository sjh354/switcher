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
import kr.switcher.switcherm.preference.WidgetPreference;
import kr.switcher.switcherm.ui.widget.helper.WidgetAnimation;
import kr.switcher.switcherm.ui.widget.presenter.CheckerWidgetPresenter;
import kr.switcher.switcherm.ui.widget.view.CheckerWidgetView;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerWidget extends AppWidgetProvider implements CheckerWidgetView {
    public static final String ACTION_CHECKER_WIDGET_STATE = "kr.switcher.switcherm.ui.widget.CheckerWidget.WIDGET_STATE";
    private static final String TAG = "CheckerWidget";
    private CheckerWidgetPresenter presenter;

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        IOLog.d(TAG, "onEnabled()");
        super.onEnabled(context);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IOLog.d(TAG, "onReceive()");
        super.onReceive(context, intent);
        int[] existedCheckerWidgetIds = WidgetIdFinder.getExistedCheckerWidgetIds(context);
        if (existedCheckerWidgetIds.length > 0) {
            onUpdate(context, AppWidgetManager.getInstance(context), existedCheckerWidgetIds);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        CheckerWidgetPresenter checkerWidgetPresenter = new CheckerWidgetPresenter(this, IODeviceHandler.getInstance(), new WidgetPreference(), context);
        this.presenter = checkerWidgetPresenter;
        checkerWidgetPresenter.onUpdate(context, appWidgetManager, iArr);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] iArr) {
        CheckerWidgetPresenter checkerWidgetPresenter = new CheckerWidgetPresenter(this, IODeviceHandler.getInstance(), new WidgetPreference(), context);
        this.presenter = checkerWidgetPresenter;
        checkerWidgetPresenter.onDeleted(iArr);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.CheckerWidgetView
    public void showDisabled(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str) {
        WidgetAnimation.getInstance().stopAnimation(i);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.CheckerWidgetView
    public void showConnected(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str) {
        WidgetAnimation.getInstance().stopAnimation(i);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.CheckerWidgetView
    public void showConnecting(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str) {
        WidgetAnimation.getInstance().startAnimation(remoteViews, appWidgetManager, i, str);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.CheckerWidgetView
    public void setCheckerName(RemoteViews remoteViews, String str) {
        remoteViews.setTextViewText(R.id.tv_checker_name, str);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.CheckerWidgetView
    public void setButtonEvent(RemoteViews remoteViews, List<PendingIntent> list) {
        remoteViews.setOnClickPendingIntent(R.id.btn_refresh, list.get(0));
    }

    @Override // kr.switcher.switcherm.ui.widget.view.CheckerWidgetView
    public void updateAppWidget(AppWidgetManager appWidgetManager, int i, RemoteViews remoteViews) {
        appWidgetManager.updateAppWidget(i, remoteViews);
        IOLog.d(TAG, "update app widget (widget id:" + i + ")");
    }

    @Override // kr.switcher.switcherm.ui.widget.view.CheckerWidgetView
    public void setSurveillanceLevel(RemoteViews remoteViews, int i) {
        this.presenter.setSurveillanceLevel(remoteViews, i);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.CheckerWidgetView
    public void setCheckerSurveillanceIsActive(RemoteViews remoteViews, String str) {
        this.presenter.setCheckerSurveillanceIsActive(remoteViews, str);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.CheckerWidgetView
    public void showActiveInfo(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.checker_surveillance_active, 0);
        remoteViews.setViewVisibility(R.id.checker_surveillance_inactive, 8);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.CheckerWidgetView
    public void showInActiveInfo(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.checker_surveillance_active, 8);
        remoteViews.setViewVisibility(R.id.checker_surveillance_inactive, 0);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.CheckerWidgetView
    public void setCheckerRecentHistory(RemoteViews remoteViews, String str, String str2, String str3) {
        remoteViews.setTextViewText(R.id.tv_history_is_opened, str);
        remoteViews.setTextViewText(R.id.tv_history_date, str2);
        remoteViews.setTextViewText(R.id.tv_history_time, str3);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.CheckerWidgetView
    public void showBatteryEnough(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.checker_battery_enough, 0);
        remoteViews.setViewVisibility(R.id.checker_battery_low, 8);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.CheckerWidgetView
    public void showBatteryLow(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.checker_battery_enough, 8);
        remoteViews.setViewVisibility(R.id.checker_battery_low, 0);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.CheckerWidgetView
    public void showRefreshScreen(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.lin_controller, 8);
        remoteViews.setViewVisibility(R.id.lin_refresh, 0);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.CheckerWidgetView
    public void hideRefreshScreen(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.lin_refresh, 8);
        remoteViews.setViewVisibility(R.id.lin_controller, 0);
    }
}
