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
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.preference.WidgetPreference;
import kr.switcher.switcherm.ui.widget.helper.WidgetAnimation;
import kr.switcher.switcherm.ui.widget.presenter.OneButtonWidgetPresenter;
import kr.switcher.switcherm.ui.widget.view.OneButtonWidgetView;

/* JADX INFO: loaded from: classes2.dex */
public class OneButtonWidget extends AppWidgetProvider implements OneButtonWidgetView {
    public static final String ACTION_ONE_BUTTON_WIDGET_STATE = "kr.switcher.switcherm.ui.widget.OneButtonWidget.WIDGET_STATE";
    private static final String TAG = "OneButtonWidget";
    private OneButtonWidgetPresenter presenter;

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        IOLog.d(TAG, "onEnabled()");
        super.onEnabled(context);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IOLog.d(TAG, "onReceive()");
        super.onReceive(context, intent);
        int[] existedOneButtonWidgetIds = WidgetIdFinder.getExistedOneButtonWidgetIds(context);
        if (existedOneButtonWidgetIds.length > 0) {
            onUpdate(context, AppWidgetManager.getInstance(context), existedOneButtonWidgetIds);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        OneButtonWidgetPresenter oneButtonWidgetPresenter = new OneButtonWidgetPresenter(this, SwitcherHandler.getInstance(), new WidgetPreference(), context);
        this.presenter = oneButtonWidgetPresenter;
        oneButtonWidgetPresenter.onUpdate(context, appWidgetManager, iArr);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] iArr) {
        OneButtonWidgetPresenter oneButtonWidgetPresenter = new OneButtonWidgetPresenter(this, SwitcherHandler.getInstance(), new WidgetPreference(), context);
        this.presenter = oneButtonWidgetPresenter;
        oneButtonWidgetPresenter.onDeleted(iArr);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.OneButtonWidgetView
    public void showDisabled(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str) {
        WidgetAnimation.getInstance().stopAnimation(i);
        remoteViews.setViewVisibility(R.id.lin_controller, 0);
        remoteViews.setViewVisibility(R.id.disabled, 0);
        remoteViews.setViewVisibility(R.id.connected, 8);
        remoteViews.setViewVisibility(R.id.ble_permission_one_button, 8);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.OneButtonWidgetView
    public void showConnected(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str) {
        WidgetAnimation.getInstance().stopAnimation(i);
        remoteViews.setViewVisibility(R.id.lin_controller, 0);
        remoteViews.setViewVisibility(R.id.connected, 0);
        remoteViews.setViewVisibility(R.id.disabled, 8);
        remoteViews.setViewVisibility(R.id.ble_permission_one_button, 8);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.OneButtonWidgetView
    public void showConnecting(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str) {
        WidgetAnimation.getInstance().startAnimation(remoteViews, appWidgetManager, i, str);
        remoteViews.setViewVisibility(R.id.lin_controller, 0);
        remoteViews.setViewVisibility(R.id.ble_permission_one_button, 8);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.OneButtonWidgetView
    public void showNoBlePermission(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.lin_controller, 8);
        remoteViews.setViewVisibility(R.id.ble_permission_one_button, 0);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.OneButtonWidgetView
    public void setSwitcherName(RemoteViews remoteViews, String str) {
        remoteViews.setTextViewText(R.id.tv_switcher_name, str);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.OneButtonWidgetView
    public void setButtonEvent(RemoteViews remoteViews, List<PendingIntent> list) {
        remoteViews.setOnClickPendingIntent(R.id.btn_left, list.get(0));
        remoteViews.setOnClickPendingIntent(R.id.btn_right, list.get(1));
        remoteViews.setOnClickPendingIntent(R.id.btn_left_switch, list.get(2));
        remoteViews.setOnClickPendingIntent(R.id.btn_right_switch, list.get(3));
        remoteViews.setOnClickPendingIntent(R.id.ble_permission_one_button, list.get(4));
    }

    @Override // kr.switcher.switcherm.ui.widget.view.OneButtonWidgetView
    public void updateAppWidget(AppWidgetManager appWidgetManager, int i, RemoteViews remoteViews) {
        appWidgetManager.updateAppWidget(i, remoteViews);
        IOLog.d(TAG, "update app widget (widget id:" + i + ")");
    }
}
