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
import kr.switcher.switcherm.ui.widget.presenter.TwoButtonWidgetPresenter;
import kr.switcher.switcherm.ui.widget.view.TwoButtonWidgetView;

/* JADX INFO: loaded from: classes2.dex */
public class TwoButtonWidget extends AppWidgetProvider implements TwoButtonWidgetView {
    public static final String ACTION_TWO_BUTTON_WIDGET_STATE = "kr.switcher.switcherm.ui.widget.TwoButtonWidget.WIDGET_STATE";
    private static final String TAG = "TwoButtonWidget";
    private TwoButtonWidgetPresenter presenter;

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        IOLog.d(TAG, "onEnabled()");
        super.onEnabled(context);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IOLog.d(TAG, "onReceive()");
        super.onReceive(context, intent);
        int[] existedTwoButtonWidgetIds = WidgetIdFinder.getExistedTwoButtonWidgetIds(context);
        if (existedTwoButtonWidgetIds == null || existedTwoButtonWidgetIds.length <= 0) {
            return;
        }
        onUpdate(context, AppWidgetManager.getInstance(context), existedTwoButtonWidgetIds);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        TwoButtonWidgetPresenter twoButtonWidgetPresenter = new TwoButtonWidgetPresenter(this, SwitcherHandler.getInstance(), new WidgetPreference(), context);
        this.presenter = twoButtonWidgetPresenter;
        twoButtonWidgetPresenter.onUpdate(context, appWidgetManager, iArr);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] iArr) {
        TwoButtonWidgetPresenter twoButtonWidgetPresenter = new TwoButtonWidgetPresenter(this, SwitcherHandler.getInstance(), new WidgetPreference(), context);
        this.presenter = twoButtonWidgetPresenter;
        twoButtonWidgetPresenter.onDeleted(iArr);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.TwoButtonWidgetView
    public void showDisabled(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str) {
        WidgetAnimation.getInstance().stopAnimation(i);
        remoteViews.setViewVisibility(R.id.lin_controller, 0);
        remoteViews.setViewVisibility(R.id.disabled, 0);
        remoteViews.setViewVisibility(R.id.connected, 8);
        remoteViews.setViewVisibility(R.id.ble_permission_two_button, 8);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.TwoButtonWidgetView
    public void showConnected(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str) {
        WidgetAnimation.getInstance().stopAnimation(i);
        remoteViews.setViewVisibility(R.id.lin_controller, 0);
        remoteViews.setViewVisibility(R.id.connected, 0);
        remoteViews.setViewVisibility(R.id.disabled, 8);
        remoteViews.setViewVisibility(R.id.ble_permission_two_button, 8);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.TwoButtonWidgetView
    public void showConnecting(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str) {
        WidgetAnimation.getInstance().startAnimation(remoteViews, appWidgetManager, i, str);
        remoteViews.setViewVisibility(R.id.lin_controller, 0);
        remoteViews.setViewVisibility(R.id.ble_permission_two_button, 8);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.TwoButtonWidgetView
    public void showNoBlePermission(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.lin_controller, 8);
        remoteViews.setViewVisibility(R.id.ble_permission_two_button, 0);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.TwoButtonWidgetView
    public void setSwitcherName(RemoteViews remoteViews, String str) {
        IOLog.i(TAG, "widget switcher name : " + str);
        remoteViews.setTextViewText(R.id.tv_switcher_name, str);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.TwoButtonWidgetView
    public void setButtonEvent(RemoteViews remoteViews, List<PendingIntent> list) {
        remoteViews.setOnClickPendingIntent(R.id.btn_top_left, list.get(0));
        remoteViews.setOnClickPendingIntent(R.id.btn_top_right, list.get(1));
        remoteViews.setOnClickPendingIntent(R.id.btn_bottom_left, list.get(2));
        remoteViews.setOnClickPendingIntent(R.id.btn_bottom_right, list.get(3));
        remoteViews.setOnClickPendingIntent(R.id.btn_top_left_switch, list.get(4));
        remoteViews.setOnClickPendingIntent(R.id.btn_top_right_switch, list.get(5));
        remoteViews.setOnClickPendingIntent(R.id.btn_bottom_left_switch, list.get(6));
        remoteViews.setOnClickPendingIntent(R.id.btn_bottom_right_switch, list.get(7));
        remoteViews.setOnClickPendingIntent(R.id.ble_permission_two_button, list.get(8));
    }

    @Override // kr.switcher.switcherm.ui.widget.view.TwoButtonWidgetView
    public void updateAppWidget(AppWidgetManager appWidgetManager, int i, RemoteViews remoteViews) {
        appWidgetManager.updateAppWidget(i, remoteViews);
        IOLog.i(TAG, "update app widget (id:" + i + ")");
    }
}
