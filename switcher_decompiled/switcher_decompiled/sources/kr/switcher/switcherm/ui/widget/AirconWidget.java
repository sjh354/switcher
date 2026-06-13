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
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.linker.LinkerHandler;
import kr.switcher.switcherm.preference.WidgetPreference;
import kr.switcher.switcherm.ui.widget.helper.WidgetAnimation;
import kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor;
import kr.switcher.switcherm.ui.widget.presenter.AirconWidgetPresenter;
import kr.switcher.switcherm.ui.widget.view.AirconWidgetView;

/* JADX INFO: loaded from: classes2.dex */
public class AirconWidget extends AppWidgetProvider implements AirconWidgetView, GetCurrentSensorValueForWidgetInteractor.OnGetCurrentSensorValueListener, GetCurrentSensorValueForWidgetInteractor.OnGetAliveLinkerListener {
    public static final String ACTION_AIRCON_WIDGET_STATE = "kr.switcher.switcherm.ui.widget.AirconWidget.WIDGET_STATE";
    private static final String TAG = "AirconWidget";
    private AirconWidgetPresenter presenter;

    @Override // kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor.OnGetCurrentSensorValueListener
    public void onFind(String str) {
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        IOLog.d(TAG, "onEnabled()");
        super.onEnabled(context);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IOLog.d(TAG, "onReceive()");
        super.onReceive(context, intent);
        int[] existedAirconWidgetIds = WidgetIdFinder.getExistedAirconWidgetIds(context);
        if (existedAirconWidgetIds.length > 0) {
            onUpdate(context, AppWidgetManager.getInstance(context), existedAirconWidgetIds);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        AirconWidgetPresenter airconWidgetPresenter = new AirconWidgetPresenter(this, IODeviceHandler.getInstance(), LinkerHandler.getInstance(), new WidgetPreference(), context, new GetCurrentSensorValueForWidgetInteractor(this, this));
        this.presenter = airconWidgetPresenter;
        airconWidgetPresenter.onUpdate(context, appWidgetManager, iArr);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] iArr) {
        AirconWidgetPresenter airconWidgetPresenter = new AirconWidgetPresenter(this, IODeviceHandler.getInstance(), LinkerHandler.getInstance(), new WidgetPreference(), context, new GetCurrentSensorValueForWidgetInteractor(this, this));
        this.presenter = airconWidgetPresenter;
        airconWidgetPresenter.onDeleted(iArr);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.AirconWidgetView
    public void showDisabled(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str) {
        WidgetAnimation.getInstance().stopAnimation(i);
        remoteViews.setViewVisibility(R.id.lin_controller, 0);
        remoteViews.setViewVisibility(R.id.disabled, 0);
        remoteViews.setViewVisibility(R.id.connected, 8);
        remoteViews.setViewVisibility(R.id.tv_disconnected, 0);
        remoteViews.setViewVisibility(R.id.lin_temperature_set, 8);
        remoteViews.setViewVisibility(R.id.refreshing, 8);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.AirconWidgetView
    public void showConnected(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str) {
        WidgetAnimation.getInstance().stopAnimation(i);
        remoteViews.setViewVisibility(R.id.lin_controller, 0);
        remoteViews.setViewVisibility(R.id.connected, 0);
        remoteViews.setViewVisibility(R.id.disabled, 8);
        remoteViews.setViewVisibility(R.id.refreshing, 8);
        remoteViews.setViewVisibility(R.id.tv_disconnected, 8);
        remoteViews.setViewVisibility(R.id.lin_temperature_set, 0);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.AirconWidgetView
    public void showConnecting(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str) {
        WidgetAnimation.getInstance().startAnimation(remoteViews, appWidgetManager, i, str);
        remoteViews.setViewVisibility(R.id.lin_controller, 0);
        remoteViews.setViewVisibility(R.id.ble_permission_one_button, 8);
        remoteViews.setViewVisibility(R.id.disabled, 8);
        remoteViews.setViewVisibility(R.id.connected, 8);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.AirconWidgetView
    public void setAirconName(RemoteViews remoteViews, String str) {
        remoteViews.setTextViewText(R.id.tv_switcher_name, str);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.AirconWidgetView
    public void setAirconTemperature(RemoteViews remoteViews, String str) {
        remoteViews.setViewVisibility(R.id.rl_temperature_set, 0);
        remoteViews.setTextViewText(R.id.tv_temperature_text, str);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.AirconWidgetView
    public void hideAirconTemperature(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.rl_temperature_set, 8);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.AirconWidgetView
    public void showRefresh(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.refreshing, 0);
        remoteViews.setViewVisibility(R.id.disabled, 8);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.AirconWidgetView
    public void setButtonEvent(RemoteViews remoteViews, List<PendingIntent> list) {
        remoteViews.setOnClickPendingIntent(R.id.btn_aircon_on, list.get(0));
        remoteViews.setOnClickPendingIntent(R.id.btn_aircon_off, list.get(1));
        remoteViews.setOnClickPendingIntent(R.id.temperature_1st, list.get(2));
        remoteViews.setOnClickPendingIntent(R.id.temperature_2nd, list.get(3));
        remoteViews.setOnClickPendingIntent(R.id.temperature_3rd, list.get(4));
        remoteViews.setOnClickPendingIntent(R.id.temperature_4th, list.get(5));
        remoteViews.setOnClickPendingIntent(R.id.temperature_5th, list.get(6));
        remoteViews.setOnClickPendingIntent(R.id.disabled, list.get(7));
        remoteViews.setOnClickPendingIntent(R.id.ib_refresh, list.get(8));
    }

    @Override // kr.switcher.switcherm.ui.widget.view.AirconWidgetView
    public void updateAppWidget(AppWidgetManager appWidgetManager, int i, RemoteViews remoteViews) {
        appWidgetManager.updateAppWidget(i, remoteViews);
        IOLog.d(TAG, "update app widget (widget id:" + i + ")");
    }

    @Override // kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor.OnGetAliveLinkerListener
    public void onFindAliveLinker(String str) {
        this.presenter.onFindAliveLinker(str);
    }

    @Override // kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor.OnGetAliveLinkerListener
    public void onError() {
        IOUtil.showToast(IOUtil.getStringResource(R.string.widget_not_found_linker));
    }
}
