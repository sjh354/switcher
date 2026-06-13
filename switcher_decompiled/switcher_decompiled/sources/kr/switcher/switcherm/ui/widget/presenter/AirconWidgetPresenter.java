package kr.switcher.switcherm.ui.widget.presenter;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;
import java.util.List;
import kr.switcher.device.linker.Linker;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.linker.LinkerHandler;
import kr.switcher.switcherm.preference.PreferenceHelper;
import kr.switcher.switcherm.preference.WidgetPreference;
import kr.switcher.switcherm.service.IOService;
import kr.switcher.switcherm.service.WidgetService;
import kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor;
import kr.switcher.switcherm.ui.widget.presenter.helper.PendingIntentsMaker;
import kr.switcher.switcherm.ui.widget.view.AirconWidgetView;

/* JADX INFO: loaded from: classes2.dex */
public class AirconWidgetPresenter {
    public static final int AIRCON_OFF = 1;
    public static final int AIRCON_ON = 0;
    public static final int FIFTH_TEMPERATURE_SET = 6;
    public static final int FIRST_TEMPERATURE_SET = 2;
    public static final int FOURTH_TEMPERATURE_SET = 5;
    public static final int REFRESH = 7;
    public static final int SECOND_TEMPERATURE_SET = 3;
    private static final String TAG = "AirconWidgetPresenter";
    public static final int THIRD_TEMPERATURE_SET = 4;
    public static final int UPDATE_TEMPERATURE = 8;
    private GetCurrentSensorValueForWidgetInteractor interactor;
    private IODeviceHandler ioDeviceHandler;
    private Linker linker;
    private LinkerHandler linkerHandler;
    private WidgetPreference preference;
    private AirconWidgetView view;

    public AirconWidgetPresenter(AirconWidgetView airconWidgetView, IODeviceHandler iODeviceHandler, LinkerHandler linkerHandler, WidgetPreference widgetPreference, Context context, GetCurrentSensorValueForWidgetInteractor getCurrentSensorValueForWidgetInteractor) {
        this.view = airconWidgetView;
        this.ioDeviceHandler = iODeviceHandler;
        this.preference = widgetPreference;
        this.interactor = getCurrentSensorValueForWidgetInteractor;
        this.linkerHandler = linkerHandler;
        PreferenceHelper.setContext(context);
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        for (int i : iArr) {
            updateAppWidget(context, appWidgetManager, i, new RemoteViews(context.getPackageName(), R.layout.widget_aircon));
        }
    }

    public void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int i, RemoteViews remoteViews) {
        String widgetSwitcherAddress = this.preference.getWidgetSwitcherAddress(i);
        Boolean airconWidgetRefreshFinished = this.preference.getAirconWidgetRefreshFinished(i);
        String widgetAliveLinker = this.preference.getWidgetAliveLinker();
        findActiveLinker();
        Remocon remocon = (Remocon) this.ioDeviceHandler.getDevice(widgetSwitcherAddress);
        if (remocon != null) {
            this.view.setAirconName(remoteViews, remocon.getName());
        }
        if (!airconWidgetRefreshFinished.booleanValue()) {
            this.view.showRefresh(remoteViews);
        } else if (widgetAliveLinker.length() > 1) {
            this.view.showConnected(remoteViews, appWidgetManager, i, widgetSwitcherAddress);
            if (!this.preference.getWidgetLinkerTemperature(i).equals("")) {
                this.view.setAirconTemperature(remoteViews, this.preference.getWidgetLinkerTemperature(i));
            }
        } else {
            this.view.showDisabled(remoteViews, appWidgetManager, i, widgetSwitcherAddress);
        }
        this.view.setButtonEvent(remoteViews, getButtonPendingIntents(context, i));
        this.view.updateAppWidget(appWidgetManager, i, remoteViews);
    }

    private void findActiveLinker() {
        final String widgetAliveLinker = new WidgetPreference().getWidgetAliveLinker();
        new GetCurrentSensorValueForWidgetInteractor().getAliveLinker(new GetCurrentSensorValueForWidgetInteractor.OnGetAliveLinkerListener() { // from class: kr.switcher.switcherm.ui.widget.presenter.AirconWidgetPresenter.1
            @Override // kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor.OnGetAliveLinkerListener
            public void onError() {
            }

            @Override // kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor.OnGetAliveLinkerListener
            public void onFindAliveLinker(String str) {
                String widgetAliveLinker2 = new WidgetPreference().getWidgetAliveLinker();
                if (widgetAliveLinker.equals(widgetAliveLinker2)) {
                    return;
                }
                new WidgetPreference().setWidgetAliveLinker(widgetAliveLinker2);
                IOUtil.sendBroadcastToAirconWidget();
            }
        });
    }

    private List<PendingIntent> getButtonPendingIntents(Context context, int i) {
        Intent[] intentArr = new Intent[9];
        for (int i2 = 0; i2 < 9; i2++) {
            Intent intent = new Intent(context, (Class<?>) WidgetService.class);
            intentArr[i2] = intent;
            intent.setData(Uri.parse(String.valueOf(i)));
            int i3 = i2 % 9;
            if (i3 == 0) {
                intentArr[i2].putExtra(IOService.PARM_AIRCON_BUTTON, 0);
            } else if (i3 == 1) {
                intentArr[i2].putExtra(IOService.PARM_AIRCON_BUTTON, 1);
            } else if (i3 == 2) {
                intentArr[i2].putExtra(IOService.PARM_AIRCON_BUTTON, 2);
            } else if (i3 == 3) {
                intentArr[i2].putExtra(IOService.PARM_AIRCON_BUTTON, 3);
            } else if (i3 == 4) {
                intentArr[i2].putExtra(IOService.PARM_AIRCON_BUTTON, 4);
            } else if (i3 == 5) {
                intentArr[i2].putExtra(IOService.PARM_AIRCON_BUTTON, 5);
            } else if (i3 == 6) {
                intentArr[i2].putExtra(IOService.PARM_AIRCON_BUTTON, 6);
            } else if (i3 == 7) {
                intentArr[i2].putExtra(IOService.PARM_AIRCON_BUTTON, 7);
            } else if (i3 == 8) {
                intentArr[i2].putExtra(IOService.PARM_AIRCON_BUTTON, 8);
            }
        }
        return PendingIntentsMaker.makePendingIntents(context, intentArr);
    }

    public void onDeleted(int[] iArr) {
        for (int i : iArr) {
            this.preference.setWidgetSwitcherAddress(i, this.preference.getWidgetSwitcherAddress(i));
            Log.i(TAG, "delete widget (id:" + i + ")");
        }
    }

    public void onFindAliveLinker(String str) {
        if (str != null) {
            this.preference.setWidgetAliveLinker(str);
            IOUtil.sendBroadcastToAirconWidget();
        } else {
            this.preference.setWidgetAliveLinker("'");
            IOLog.i(TAG, "not found alive linker");
            IOUtil.sendBroadcastToAirconWidget();
        }
    }
}
