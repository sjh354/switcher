package kr.switcher.switcherm.ui.widget.presenter;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;
import java.util.List;
import kr.switcher.device.checker.Checker;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.preference.PreferenceHelper;
import kr.switcher.switcherm.preference.WidgetCheckerPreference;
import kr.switcher.switcherm.preference.WidgetPreference;
import kr.switcher.switcherm.service.IOService;
import kr.switcher.switcherm.service.WidgetService;
import kr.switcher.switcherm.ui.widget.presenter.helper.PendingIntentsMaker;
import kr.switcher.switcherm.ui.widget.view.CheckerWidgetView;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerWidgetPresenter {
    public static final String LEVEL_ONE = "1단계";
    public static final String LEVEL_TWO = "2단계";
    public static final int REFRESH = 0;
    private static final String TAG = "CheckerWidgetPresenter";
    private IODeviceHandler ioDeviceHandler;
    private WidgetPreference preference;
    private CheckerWidgetView view;

    public CheckerWidgetPresenter(CheckerWidgetView checkerWidgetView, IODeviceHandler iODeviceHandler, WidgetPreference widgetPreference, Context context) {
        this.view = checkerWidgetView;
        this.ioDeviceHandler = iODeviceHandler;
        this.preference = widgetPreference;
        PreferenceHelper.setContext(context);
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        for (int i : iArr) {
            updateAppWidget(context, appWidgetManager, i, new RemoteViews(context.getPackageName(), R.layout.widget_checker));
        }
    }

    public void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int i, RemoteViews remoteViews) {
        String str = TAG;
        IOLog.i(str, "Widget updated");
        String widgetCheckerAddress = this.preference.getWidgetCheckerAddress(i);
        String widgetCheckerRefreshFinished = new WidgetCheckerPreference().getWidgetCheckerRefreshFinished(i);
        IOLog.i(str, i + " is finish " + widgetCheckerRefreshFinished);
        Checker checker = (Checker) this.ioDeviceHandler.getDevice(widgetCheckerAddress);
        if (widgetCheckerRefreshFinished.equals("true")) {
            this.view.hideRefreshScreen(remoteViews);
            IOLog.i(str, "hideRefreshScreen");
            if (checker != null) {
                this.view.setCheckerName(remoteViews, checker.getName());
            } else {
                this.view.setCheckerName(remoteViews, "찾을 수 없음");
            }
            if (new WidgetCheckerPreference().getWidgetCheckerBattery(i).equals("충분")) {
                this.view.showBatteryEnough(remoteViews);
            } else {
                this.view.showBatteryLow(remoteViews);
            }
            this.view.setButtonEvent(remoteViews, getButtonPendingIntents(context, i));
            this.view.setCheckerSurveillanceIsActive(remoteViews, new WidgetCheckerPreference().getWidgetCheckerSurveillanceIsActive(i));
            this.view.setSurveillanceLevel(remoteViews, new WidgetCheckerPreference().getWidgetCheckerSurveillanceLevel(i));
            this.view.setCheckerRecentHistory(remoteViews, new WidgetCheckerPreference().getWidgetCheckerLastHistoryIsOpened(i), new WidgetCheckerPreference().getWidgetCheckerLastHistoryDate(i), new WidgetCheckerPreference().getWidgetCheckerLastHistoryTime(i));
        } else if (widgetCheckerRefreshFinished.equals("false")) {
            this.view.showRefreshScreen(remoteViews);
        }
        this.view.updateAppWidget(appWidgetManager, i, remoteViews);
    }

    private List<PendingIntent> getButtonPendingIntents(Context context, int i) {
        Intent[] intentArr = new Intent[2];
        for (int i2 = 0; i2 < 2; i2++) {
            Intent intent = new Intent(context, (Class<?>) WidgetService.class);
            intentArr[i2] = intent;
            intent.setData(Uri.parse(String.valueOf(i)));
            if (i2 % 2 == 0) {
                intentArr[i2].putExtra(IOService.PARM_CHECKER_REFRESH_BUTTON, 0);
            }
        }
        return PendingIntentsMaker.makePendingIntents(context, intentArr);
    }

    public void onDeleted(int[] iArr) {
        for (int i : iArr) {
            this.preference.setWidgetSwitcherAddress(i, this.preference.getWidgetCheckerAddress(i));
            Log.i(TAG, "delete widget (id:" + i + ")");
        }
    }

    public void setSurveillanceLevel(RemoteViews remoteViews, int i) {
        if (i == 1) {
            remoteViews.setTextViewText(R.id.tv_surveillance_level, LEVEL_ONE);
        } else if (i == 2) {
            remoteViews.setTextViewText(R.id.tv_surveillance_level, LEVEL_TWO);
        }
    }

    public void setCheckerSurveillanceIsActive(RemoteViews remoteViews, String str) {
        if (str.equals("True")) {
            this.view.showActiveInfo(remoteViews);
        } else if (str.equals("False")) {
            this.view.showInActiveInfo(remoteViews);
        }
    }
}
